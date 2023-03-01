package particles

import (
	"math/rand"
	"project-particles/config"
)

// Update mets à jour l'état du système de particules (c'est-à-dire l'état de
// chacune des particules) à chaque pas de temps. Elle est appellée exactement
// 60 fois par seconde (de manière régulière) par la fonction principale du
// projet.

func (s *System) Update() {
	//genération des particules
	Generation(s)
	for i := 0; i < len(s.Content); i++ {

		//mise à jour de la position via l'ajout de la vitesse
		s.Content[i].PositionX += s.Content[i].Vitesse[0]
		s.Content[i].PositionY += s.Content[i].Vitesse[1]

	}

}

var SpawnAct float64 = 0

func Generation(s *System) {
	//spawnrate adaptatif
	SpawnAct += config.General.SpawnRate
	for SpawnAct >= 1 {
		SpawnAct -= 1

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
		s.Content = append(s.Content, P)

	}
}
