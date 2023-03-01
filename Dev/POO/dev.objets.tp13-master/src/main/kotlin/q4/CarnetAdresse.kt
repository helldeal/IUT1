package q4

class CarnetAdresse {

    private val contacts : MutableList<Personne>

    init {
        contacts = mutableListOf<Personne>()
    }

    fun enregistrer(nouveauContact : Personne) {
        contacts.add(nouveauContact)
    }

    override fun toString(): String {
        var str = "---\n"
        for (contact in contacts) {
            str += "$contact\n"
        }
        str += "---\n"
        return str
    }


    fun serialiser(nomFichier : String) {
        TODO()
    }

    fun charger() {
        TODO()
    }
}

fun deserialiserCarnet(nomFichier : String) : CarnetAdresse {
    TODO()
}