
fun main() {
    var maSaxo = Vehicule("Saxo","rouge",4,180.0)
    println(maSaxo)
    maSaxo.demarrer()
    maSaxo.accelerer(50.0)
    println(maSaxo)
    maSaxo.accelerer(40.0)
    println(maSaxo.vitesse())
    var reliant = Vehicule("Reliant Robin","bleue",3,35.0)
    reliant.demarrer()
    reliant.accelerer(15.0)
    if (reliant.vaPlusVite(maSaxo)){
        println("La reliant est too fast")
    }
    else {
        println("La Saxo est too fast")
    }
    reliant.arreter()
    maSaxo.arreter()
}
