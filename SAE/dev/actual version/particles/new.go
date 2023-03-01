package particles

import (
	"math"
	"math/rand"
	"project-particles/config"
	"time"
)

// NewSystem est une fonction qui initialise un système de particules et le
// retourne à la fonction principale du projet, qui se chargera de l'afficher.
func NewSystem() System {
	rand.Seed(time.Now().UnixNano())
	var tab []Particle = []Particle{}
	for i := 1; i <= config.General.InitNumParticles; i++ {
		P := create()
		tab = append(tab, P)
	}
	return System{Content: tab}

}

//fonction qui crée des particules
func create() Particle {
	var x, y float64
	if !config.General.RandomSpawn {
		x = float64(config.General.SpawnX)
		y = float64(config.General.SpawnY)
	} else {
		x = float64(rand.Intn(config.General.WindowSizeX))
		y = float64(rand.Intn(config.General.WindowSizeY))
	}
	var P Particle = Particle{
		PositionX: x,
		PositionY: y,
		Vitesse:   []float64{-1*config.General.Vitesse + rand.Float64()*2*config.General.Vitesse, -1*config.General.Vitesse + rand.Float64()*2*config.General.Vitesse},
		Gravite:   0,
		ScaleX:    config.General.TailleX, ScaleY: config.General.TailleY, Rotation: rand.Float64() * 2 * math.Pi,
		ColorRed: config.General.Rouge, ColorGreen: config.General.Vert, ColorBlue: config.General.Bleu,
		Opacity: 0,
	}
	return P
}
