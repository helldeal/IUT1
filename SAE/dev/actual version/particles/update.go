package particles

import (
	"math"
	"project-particles/config"

	"github.com/hajimehoshi/ebiten/v2"
)

// Update mets à jour l'état du système de particules (c'est-à-dire l'état de
// chacune des particules) à chaque pas de temps. Elle est appellée exactement
// 60 fois par seconde (de manière régulière) par la fonction principale du
// projet.

func (s *System) Update() {
	if config.General.Generation {
		Generation(s)
	}

	for i := 0; i < len(s.Content); i++ {
		if s.Content[i].PositionY < float64(config.General.WindowSizeY+config.General.MargeOut) &&
			s.Content[i].PositionY > float64(-config.General.MargeOut) &&
			s.Content[i].PositionX < float64(config.General.WindowSizeX+config.General.MargeOut) &&
			s.Content[i].PositionX > float64(-config.General.MargeOut) {

			//Apparition d'une particule apres un certain temps
			if s.Content[i].Vie == config.General.Rayon && !s.Content[i].Xplode && !s.Content[i].Trail {
				s.Content[i].Opacity = 1
			}

			//Fondu de la Particule (Une fois seulement visible)
			if s.Content[i].Vie >= config.General.Rayon {
				s.Content[i].Opacity -= config.General.Fondu
			}

			//Fondu des particules de la trainée
			if s.Content[i].Trail {
				s.Content[i].Opacity -= 0.02
				s.Content[i].ScaleX *= 0.99
				s.Content[i].ScaleY *= 0.99
			}
			//Durée de vie de la particule qui correspond au nombre d'update effectuée
			s.Content[i].Vie += 1

			//Accélaration de la vitesse
			s.Content[i].Vitesse[0] *= config.General.Accel
			s.Content[i].Vitesse[1] *= config.General.Accel
			s.Content[i].PositionX += s.Content[i].Vitesse[0]
			s.Content[i].PositionY += s.Content[i].Vitesse[1]

			//Gravité
			if config.General.Gravite {
				s.Content[i].Gravite += config.General.VitesseGravite
				s.Content[i].PositionY += s.Content[i].Gravite
			}

			//Orbite
			if config.General.Orbite {
				config.General.Xplode = false
				config.General.Trail = false
				x := float64(config.General.SpawnX) - s.Content[i].PositionX
				y := float64(config.General.SpawnY) - s.Content[i].PositionY
				if config.General.OrbiteCursor {
					cx, cy := ebiten.CursorPosition()
					x = float64(cx) - s.Content[i].PositionX
					y = float64(cy) - s.Content[i].PositionY
				}
				d := math.Sqrt(x*x + y*y)
				if d < 2000 {
					if x/d < 100 {
						s.Content[i].Vitesse[0] += x / d
					}
					if y/d < 100 {
						s.Content[i].Vitesse[1] += y / d
					}
				}
			}

			//Rotation
			if config.General.Rotationb {
				s.Content[i].Rotation += config.General.Rotation
			}

			//Création d'une Trainée pour une particule
			if config.General.Trail && !s.Content[i].Trail && !s.Content[i].Xplode {
				Trail(s, s.Content[i])
			}

			//Variation des différentes couleurs
			if !s.Content[i].Xplode {
				s.Content[i].ColorGreen += config.General.VFondu
				s.Content[i].ColorBlue += config.General.BFondu
				s.Content[i].ColorRed += config.General.RFondu
			}

			//Collision des bords exterieurs avec physique liée à la gravité (frottemments et rebonds)
			if config.General.Collision {
				if s.Content[i].PositionY > float64(config.General.WindowSizeY)-5*s.Content[i].ScaleX ||
					s.Content[i].PositionY < float64(0)+5*s.Content[i].ScaleX {
					if s.Content[i].PositionY < float64(0)+5*s.Content[i].ScaleX {
						s.Content[i].PositionY = 5 * s.Content[i].ScaleX
					} else {
						s.Content[i].PositionY = float64(config.General.WindowSizeY) - 5*s.Content[i].ScaleX
					}
					if config.General.Gravite {
						s.Content[i].Gravite = -(s.Content[i].Gravite + s.Content[i].Vitesse[1]) / 1.5
						s.Content[i].Vitesse[1] = 0
						s.Content[i].Vitesse[0] *= 0.97
					} else {
						s.Content[i].Vitesse[1] = -s.Content[i].Vitesse[1]
					}
				}
				if s.Content[i].PositionX > float64(config.General.WindowSizeX)-5*s.Content[i].ScaleX ||
					s.Content[i].PositionX < float64(0)+5*s.Content[i].ScaleX {
					if s.Content[i].PositionX < float64(0)+5*s.Content[i].ScaleX {
						s.Content[i].PositionX = 5 * s.Content[i].ScaleX
					} else {
						s.Content[i].PositionX = float64(config.General.WindowSizeX) - 5*s.Content[i].ScaleX
					}
					s.Content[i].Vitesse[0] = -s.Content[i].Vitesse[0]
				}
			}

			//Ne marche pas encore
			/*if config.General.CollisionP {
				for y := 0; y < len(s.Content); y++ {
					if !s.Content[i].Trail && !s.Content[i].Xplode && i != y {

					}
				}
			}*/

			//Création d'une Explosion pour une particule morte
			if s.Content[i].Vie == config.General.Vie && config.General.Xplode && !s.Content[i].Trail && !s.Content[i].Xplode {
				Xplode(s, s.Content[i])
			}

			//Update de l'explosion
			if s.Content[i].Xplode {
				s.Content[i].Opacity -= 0.002
				s.Content[i].ColorGreen -= 0.004
				s.Content[i].Vitesse[0] *= 0.99
				s.Content[i].Vitesse[1] *= 0.99
				s.Content[i].ScaleX *= 0.99
				s.Content[i].ScaleY *= 0.99
			}

			//La particule meurt si elle dépasse ca durée de vie
			if s.Content[i].Vie > config.General.Vie {
				s.Content[i].Mort = true
			}

			//La particule meurt si elle n'est plus visible (lien avec le fondu de la particule)
			if s.Content[i].Opacity < 0 {
				s.Content[i].Mort = true
			}

			//La particule meurt si elle n'est plus visible (Champs de vision / sort de la fenetre)
		} else {
			s.Content[i].Mort = true
		}
	}

}

var SpawnAct float64 = 0

//fonction qui génére des particules
func Generation(s *System) {
	SpawnAct += config.General.SpawnRate
	for SpawnAct >= 1 {
		SpawnAct -= 1
		P := create()
		attrib := false
		for z := 0; z < len(s.Content); z++ {
			if s.Content[z].Mort {
				s.Content[z] = P
				z = len(s.Content)
				attrib = true
			}
		}
		if len(s.Content) < config.General.MaxParticles && !attrib {
			s.Content = append(s.Content, P)
		}
	}
}
