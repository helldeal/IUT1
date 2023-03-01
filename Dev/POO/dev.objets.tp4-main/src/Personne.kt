class Personne(nom: String,prenom: String) : Proprietaire {
    private val prenom: String
    private val nom: String
    init {
        this.nom=nom
        this.prenom=prenom
    }
    override fun donneNomComplet() : String {
        return prenom +" "+nom.uppercase()
    }
}