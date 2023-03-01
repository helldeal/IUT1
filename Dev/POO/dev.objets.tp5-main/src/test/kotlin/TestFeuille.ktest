import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

import kotlin.reflect.full.allSuperclasses
import kotlin.reflect.full.memberProperties
import kotlin.reflect.KVisibility
import kotlin.reflect.full.memberFunctions

class TestFeuille {

    val kClass = Feuille::class
    @Test
    fun `Feuille verif`() {
        assertAll(
            {assertFalse(kClass.isAbstract)},
            {assertFalse(kClass.isOpen)},
        )
    }

    @Test
    fun `Feuille verif 2`() {
       var member = kClass.memberProperties.find { it.name == "hauteur" }
                    assertAll(
                        {assertEquals(KVisibility.PRIVATE, member!!.visibility)},
                        {assertFalse(member!!.isOpen)},
                        {assertFalse(member!!.isAbstract)},
                        {assertEquals("kotlin.Int", member!!.returnType.toString())},
            )
    }

    @Test
    fun `Feuille verif 3`() {
        var member = kClass.memberProperties.find { it.name == "largeur" }
                assertAll(
                    {assertEquals(KVisibility.PRIVATE, member!!.visibility)},
                    {assertFalse(member!!.isOpen)},
                    {assertFalse(member!!.isAbstract)},
        )
    }

    @Test
    fun `Feuille verif 4`() {
        var member = kClass.memberProperties.find { it.name == "objetsContenus" }
                assertAll(
                    {assertEquals(KVisibility.PRIVATE, member!!.visibility)},
                    {assertFalse(member!!.isOpen)},
                    {assertFalse(member!!.isAbstract)},
                    {assertEquals("kotlin.Array<ObjetGraphique?>", member!!.returnType.toString())},
        )
    }

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
    fun `Feuille 5`() {
        val method = kClass.memberFunctions.find { it.name == "inserer" }
        assertAll(
            {assertEquals(KVisibility.PUBLIC, method!!.visibility)},
            {var param = method!!.parameters.find {it.name =="nouvelObjet" }
                assertEquals("ObjetGraphique", param!!.type.toString())},
        )
    }

}
