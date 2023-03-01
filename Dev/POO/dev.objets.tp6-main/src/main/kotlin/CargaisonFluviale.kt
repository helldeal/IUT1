class CargaisonFluviale(distance : Int): Cargaison(distance) {
    override fun limite(): Double {
        return 300000.0
    }
}