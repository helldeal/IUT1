class Parking(places : Int) {
    private val places:Int
    init{
        this.places=places
    }
    var park = arrayOfNulls<Voiture?> (places)
    fun stationner(numeroPlace : Int, voitureStationnee : Voiture) : Boolean{
        if (placeLibre(numeroPlace) && voitureStationnee !in(park)){
            park[numeroPlace]=voitureStationnee
            return true
        }
        return false
    }
    fun nombreDePlacesLibres():Int{
        var cpt : Int = 0
        for (i in 0 until park.size){
            if (park[i]==null){
                cpt+=1
            }
        }
        return cpt
    }
    fun nombreDePlacesTotales():Int{
        return places
    }
    fun placeLibre(numeroPlace:Int):Boolean{
        if (numeroPlace>park.size-1 || numeroPlace<0){
            return false
        }
        if (park[numeroPlace]==null){
            return true
        }
        return false
    }
}