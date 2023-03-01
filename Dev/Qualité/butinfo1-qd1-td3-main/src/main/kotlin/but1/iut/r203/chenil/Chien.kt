package but1.iut.r203.chenil

import java.time.LocalDate
import java.time.Period

class Chien (nomParam : String, raceParam : String,methode:DateChenil){
    val nom = nomParam
    val race = raceParam
    val meth= methode
    private var dateNaissance : LocalDate? = null
        set(value) {
            field = value
        }

    /**
     * Affecte une date de naissance au chien
     * @param anneeNaissance: Int
     * @param moisNaissance: Int
     * @param jourNaissance: Int
     * @throws IllegalArgumentException : quand les paramètres sont incorrectes
     */
    fun setDateNaissance(anneeNaissance: Int, moisNaissance: Int, jourNaissance: Int) {
        dateNaissance = LocalDate.of(anneeNaissance, moisNaissance, jourNaissance)
    }

    /**
     * Calcule l'age en mois du chien
     * @return age : Long
     */
    fun ageMois(): Long {
        val dateChenil = DateChenilStub()
        var dateJour : LocalDate = meth.getDateToday()
        println("Date du jour : " + dateJour)
        var ecart = Period.between(dateNaissance, dateJour)
        return ecart.years * 12L + ecart.months
    }

    override fun toString(): String {
        return "$nom le/la $race né(e) le $dateNaissance)"
    }


}