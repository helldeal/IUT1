abstract class ObjetPositionnable(xx : Int, yy : Int): Manipulable,ObjetGraphique() {
    private var selectionne : Boolean = false
    protected var xx : Int
    protected var yy : Int
    init {
        this.xx =xx
        this.yy=yy
    }
    override fun deplacer(nx: Int, ny: Int) {
        xx=nx
        yy=ny
    }
    override fun selectionner(ok: Boolean) {
        selectionne=ok
    }
}