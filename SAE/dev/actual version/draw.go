package main

import (
	"fmt"
	"image/color"
	"project-particles/assets"
	"project-particles/config"
	"project-particles/particles"
	"strconv"
	"time"

	"github.com/hajimehoshi/ebiten/v2"
	"github.com/hajimehoshi/ebiten/v2/ebitenutil"
	"github.com/hajimehoshi/ebiten/v2/inpututil"
)

// Draw se charge d'afficher à l'écran l'état actuel du système de particules
// g.system. Elle est appelée automatiquement environ 60 fois par seconde par
// la bibliothèque Ebiten. Cette fonction pourra être légèrement modifiée quand
// c'est précisé dans le sujet.

var configact int = 1
var configindex int = 0
var startime time.Time

func (g *game) Draw(screen *ebiten.Image) {
	screen.Fill(color.NRGBA{0x00, 0x00, 0x00, 0xff})
	for _, p := range g.system.Content {
		if !p.Mort {
			options := ebiten.DrawImageOptions{}
			options.GeoM.Translate(-5, -5)
			options.GeoM.Rotate(p.Rotation)
			options.GeoM.Scale(p.ScaleX, p.ScaleY)
			options.GeoM.Translate(p.PositionX, p.PositionY)
			options.ColorM.Scale(p.ColorRed, p.ColorGreen, p.ColorBlue, p.Opacity)
			screen.DrawImage(assets.ParticleImage, &options)
			//ebitenutil.DrawRect(screen, p.PositionX-5, p.PositionY-5, 10, 10, color.RGBA{255, 0, 0, 100})

		}
	}
	if config.General.Debug {
		ebitenutil.DebugPrintAt(screen, fmt.Sprint("TPS : ", ebiten.CurrentTPS()), 0, 0)
		ebitenutil.DebugPrintAt(screen, fmt.Sprint("Nombre de particules : ", len(g.system.Content)), 0, 20)
	}

	//Changement de Config
	if !config.General.ConfigMod {
		ebitenutil.DebugPrintAt(screen, "Passer en mode modulation (ECHAP)", 5, 60)
		ebitenutil.DebugPrintAt(screen, "<", config.General.WindowSizeX/2-50, 40)
		ebitenutil.DebugPrintAt(screen, ">", config.General.WindowSizeX/2+50, 40)
		if switchconfig == 1 {
			if configact != switchconfig {
				config.Get("config/config.json")
			}
			ebitenutil.DebugPrintAt(screen, "Config Libre", config.General.WindowSizeX/2-30, 40)
			configact = switchconfig
		}
		if switchconfig == 2 {
			if configact != switchconfig {
				config.Get("config/HyperSpace.json")
			}
			ebitenutil.DebugPrintAt(screen, "HyperSpace", config.General.WindowSizeX/2-25, 40)
			configact = switchconfig
		}
		if switchconfig == 3 {
			if configact != switchconfig {
				config.Get("config/Invoc.json")
			}
			ebitenutil.DebugPrintAt(screen, "Invoc", config.General.WindowSizeX/2-15, 40)
			configact = switchconfig
		}
		if switchconfig == 4 {
			if configact != switchconfig {
				config.Get("config/Matrix.json")
			}
			ebitenutil.DebugPrintAt(screen, "Matrix", config.General.WindowSizeX/2-15, 40)
			configact = switchconfig
		}
		if switchconfig == 5 {
			if configact != switchconfig {
				config.Get("config/Fireworks.json")
			}
			ebitenutil.DebugPrintAt(screen, "Fireworks", config.General.WindowSizeX/2-20, 40)
			configact = switchconfig
		}
		if switchconfig == 6 {
			if configact != switchconfig {
				config.Get("config/Confétis.json")
			}
			ebitenutil.DebugPrintAt(screen, "Confétis", config.General.WindowSizeX/2-18, 40)
			configact = switchconfig
		}
		if switchconfig == 7 {
			if configact != switchconfig {
				config.Get("config/Torche.json")
			}
			ebitenutil.DebugPrintAt(screen, "Torche", config.General.WindowSizeX/2-15, 40)
			configact = switchconfig
		}
		if switchconfig == 8 {
			if configact != switchconfig {
				config.Get("config/Crépit.json")
			}
			ebitenutil.DebugPrintAt(screen, "Crépit", config.General.WindowSizeX/2-15, 40)
			configact = switchconfig
		}
		if switchconfig == 9 {
			if configact != switchconfig {
				config.Get("config/Spiral.json")
			}
			ebitenutil.DebugPrintAt(screen, "Spiral", config.General.WindowSizeX/2-15, 40)
			configact = switchconfig
		}

		cx, cy := ebiten.CursorPosition()
		if cx > config.General.WindowSizeX/2-55 && cx < config.General.WindowSizeX/2-45 && cy > 40 && cy < 50 && inpututil.IsMouseButtonJustPressed(ebiten.MouseButtonLeft) {
			switchconfig--
			g.system.Content = []particles.Particle{}
			g.system = particles.NewSystem()
			if switchconfig < 1 {
				switchconfig = 9
			}
		}
		if cx > config.General.WindowSizeX/2+45 && cx < config.General.WindowSizeX/2+55 && cy > 40 && cy < 50 && inpututil.IsMouseButtonJustPressed(ebiten.MouseButtonLeft) {
			switchconfig++
			g.system.Content = []particles.Particle{}
			g.system = particles.NewSystem()
			if switchconfig > 9 {
				switchconfig = 1
			}
		}
	}

	//Switch Modification/Changement config
	if inpututil.IsKeyJustPressed(ebiten.KeyEscape) {
		config.General.ConfigMod = !config.General.ConfigMod
	}

	//Modification Config
	if config.General.ConfigMod {
		configtab := [][]string{
			{"Nombre max de particules : ", strconv.FormatFloat(float64(config.General.MaxParticles), 'f', -1, 64), "1", "0", "100000"},
			{"Génération : ", strconv.FormatBool(config.General.Generation), "bool"},
			{"Suivis du curseur : ", strconv.FormatBool(config.General.FollowCursor), "bool"},
			{"Spawn Aléatoire : ", strconv.FormatBool(config.General.RandomSpawn), "bool"},
			{"Spawn X : ", strconv.FormatFloat(float64(config.General.SpawnX), 'f', -1, 64), "1", "0", "100000"},
			{"Spawn Y : ", strconv.FormatFloat(float64(config.General.SpawnY), 'f', -1, 64), "1", "0", "100000"},
			{"Gravité : ", strconv.FormatBool(config.General.Gravite), "bool"},
			{"Force Gravité : ", strconv.FormatFloat(config.General.VitesseGravite, 'f', -1, 64), "0.001", "-10", "10"},
			{"Spawn Rate: ", strconv.FormatFloat(config.General.SpawnRate, 'f', -1, 64), "0.001", "0", "100"},
			{"Collision : ", strconv.FormatBool(config.General.Collision), "bool"},
			{"Rotation : ", strconv.FormatBool(config.General.Rotationb), "bool"},
			{"Vitesse Rotation : ", strconv.FormatFloat(config.General.Rotation, 'f', -1, 64), "0.001", "0", "10"},
			{"Vitesse Particule : ", strconv.FormatFloat(config.General.Vitesse, 'f', -1, 64), "0.01", "0", "100"},
			{"Accelération : ", strconv.FormatFloat(config.General.Accel, 'f', -1, 64), "0.001", "0", "2"},
			{"Fondu : ", strconv.FormatFloat(config.General.Fondu, 'f', -1, 64), "0.0001", "0", "0.1"},
			{"Rayon : ", strconv.FormatFloat(float64(config.General.Rayon), 'f', -1, 64), "1", "0", "1000"},
			{"Rouge : ", strconv.FormatFloat(config.General.Rouge, 'f', -1, 64), "0.001", "0", "1"},
			{"Vert : ", strconv.FormatFloat(config.General.Vert, 'f', -1, 64), "0.001", "0", "1"},
			{"Bleu : ", strconv.FormatFloat(config.General.Bleu, 'f', -1, 64), "0.001", "0", "1"},
			{"Variation de Rouge : ", strconv.FormatFloat(config.General.RFondu, 'f', -1, 64), "0.001", "-1", "1"},
			{"Variation de Vert : ", strconv.FormatFloat(config.General.VFondu, 'f', -1, 64), "0.001", "-1", "1"},
			{"Variation de Bleu : ", strconv.FormatFloat(config.General.BFondu, 'f', -1, 64), "0.001", "-1", "1"},
			{"Taille X: ", strconv.FormatFloat(config.General.TailleX, 'f', -1, 64), "0.01", "0", "10"},
			{"Taille Y : ", strconv.FormatFloat(config.General.TailleY, 'f', -1, 64), "0.01", "0", "10"},
			{"Temps de Vie : ", strconv.FormatFloat(float64(config.General.Vie), 'f', -1, 64), "1", "0", "10000"},
			{"Explosion de Mort : ", strconv.FormatBool(config.General.Xplode), "bool"},
			{"Trainée : ", strconv.FormatBool(config.General.Trail), "bool"},
			{"Mode Orbite : ", strconv.FormatBool(config.General.Orbite), "bool"},
			{"Orbite Curseur : ", strconv.FormatBool(config.General.OrbiteCursor), "bool"},
		}
		ebitenutil.DebugPrintAt(screen, "Menu : ", 5, 60)
		for i := 0; i < len(configtab); i++ {
			if i != configindex {
				ebitenutil.DebugPrintAt(screen, fmt.Sprint(configtab[i][0], configtab[i][1]), 5, 80+i*20)
			} else {
				ebitenutil.DebugPrintAt(screen, fmt.Sprint(configtab[configindex][0], configtab[configindex][1]), 25, 80+i*20)
			}
		}

		if configtab[configindex][2] == "bool" {
			if inpututil.IsKeyJustPressed(ebiten.KeyArrowLeft) {
				v, _ := strconv.ParseBool(configtab[configindex][1])
				v = !v
				configtab[configindex][1] = strconv.FormatBool(v)
			}
			if inpututil.IsKeyJustPressed(ebiten.KeyArrowRight) {
				v, _ := strconv.ParseBool(configtab[configindex][1])
				v = !v
				configtab[configindex][1] = strconv.FormatBool(v)
			}
		} else {
			if inpututil.IsKeyJustPressed(ebiten.KeyArrowLeft) {
				startime = time.Now()
			}
			if ebiten.IsKeyPressed(ebiten.KeyArrowLeft) {
				v, _ := strconv.ParseFloat(configtab[configindex][1], 64)
				m, _ := strconv.ParseFloat(configtab[configindex][3], 64)
				acttime := time.Now()
				timepassed := acttime.Sub(startime)
				if timepassed > 6000000000 {
					if v > m {
						r, _ := strconv.ParseFloat(configtab[configindex][2], 64)
						v -= 100 * r
						configtab[configindex][1] = strconv.FormatFloat(v, 'f', -1, 64)
					} else {
						configtab[configindex][1] = strconv.FormatFloat(m, 'f', -1, 64)
					}
				} else if timepassed > 3000000000 {
					if v > m {
						r, _ := strconv.ParseFloat(configtab[configindex][2], 64)
						v -= 10 * r
						configtab[configindex][1] = strconv.FormatFloat(v, 'f', -1, 64)
					} else {
						configtab[configindex][1] = strconv.FormatFloat(m, 'f', -1, 64)
					}
				} else {
					if v > m {
						r, _ := strconv.ParseFloat(configtab[configindex][2], 64)
						v -= r
						configtab[configindex][1] = strconv.FormatFloat(v, 'f', -1, 64)
					} else {
						configtab[configindex][1] = strconv.FormatFloat(m, 'f', -1, 64)
					}
				}
			}
			if inpututil.IsKeyJustPressed(ebiten.KeyArrowRight) {
				startime = time.Now()
			}
			if ebiten.IsKeyPressed(ebiten.KeyArrowRight) {
				v, _ := strconv.ParseFloat(configtab[configindex][1], 64)
				m, _ := strconv.ParseFloat(configtab[configindex][4], 64)
				acttime := time.Now()
				timepassed := acttime.Sub(startime)
				if timepassed > 6000000000 {
					if v < m {
						r, _ := strconv.ParseFloat(configtab[configindex][2], 64)
						v += 100 * r
						configtab[configindex][1] = strconv.FormatFloat(v, 'f', -1, 64)
					} else {
						configtab[configindex][1] = strconv.FormatFloat(m, 'f', -1, 64)
					}
				} else if timepassed > 3000000000 {
					if v < m {
						r, _ := strconv.ParseFloat(configtab[configindex][2], 64)
						v += 10 * r
						configtab[configindex][1] = strconv.FormatFloat(v, 'f', -1, 64)
					} else {
						configtab[configindex][1] = strconv.FormatFloat(m, 'f', -1, 64)
					}
				} else {
					if v < m {
						r, _ := strconv.ParseFloat(configtab[configindex][2], 64)
						v += r
						configtab[configindex][1] = strconv.FormatFloat(v, 'f', -1, 64)
					} else {
						configtab[configindex][1] = strconv.FormatFloat(m, 'f', -1, 64)
					}
				}
			}
		}
		if inpututil.IsKeyJustPressed(ebiten.KeyArrowDown) {
			configindex++
			if configindex > len(configtab)-1 {
				configindex = 0
			}

		}
		if inpututil.IsKeyJustPressed(ebiten.KeyArrowUp) {
			configindex--
			if configindex < 0 {
				configindex = len(configtab) - 1
			}
		}
		config.General.MaxParticles, _ = strconv.Atoi(configtab[0][1])
		config.General.Generation, _ = strconv.ParseBool(configtab[1][1])
		config.General.FollowCursor, _ = strconv.ParseBool(configtab[1+1][1])
		config.General.RandomSpawn, _ = strconv.ParseBool(configtab[2+1][1])
		config.General.SpawnX, _ = strconv.Atoi(configtab[3+1][1])
		config.General.SpawnY, _ = strconv.Atoi(configtab[4+1][1])
		config.General.Gravite, _ = strconv.ParseBool(configtab[5+1][1])
		config.General.VitesseGravite, _ = strconv.ParseFloat(configtab[6+1][1], 64)
		config.General.SpawnRate, _ = strconv.ParseFloat(configtab[7+1][1], 64)
		config.General.Collision, _ = strconv.ParseBool(configtab[8+1][1])
		config.General.Rotationb, _ = strconv.ParseBool(configtab[9+1][1])
		config.General.Rotation, _ = strconv.ParseFloat(configtab[10+1][1], 64)
		config.General.Vitesse, _ = strconv.ParseFloat(configtab[11+1][1], 64)
		config.General.Accel, _ = strconv.ParseFloat(configtab[12+1][1], 64)
		config.General.Fondu, _ = strconv.ParseFloat(configtab[13+1][1], 64)
		config.General.Rayon, _ = strconv.Atoi(configtab[14+1][1])
		config.General.Rouge, _ = strconv.ParseFloat(configtab[15+1][1], 64)
		config.General.Vert, _ = strconv.ParseFloat(configtab[16+1][1], 64)
		config.General.Bleu, _ = strconv.ParseFloat(configtab[17+1][1], 64)
		config.General.RFondu, _ = strconv.ParseFloat(configtab[18+1][1], 64)
		config.General.VFondu, _ = strconv.ParseFloat(configtab[19+1][1], 64)
		config.General.BFondu, _ = strconv.ParseFloat(configtab[20+1][1], 64)
		config.General.TailleX, _ = strconv.ParseFloat(configtab[21+1][1], 64)
		config.General.TailleY, _ = strconv.ParseFloat(configtab[22+1][1], 64)
		config.General.Vie, _ = strconv.Atoi(configtab[23+1][1])
		config.General.Xplode, _ = strconv.ParseBool(configtab[24+1][1])
		config.General.Trail, _ = strconv.ParseBool(configtab[25+1][1])
		config.General.Orbite, _ = strconv.ParseBool(configtab[26+1][1])
		config.General.OrbiteCursor, _ = strconv.ParseBool(configtab[27+1][1])

	}

}
