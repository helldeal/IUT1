class CargaisonRoutiere(distance : Int): Cargaison(distance) {
    override fun limite(): Double {
        return 38000.0
    }

    override fun facteur(): Int {
        return 4
    }

}