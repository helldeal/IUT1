import java.awt.Point

class Marchandise(poids:Double, volume:Double) {
    private var poids : Double
    private var volume : Double
    init {
        this.poids=poids
        this.volume=volume
    }
    fun donneVolume(): Double{
        return volume
    }
    fun donnePoids(): Double{
        return poids
    }
}