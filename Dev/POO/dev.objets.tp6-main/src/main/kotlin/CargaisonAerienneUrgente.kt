class CargaisonAerienneUrgente(distance : Int): CargaisonAerienne(distance) {
    override fun facteur(): Int {
        return 2*super.facteur()
    }
}