package particles

import (
	"math/rand"
	"project-particles/config"
)

func Xplode(s *System, p Particle) {
	for i := 0; i < 200; i++ {
		var P Particle = Particle{
			PositionX: p.PositionX,
			PositionY: p.PositionY,
			Vitesse:   []float64{rand.Float64()*8 - 4, rand.Float64()*8 - 4},
			Gravite:   0,
			ScaleX:    p.ScaleX, ScaleY: p.ScaleY, Rotation: p.Rotation,
			ColorRed: 1, ColorGreen: 0.8, ColorBlue: 0,
			Opacity: 1,
			Vie:     config.General.Vie - 500,
			Xplode:  true,
		}
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
