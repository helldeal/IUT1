import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

import kotlin.reflect.KVisibility
import kotlin.reflect.full.memberFunctions

class TestEditable {
    val kClass = Editable::class
    @Test
    fun `Editable`() {
        val method = kClass.memberFunctions.find { it.name == "editer" }
        assertAll(
            {assertEquals(KVisibility.PUBLIC, method!!.visibility)},
            {var param = method!!.parameters.find {it.name =="nouveau" }
                assertEquals("kotlin.String", param!!.type.toString())},
        )
    }

    @Test
    fun `Editable 2`() {
        assertAll(
            { assertTrue(kClass.isAbstract) },
            { assertFalse(kClass.isOpen) },
        )
    }


}
