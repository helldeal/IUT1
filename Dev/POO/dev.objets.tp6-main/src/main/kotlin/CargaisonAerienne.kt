open class CargaisonAerienne(distance : Int): Cargaison(distance) {

    override fun encombrement(marchandise: Marchandise): Double {
        return marchandise.donneVolume()
    }
    override fun limite(): Double {
        return 38000.0
    }

    override fun facteur(): Int {
        return 10
    }
}