import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

import kotlin.reflect.full.allSuperclasses
import kotlin.reflect.full.memberProperties
import kotlin.reflect.KVisibility
import kotlin.reflect.full.memberFunctions

class TestTexte {

    val kClass = Texte::class
    @Test
    fun `Texte verif`() {
        assertAll(
            {assertFalse(kClass.isAbstract)},
            {assertFalse(kClass.isOpen)},
        )
    }

    @Test
    fun `Texte verif 2`() {
        var extend = kClass.allSuperclasses.find{it.simpleName == "Selectionnable"}
        assertNotNull(extend)
    }

    @Test
    fun `Texte verif 3`() {
        var extend = kClass.allSuperclasses.find{it.simpleName == "ObjetGraphique"}
        assertNotNull(extend)
    }

    @Test
    fun `Texte verif 4`() {
        var extend = kClass.allSuperclasses.find{it.simpleName == "Manipulable"}
        assertNotNull(extend)
    }

    @Test
    fun `Texte verif 5`() {
        var extend = kClass.allSuperclasses.find{it.simpleName == "ObjetPositionnable"}
        assertNotNull(extend)
    }

    @Test
    fun `Texte verif 6`() {
        var extend = kClass.allSuperclasses.find{it.simpleName == "Editable"}
        assertNotNull(extend)
    }

    @Test
    fun `Texte verif 7`() {
        var member = kClass.memberProperties.find { it.name == "valeur" }
        assertAll(
            {assertEquals(KVisibility.PRIVATE, member!!.visibility)},
            {assertFalse(member!!.isOpen)},
            {assertFalse(member!!.isAbstract)},
            {assertEquals("kotlin.String", member!!.returnType.toString())},
        )
    }

    @Test
    fun `Texte verif 8`() {
        var member = kClass.memberProperties.find { it.name == "police" }
        assertAll(
            {assertEquals(KVisibility.PRIVATE, member!!.visibility)},
            {assertFalse(member!!.isOpen)},
            {assertFalse(member!!.isAbstract)},
            {assertEquals("kotlin.String", member!!.returnType.toString())},
        )
    }

    @Test
    fun `Texte verif 9`() {
        var member = kClass.memberProperties.find { it.name == "taille" }
        assertAll(
            {assertEquals(KVisibility.PRIVATE, member!!.visibility)},
            {assertFalse(member!!.isOpen)},
            {assertFalse(member!!.isAbstract)},
            {assertEquals("kotlin.Int", member!!.returnType.toString())},
        )
    }

    @Test
    fun `Texte verif 10`() {
        val method = kClass.memberFunctions.find { it.name == "editer" }
        assertAll(
            {assertEquals(KVisibility.PUBLIC, method!!.visibility)},
            {var param = method!!.parameters.find {it.name =="nouveau" }
                assertEquals("kotlin.String", param!!.type.toString())},
        )
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
    fun `Deplacable verif 3`() {
        var method = kClass.memberFunctions.find { it.name == "dessiner" }
        assertEquals(KVisibility.PUBLIC, method!!.visibility)
    }

    @Test
    fun `dessiner`() {
       val objet : Manipulable = Texte(4,2, "reponse universelle")
        assertEquals("\"reponse universelle\":X=4,Y=2,P=Times,S=10", objet.dessiner())
    }
}
