package ihm.td6.exo3.librairie

class Todo(name: String) {

    val name: String

    init {
        this.name=name
    }

    override fun toString(): String {
        return this.name
    }


}