package exo2

class Pays(nom : String, capitale : String,
           continent : String, population : Int,
           superficie : Double) : Comparable<Pays> {
    private val nom: String
    private val capitale : String
    private val continent : String
    private val population : Int
    private val superficie : Double
    init {
        this.nom=nom
        this.capitale=capitale
        this.continent=continent
        this.population=population
        this.superficie=superficie
    }

    fun getNom() : String {
       return nom
    }

    fun getCapitale() : String {
       return capitale
    }

    fun getContinent() : String {
       return continent
    }

    fun getPopulation() : Int {
        return population
    }

    fun getSuperficie() : Double {
       return superficie
    }

    override fun toString(): String {
        return "$nom\n"
    }

    override fun equals(other: Any?): Boolean {
        if (other is Pays) return this.nom==other.nom
        return false
    }

    override operator fun compareTo(o: Pays): Int {
        return this.population-o.population
    }


}