package q4

class Personne (nom : String, prenom : String, age : Int, email : String) {

    private var nom : String
    private var prenom : String
    private var age : Int
    private var email : String
    private var adresse : Adresse? = null

    init {
        this.nom = nom
        this.prenom = prenom
        this.age = age
        this.email = email
        this.adresse = null
    }

    fun fixeAdresse(nouvelleAdresse : Adresse) {
        adresse = nouvelleAdresse
    }

    override fun toString(): String {
        return "$prenom $nom ($age ans) [$email] : $adresse"
    }

}