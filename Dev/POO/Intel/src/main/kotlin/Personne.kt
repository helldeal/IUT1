class Personne (prenom : String, nom : String) {
    private var nom : String
    private var prenom : String

    init {
        this.nom = nom
        this.prenom = prenom
    }

    fun changerDeNom(nouveau : String) {
        nom = nouveau.uppercase()
    }

    fun donnerNomComplet() : String {
        return "$prenom ${nom.uppercase()}"
    }
}
