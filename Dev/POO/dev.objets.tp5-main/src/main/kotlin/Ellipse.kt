open class Ellipse(xx : Int, yy : Int, axeVertical : Int, axeHorizontal : Int): FormeGeo(xx,yy,axeVertical, axeHorizontal) {
    private var axeHorizontal: Int
    private var axeVertical: Int
    init {
        this.axeHorizontal=axeHorizontal
        this.axeVertical=axeVertical
    }
    override fun dessiner(): String {
        return "(X=$xx,Y=$yy,AV=$axeVertical,AH=$axeHorizontal)"
    }
}