import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

import kotlin.reflect.KVisibility
import kotlin.reflect.full.memberFunctions

class TestManipulable {
    val kClass = Manipulable::class

    @Test
    fun `Deplacable verif`() {
        assertAll(
            {assertTrue(kClass.isAbstract)},
            {assertFalse(kClass.isOpen)},
        )
    }

    @Test
    fun `Deplacable verif 2`() {
        var method = kClass.memberFunctions.find { it.name == "deplacer" }
        assertAll(
                    {assertEquals(KVisibility.PUBLIC, method!!.visibility)},
                    {var param = method!!.parameters.find {it.name =="ny" }
                        assertEquals("kotlin.Int", param!!.type.toString())},
                    {var param = method!!.parameters.find {it.name =="ny" }
                        assertEquals("kotlin.Int", param!!.type.toString())},
        )
    }

    @Test
    fun `Deplacable verif 3`() {
        var method = kClass.memberFunctions.find { it.name == "dessiner" }
        assertEquals(KVisibility.PUBLIC, method!!.visibility)
    }

}
