class Voiture(mod:String,coul:String,vitMax:Double) {
    private val mod:String
    private var coul:String
    private val vitMax:Double
    private var vitCour:Double=0.0
    private var enMarche:Boolean = false
    init{
        this.mod=mod
        this.coul=coul
        this.vitMax=vitMax
    }
    fun acheter(acheteur:Personne){
        
    }
    fun estEnMarche(): Boolean{
        return (enMarche)
    }
    fun demarrer() {
        enMarche=true
    }
    fun accelerer(acceleration:Double):Double{
        if (acceleration>0){
            if (enMarche){
                vitCour+=acceleration
            }
            if (vitCour > vitMax){
                vitCour=vitMax
            }   
        }
        return(vitCour)
    }
    fun decelerer(deceleration:Double):Double{
        if (deceleration>0){
            if (enMarche){
                vitCour-=deceleration
            }
            if (vitCour < 0.0){
                vitCour=0.0
            }   
        }
        return(vitCour)
    }
    fun arreter(){
        vitCour=0.0
        enMarche=false
    }
    fun repeindre(nouvelleCouleur : String){
        coul=nouvelleCouleur
    }
    fun estGaree(): Boolean{
        return !enMarche
    }
    fun stationner(nouveauParking : Parking){
        nouveauParking.stationner(0,this)
        arreter()
        estGaree()
    }
    fun quitterStationnement(){
        demarrer()
        estGaree()
    }
}