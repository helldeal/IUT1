package particles

import (
	"math/rand"
	"project-particles/config"
)

func Trail(s *System, p Particle) {
	if p.Vie%1 == 0 {
		var P Particle = Particle{
			PositionX: p.PositionX,
			PositionY: p.PositionY,
			Vitesse:   []float64{rand.Float64() - 0.5 - p.Vitesse[0], rand.Float64() - 0.5 - (p.Vitesse[1] + p.Gravite)},
			Gravite:   0,
			ScaleX:    p.ScaleX, ScaleY: p.ScaleY, Rotation: p.Rotation,
			ColorRed: p.ColorRed, ColorGreen: p.ColorGreen, ColorBlue: p.ColorBlue,
			Opacity: 0.8,
			Trail:   true,
			Vie:     config.General.Vie - 80,
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
