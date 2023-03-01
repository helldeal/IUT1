package main

import (
	"project-particles/config"

	"github.com/hajimehoshi/ebiten/v2"
)

// Update se charge d'appeler la fonction Update du système de particules
// g.system. Elle est appelée automatiquement exactement 60 fois par seconde par
// la bibliothèque Ebiten. Cette fonction ne devrait pas être modifiée sauf
// pour les deux dernières extensions.
func (g *game) Update() error {
	g.system.Update()
	if ebiten.IsKeyPressed(ebiten.KeyW) {
		config.General.SpawnY -= config.General.MoveSpeed
	}
	if ebiten.IsKeyPressed(ebiten.KeyS) {
		config.General.SpawnY += config.General.MoveSpeed
	}
	if ebiten.IsKeyPressed(ebiten.KeyD) {
		config.General.SpawnX += config.General.MoveSpeed
	}
	if ebiten.IsKeyPressed(ebiten.KeyA) {
		config.General.SpawnX -= config.General.MoveSpeed
	}
	if config.General.FollowCursor {
		config.General.SpawnX, config.General.SpawnY = ebiten.CursorPosition()
	}

	return nil
}
