import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

import kotlin.reflect.KVisibility
import kotlin.reflect.full.memberFunctions

class TestSelectionnable {

    val kClass = Selectionnable::class

    @Test
    fun `select 1`() {
        assertAll(
            { assertTrue(kClass.isAbstract) },
            { assertFalse(kClass.isOpen) },
        )
    }

    @Test
    fun `select 2`() {
        assertAll(
            { val method = kClass.memberFunctions.find { it.name == "selectionner" }
                assertAll(
                    {assertEquals(KVisibility.PUBLIC, method!!.visibility)},
                    {var param = method!!.parameters.find {it.name =="ok" }
                        assertEquals("kotlin.Boolean", param!!.type.toString())},
                ) },
        )
    }

}
