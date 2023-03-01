import iut.collections.*
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Test

class TestUMLlisteChainee {

    val uml = UMLChecker(ListeChainee::class)

    @Test
    fun abs() {
        uml.isAbstract(false)
    }

    @Test
    fun open() {
        uml.isOpen(false)
    }

    @Test
    fun extend() {
        uml.extend("PileChainee", "Liste", "File", "Pile", "Collection")
    }

    @Test
    fun attribute() {
        uml.noAttribute()
    }

    @Test
    fun methods() {
        assertAll(
            { uml.methodCheck("index", isOpenOrOverride = true) },
            { uml.methodCheckParams("index", "element", "E") },
            { uml.methodCheck("consulter", isOpenOrOverride = true) },
            { uml.methodCheckParams("consulter",
                "index", "kotlin.Int") },
            { uml.methodCheck("inserer", isOpenOrOverride = true) },
            { uml.methodCheckParams("inserer",
                "index", "kotlin.Int", "element", "E") },
            { uml.methodCheck("supprimer", isOpenOrOverride = true) },
            { uml.methodCheckParams("supprimer",
                "index", "kotlin.Int") },
            { uml.methodCheck("insererEnQueue", isOpenOrOverride = true) },
            { uml.methodCheckParams("insererEnQueue", "element", "E") },
            { uml.methodCheck("supprimerEnQueue", isOpenOrOverride = true) },
            { uml.methodCheck("consulterEnQueue", isOpenOrOverride = true) },
        )
    }
}