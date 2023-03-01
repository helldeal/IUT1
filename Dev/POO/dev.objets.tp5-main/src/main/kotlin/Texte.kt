class Texte(xx : Int,yy : Int,valeur : String): ObjetPositionnable(xx, yy),Editable {
    private var valeur : String
    private var police : String ="Times"
    private var taille : Int= 10
    init {
        this.valeur=valeur
    }

    override fun editer(nouveau: String) {
        valeur=nouveau
    }

    override fun dessiner(): String {
        return "\"$valeur\":X=$xx,Y=$yy,P=$police,S=$taille"
    }
}