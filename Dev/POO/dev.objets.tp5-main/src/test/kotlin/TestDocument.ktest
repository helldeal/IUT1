import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

import kotlin.reflect.full.allSuperclasses
import kotlin.reflect.full.memberProperties
import kotlin.reflect.KVisibility
import kotlin.reflect.full.memberFunctions

class TestDocument {
    val kClass = Document::class
    @Test
    fun `Document verif`() {
        var extend = kClass.allSuperclasses.find{it.simpleName == "Editable"}
        assertNotNull(extend)
    }


    @Test
    fun `Document verif 1`() {
        assertAll(
            { assertFalse(kClass.isAbstract) },
            { assertFalse(kClass.isOpen) },
        )
    }

    @Test
    fun `Document verif 2`() {
        var member = kClass.memberProperties.find { it.name == "nomDeFichier" }
        assertAll(
            {assertEquals(KVisibility.PRIVATE, member!!.visibility)},
            {assertFalse(member!!.isOpen)},
            {assertFalse(member!!.isAbstract)},
            {assertEquals("kotlin.String", member!!.returnType.toString())},
        )
    }

    @Test
    fun `Document verif 3`() {
       var member = kClass.memberProperties.find { it.name == "feuillesAssociees" }
        assertAll(
            {assertEquals(KVisibility.PRIVATE, member!!.visibility)},
            {assertFalse(member!!.isOpen)},
            {assertFalse(member!!.isAbstract)},
            {assertEquals("kotlin.Array<Feuille?>", member!!.returnType.toString())},
        )
    }

    @Test
    fun `Document 4`() {
        val method = kClass.memberFunctions.find { it.name == "editer" }
        assertAll(
            {assertEquals(KVisibility.PUBLIC, method!!.visibility)},
            {var param = method!!.parameters.find {it.name =="nouveau" }
                assertEquals("kotlin.String", param!!.type.toString())},
        )
    }

    @Test
    fun `Document 5`() {
        val method = kClass.memberFunctions.find { it.name == "nouvelleFeuille" }
        assertEquals(KVisibility.PUBLIC, method!!.visibility)
    }

    @Test
    fun `Document 6`() {
        val method = kClass.memberFunctions.find { it.name == "donneFeuille" }
        assertAll(
            {assertEquals(KVisibility.PUBLIC, method!!.visibility)},
            {var param = method!!.parameters.find {it.name =="position" }
                assertEquals("kotlin.Int", param!!.type.toString())},
        )
    }

    @Test
    fun document_1feuille() {
        val doc = Document("monsuperfichier")
        assertAll(
            {assertNotNull(doc.donneFeuille(0))},
            {assertNull(doc.donneFeuille(1))},
            {assertNull(doc.donneFeuille(9))},
            {assertNull(doc.donneFeuille(10))},
            {assertNull(doc.donneFeuille(100))},
        )
    }

    @Test
    fun document_6feuilles() {
        val doc = Document("monsuperfichier")
        doc.nouvelleFeuille()
        doc.nouvelleFeuille()
        doc.nouvelleFeuille()
        doc.nouvelleFeuille()
        val maDerniereFeuille = doc.nouvelleFeuille()
        assertAll(
            {assertNotNull(doc.donneFeuille(0))},
            {assertNotNull(maDerniereFeuille)},
            {assertEquals(maDerniereFeuille, doc.donneFeuille(5)) },
            {assertNull(doc.donneFeuille(6))},
            {assertNull(doc.donneFeuille(9))},
            {assertNull(doc.donneFeuille(10))},
            {assertNull(doc.donneFeuille(100))},
        )
    }

    @Test
    fun document_10feuilles() {
        val doc = Document("monsuperfichier")
        doc.nouvelleFeuille()
        doc.nouvelleFeuille()
        doc.nouvelleFeuille()
        doc.nouvelleFeuille()
        doc.nouvelleFeuille()
        doc.nouvelleFeuille()
        doc.nouvelleFeuille()
        doc.nouvelleFeuille()
        val maDerniereFeuille = doc.nouvelleFeuille()
        assertAll(
            {assertNotNull(doc.donneFeuille(0))},
            {assertNotNull(maDerniereFeuille)},
            {assertEquals(maDerniereFeuille, doc.donneFeuille(9)) },
            {assertNull(doc.donneFeuille(10))},
            {assertNull(doc.donneFeuille(100))},
        )
    }

    @Test
    fun document_11feuilles() {
        val doc = Document("monsuperfichier")
        doc.nouvelleFeuille()
        doc.nouvelleFeuille()
        doc.nouvelleFeuille()
        doc.nouvelleFeuille()
        doc.nouvelleFeuille()
        doc.nouvelleFeuille()
        doc.nouvelleFeuille()
        doc.nouvelleFeuille()
        doc.nouvelleFeuille()
        val maDerniereFeuille = doc.nouvelleFeuille()
        assertNull(maDerniereFeuille)
    }


}
