abstract class Cargaison(distance : Int) {
    private var distance :Int
    private var encombrementActuel : Double = 0.0
    private var marchandise = arrayOfNulls<Marchandise>(size = 100)
    init {
        this.distance=distance
    }
    fun ajouter(marchandiseAjoutee: Marchandise):Boolean{
        if (encombrementActuel+encombrement(marchandiseAjoutee)<=limite()){
            for (i in 0 until (marchandise.size)){
                if (marchandise[i]==null){
                    marchandise[i]=marchandiseAjoutee
                    encombrementActuel+=encombrement(marchandiseAjoutee)
                    return true
                }
            }
        }
        return false
    }
    fun cout():Double {
        return encombrementActuel*distance*facteur()
    }
    fun rechercher(marchandiseRecherchee: Marchandise): Int {
        for (i in 0 until marchandise.size){
            if (marchandise[i]==marchandiseRecherchee){
                return i
            }
        }
        return -1
    }
    open fun encombrement(marchandise: Marchandise): Double{
        return marchandise.donnePoids()
    }
    abstract fun limite() :Double

    open fun facteur(): Int{
        return 1
    }
}