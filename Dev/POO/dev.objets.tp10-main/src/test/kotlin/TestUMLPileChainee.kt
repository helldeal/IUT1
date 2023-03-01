import iut.collections.*
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Test
import kotlin.reflect.KVisibility

class TestUMLPileChainee {

    val uml = UMLChecker(PileChainee::class)

    @Test
    fun abs() {
        uml.isAbstract(false)
    }

    @Test
    fun open() {
        uml.isOpen()
    }

    @Test
    fun extend() {
        uml.extend("Pile", "Collection")
    }

    @Test
    fun attribute() {
        uml.attributeCheck(
            "debut",
            "iut.collections.Cellule<E>?",
            KVisibility.PROTECTED
            )
    }

    @Test
    fun methods() {
        assertAll(
            { uml.methodCheck("estVide", isOpenOrOverride = true) },
            { uml.methodCheck("taille", isOpenOrOverride = true) },
            { uml.methodCheck("empiler", isOpenOrOverride = true) },
            { uml.methodCheckParams("empiler", "element", "E") },
            { uml.methodCheck("consulter", isOpenOrOverride = true) },
            { uml.methodCheck("depiler", isOpenOrOverride = true) }
        )
    }
}