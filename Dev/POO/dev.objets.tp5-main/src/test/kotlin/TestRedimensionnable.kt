import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

import kotlin.reflect.KVisibility
import kotlin.reflect.full.memberFunctions

class TestRedimensionnable {

    val kClass = Redimensionnable::class

    @Test
    fun `Redim`() {
        val method = kClass.memberFunctions.find { it.name == "redimensionner" }
        assertAll(
            {assertEquals(KVisibility.PUBLIC, method!!.visibility)},
            {var param = method!!.parameters.find {it.name =="nouvelleHauteur" }
                assertEquals("kotlin.Int", param!!.type.toString())},
            {var param = method!!.parameters.find {it.name =="nouvelleLargeur" }
                assertEquals("kotlin.Int", param!!.type.toString())},
        )
    }

    @Test
    fun `Redim 2`() {
        assertAll(
            { assertTrue(kClass.isAbstract) },
            { assertFalse(kClass.isOpen) },
        )
    }


}
