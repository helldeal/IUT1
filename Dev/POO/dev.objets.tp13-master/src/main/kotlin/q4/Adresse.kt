package q4

class Adresse (numero: Int, nom: String, codepostal: Int, ville: String){

    private val numero : Int
    private val nom : String
    private val codepostal : Int
    private val ville : String

    init {
        this.numero = numero
        this.nom = nom
        this.codepostal = codepostal
        this.ville = ville
    }

    override fun toString(): String {
        return "$numero $nom, $codepostal $ville"
    }


}