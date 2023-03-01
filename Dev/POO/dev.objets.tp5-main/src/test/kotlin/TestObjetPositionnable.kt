import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

import kotlin.reflect.full.allSuperclasses
import kotlin.reflect.full.memberProperties
import kotlin.reflect.KVisibility
import kotlin.reflect.full.memberFunctions

class TestObjetPositionnable {

    val kClass = ObjetPositionnable::class

    @Test
    fun `ObjetPositionnable verif 0`() {
        assertAll(
            { assertTrue(kClass.isAbstract) },
            { assertFalse(kClass.isOpen) },
        )
    }

    @Test
    fun `ObjetPositionnable verif 2`() {
        var extend = kClass.allSuperclasses.find { it.simpleName == "Selectionnable" }
        assertNotNull(extend)
    }

    @Test
    fun `ObjetPositionnable verif 3`() {
        var extend = kClass.allSuperclasses.find { it.simpleName == "ObjetGraphique" }
        assertNotNull(extend)
    }

    @Test
    fun `ObjetPositionnable verif 4`() {
        var extend = kClass.allSuperclasses.find { it.simpleName == "Manipulable" }
        assertNotNull(extend)
    }

    @Test
    fun `ObjetPositionnable verif 5`() {
        var member = kClass.memberProperties.find { it.name == "xx" }
        assertAll(
            { assertEquals(KVisibility.PROTECTED, member!!.visibility) },
            { assertFalse(member!!.isOpen) },
            { assertFalse(member!!.isAbstract) },
            { assertEquals("kotlin.Int", member!!.returnType.toString()) },
        )
    }

    @Test
    fun `ObjetPositionnable verif 6`() {
        var member = kClass.memberProperties.find { it.name == "yy" }
        assertAll(
            { assertEquals(KVisibility.PROTECTED, member!!.visibility) },
            { assertFalse(member!!.isOpen) },
            { assertFalse(member!!.isAbstract) },
            { assertEquals("kotlin.Int", member!!.returnType.toString()) },
        )
    }

    @Test
    fun `ObjetPositionnable verif 7`() {
        var member = kClass.memberProperties.find { it.name == "selectionne" }
        assertAll(
            { assertEquals(KVisibility.PRIVATE, member!!.visibility) },
            { assertFalse(member!!.isOpen) },
            { assertFalse(member!!.isAbstract) },
            { assertEquals("kotlin.Boolean", member!!.returnType.toString()) },
        )
    }

    @Test
    fun `ObjetPositionnable verif 8`() {
        var method = kClass.memberFunctions.find { it.name == "deplacer" }
        assertAll(
            { assertEquals(KVisibility.PUBLIC, method!!.visibility) },
            {
                var param = method!!.parameters.find { it.name == "nx" }
                assertEquals("kotlin.Int", param!!.type.toString())
            },
            {
                var param = method!!.parameters.find { it.name == "ny" }
                assertEquals("kotlin.Int", param!!.type.toString())
            },
        )
    }

    @Test
    fun `ObjetPositionnable verif 9`() {
        val method = kClass.memberFunctions.find { it.name == "selectionner" }
        assertAll(
            { assertEquals(KVisibility.PUBLIC, method!!.visibility) },
            {
                var param = method!!.parameters.find { it.name == "ok" }
                assertEquals("kotlin.Boolean", param!!.type.toString())
            },
        )
    }



}
