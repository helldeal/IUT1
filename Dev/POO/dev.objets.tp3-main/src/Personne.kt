class Personne(nom: String,prenom: String) {
    private val prenom: String
    private val nom: String
    init {
        this.nom=nom
        this.prenom=prenom
    }
    fun donneNomComplet():String{
        return("${prenom} ${nom.uppercase()}")
    }
}