package config

// Config définit les champs qu'on peut trouver dans un fichier de config.
// Dans le fichier les champs doivent porter le même nom que dans le type si
// dessous, y compris les majuscules. Tous les champs doivent obligatoirement
// commencer par des majuscules, sinon il ne sera pas possible de récupérer
// leurs valeurs depuis le fichier de config.
// Vous pouvez ajouter des champs et ils seront automatiquement lus dans le
// fichier de config. Vous devrez le faire plusieurs fois durant le projet.
type Config struct {
	WindowTitle              string
	WindowSizeX, WindowSizeY int
	ParticleImage            string
	Debug                    bool
	ConfigMod                bool
	InitNumParticles         int
	MaxParticles             int
	Generation               bool
	RandomSpawn              bool
	SpawnX, SpawnY           int
	SpawnRate                float64
	MargeOut                 int
	FollowCursor             bool
	MoveSpeed                int
	TailleX                  float64
	TailleY                  float64
	VitesseGravite           float64
	Vitesse                  float64
	Bleu                     float64
	Rouge                    float64
	Vert                     float64
	RFondu                   float64
	VFondu                   float64
	BFondu                   float64
	Collision                bool
	Gravite                  bool
	Rotationb                bool
	Rotation                 float64
	CollisionP               bool
	Accel                    float64
	Fondu                    float64
	Rayon                    int
	Vie                      int
	CercleMode               bool
	Distance                 float64
	Trail                    bool
	Xplode                   bool
	Orbite                   bool
	OrbiteCursor             bool
}

var General Config
