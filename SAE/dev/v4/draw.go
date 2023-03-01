package main

import (
	"fmt"
	"project-particles/assets"
	"project-particles/config"

	"github.com/hajimehoshi/ebiten/v2"
	"github.com/hajimehoshi/ebiten/v2/ebitenutil"
)

// Draw se charge d'afficher à l'écran l'état actuel du système de particules
// g.system. Elle est appelée automatiquement environ 60 fois par seconde par
// la bibliothèque Ebiten. Cette fonction pourra être légèrement modifiée quand
// c'est précisé dans le sujet.

var gen bool = true

func (g *game) Draw(screen *ebiten.Image) {

	for _, p := range g.system.Content {
		options := ebiten.DrawImageOptions{}
		options.GeoM.Rotate(p.Rotation)
		options.GeoM.Scale(p.ScaleX, p.ScaleY)
		options.GeoM.Translate(p.PositionX, p.PositionY)
		options.ColorM.Scale(p.ColorRed, p.ColorGreen, p.ColorBlue, p.Opacity)
		screen.DrawImage(assets.ParticleImage, &options)

	}
	if config.General.Debug {
		ebitenutil.DebugPrint(screen, fmt.Sprint(ebiten.CurrentTPS()))
		ebitenutil.DebugPrintAt(screen, fmt.Sprint("Nombre de particules : ", len(g.system.Content)), 0, 20)

	}

}
