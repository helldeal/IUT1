package particles

import (
	"project-particles/config"
	"testing"
)

//Test pour le nombre initial de particules créées par le New System
func TestInitpart(t *testing.T) {
	config.Get("../config.json")
	config.General.InitNumParticles = 10
	S := NewSystem()
	if config.General.InitNumParticles != len(S.Content) {
		t.Error("Nombre de Particules :", len(S.Content), "Nombre attendu :", config.General.InitNumParticles)
	}
}

//Test pour 10 particules générées
func TestGen10(t *testing.T) {
	config.Get("../config.json")
	config.General.InitNumParticles = 10
	config.General.SpawnRate = 10
	S := NewSystem()
	S.Update()
	if config.General.InitNumParticles+10 != len(S.Content) {
		t.Error("Nombre de Particules :", len(S.Content), "Nombre attendu :", config.General.InitNumParticles+10)
	}
}

//Test pour 0.25 particule générée
func TestGen025(t *testing.T) {
	config.Get("../config.json")
	config.General.InitNumParticles = 10
	config.General.SpawnRate = 0.25
	S := NewSystem()
	S.Update()
	S.Update()
	S.Update()
	S.Update()
	if config.General.InitNumParticles+1 != len(S.Content) {
		t.Error("Nombre de Particules :", len(S.Content), "Nombre attendu :", config.General.InitNumParticles+1)
	}
}

//Test pour un nombre négatif de particules générées
func TestGenNeg(t *testing.T) {
	config.Get("../config.json")
	config.General.InitNumParticles = 10
	config.General.SpawnRate = -1
	S := NewSystem()
	S.Update()
	if config.General.InitNumParticles != len(S.Content) {
		t.Error("Nombre de Particules :", len(S.Content), "Nombre attendu :", config.General.InitNumParticles)
	}
}

//Test du spawn aléatoire
func TestSpawnRandom(t *testing.T) {
	config.Get("../config.json")
	config.General.RandomSpawn = true
	config.General.InitNumParticles = 2
	S := NewSystem()
	if int(S.Content[0].PositionX) == int(S.Content[1].PositionX) {
		t.Error("Problème de Spawn en X")
	}
	if int(S.Content[0].PositionY) == int(S.Content[1].PositionY) {
		t.Error("Problème de Spawn en Y")
	}
}

//Test du spawn fixe
func TestSpawnFixe(t *testing.T) {
	config.Get("../config.json")
	config.General.RandomSpawn = false
	config.General.InitNumParticles = 2
	S := NewSystem()
	if int(S.Content[0].PositionX) != int(S.Content[1].PositionX) && int(S.Content[0].PositionX) != config.General.SpawnX {
		t.Error("Problème de Spawn en X")
	}
	if int(S.Content[0].PositionY) != int(S.Content[1].PositionY) && int(S.Content[0].PositionY) != config.General.SpawnY {
		t.Error("Problème de Spawn en Y")
	}
}

//Test de la vitesse et du déplacement des particules
func TestVitesseParticule(t *testing.T) {
	config.Get("../config.json")
	config.General.InitNumParticles = 10
	config.General.Vitesse = 4
	S := NewSystem()
	var tabX []float64
	var tabY []float64
	for i := 0; i < 10; i++ {
		tabX = append(tabX, S.Content[i].PositionX)
		tabY = append(tabY, S.Content[i].PositionY)
	}
	S.Update()
	for i := 0; i < 10; i++ {
		if S.Content[i].PositionX != tabX[i]+S.Content[i].Vitesse[0] {
			t.Error("Problème de Vitesse en X")
		}
		if S.Content[i].PositionY != tabY[i]+S.Content[i].Vitesse[1] {
			t.Error("Problème de Vitesse en Y")
		}
	}
}
