package particles

import (
	"project-particles/config"
	"testing"
)

//Test pour le nombre initial de particules créées par le New System
func TestInitpart(t *testing.T) {
	config.Get("../config/config.json")
	config.General.InitNumParticles = 10
	S := NewSystem()
	if config.General.InitNumParticles != len(S.Content) {
		t.Error("Nombre de Particules :", len(S.Content), "Nombre attendu :", config.General.InitNumParticles)
	}
}

//Test pour 10 particules générées
func TestGen10(t *testing.T) {
	config.Get("../config/config.json")
	config.General.InitNumParticles = 10
	config.General.Generation = true
	config.General.SpawnRate = 10
	S := NewSystem()
	S.Update()
	if config.General.InitNumParticles+10 != len(S.Content) {
		t.Error("Nombre de Particules :", len(S.Content), "Nombre attendu :", config.General.InitNumParticles+10)
	}
}

//Test pour 0.25 particule générée
func TestGen025(t *testing.T) {
	config.Get("../config/config.json")
	config.General.InitNumParticles = 10
	config.General.Generation = true
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
	config.Get("../config/config.json")
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
	config.Get("../config/config.json")
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
	config.Get("../config/config.json")
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
	config.Get("../config/config.json")
	config.General.InitNumParticles = 5
	config.General.Vitesse = 4
	S := NewSystem()
	var tabX []float64
	var tabY []float64
	for i := 0; i < 5; i++ {
		tabX = append(tabX, S.Content[i].PositionX)
		tabY = append(tabY, S.Content[i].PositionY)
	}
	S.Update()
	for i := 0; i < 5; i++ {
		if S.Content[i].PositionX != tabX[i]+S.Content[i].Vitesse[0] {
			t.Error("Problème de Vitesse en X")
		}
		if S.Content[i].PositionY != tabY[i]+S.Content[i].Vitesse[1] {
			t.Error("Problème de Vitesse en Y")
		}
	}
}

//Test de la vie des particules
func TestVieParticule(t *testing.T) {
	config.Get("../config/config.json")
	config.General.InitNumParticles = 1
	S := NewSystem()
	vie := S.Content[0].Vie
	S.Update()
	S.Update()
	S.Update()
	if S.Content[0].Vie != vie+3 {
		t.Error("Problème de vie")
	}
}

//Test de la Gravité des particules
func TestGraviteParticule(t *testing.T) {
	config.Get("../config/config.json")
	config.General.InitNumParticles = 1
	config.General.Gravite = true
	config.General.VitesseGravite = 1
	S := NewSystem()
	g := S.Content[0].Gravite
	S.Update()
	S.Update()
	S.Update()
	if S.Content[0].Gravite != g+3 {
		t.Error("Problème de Gravité")
	}
}

//Test des changements de couleurs de la particule
func TestCouleursParticule(t *testing.T) {
	config.Get("../config/config.json")
	config.General.InitNumParticles = 1
	config.General.Rouge = 1
	config.General.Vert = 1
	config.General.Bleu = 1
	config.General.Fondu = 1
	config.General.BFondu = -1
	config.General.RFondu = -1
	config.General.VFondu = -1
	S := NewSystem()
	S.Update()
	if S.Content[0].ColorRed != 1+config.General.RFondu {
		t.Error("Problème de Rouge")
	}
	if S.Content[0].ColorBlue != 1+config.General.BFondu {
		t.Error("Problème de Vert")
	}
	if S.Content[0].ColorGreen != 1+config.General.VFondu {
		t.Error("Problème de Bleu")
	}
	if S.Content[0].Opacity != 1-config.General.Fondu {
		t.Error("Problème de Fondu")
	}
}

//Test de la collision sur les bords
func TestColisionBords(t *testing.T) {
	config.Get("../config/config.json")
	config.General.InitNumParticles = 1
	config.General.Vitesse = 10
	config.General.Accel = 1.01
	config.General.Collision = true
	S := NewSystem()
	for i := 0; i < 100; i++ {
		S.Update()
		if S.Content[0].PositionX > float64(config.General.WindowSizeX+config.General.MargeOut) ||
			S.Content[0].PositionX < float64(-config.General.MargeOut) ||
			S.Content[0].PositionY > float64(config.General.WindowSizeY+config.General.MargeOut) ||
			S.Content[0].PositionY < float64(-config.General.MargeOut) {
			t.Error("Problème de Collision bords", S.Content[0].PositionX, S.Content[0].PositionY)
		}
	}
}
