package particles

import (
	"math/rand"
	"project-particles/config"
)

/* NewSystem est une fonction qui initialise un système de particules et le
retourne à la fonction principale du projet, qui se chargera de l'afficher.*/
func NewSystem() System {
	//création du systeme
	var tab []Particle = []Particle{}

	//Nombre de particules initiales
	nbr := config.General.InitNumParticles
	for i := 1; i <= nbr; i++ {

		//gestion du spawn
		var x, y float64
		if !config.General.RandomSpawn {
			x = float64(config.General.SpawnX)
			y = float64(config.General.SpawnY)
		} else {
			x = float64(rand.Intn(config.General.WindowSizeX))
			y = float64(rand.Intn(config.General.WindowSizeY))
		}

		//création d'une particule
		var P Particle = Particle{
			PositionX: x,
			PositionY: y,
			Vitesse:   []float64{-1*config.General.Vitesse + rand.Float64()*2*config.General.Vitesse, -1*config.General.Vitesse + rand.Float64()*2*config.General.Vitesse},
			ScaleX:    config.General.TailleX, ScaleY: config.General.TailleY,
			ColorRed: config.General.Rouge, ColorGreen: config.General.Vert, ColorBlue: config.General.Bleu,
			Opacity: 1,
		}
		tab = append(tab, P)
	}
	return System{Content: tab}

}
