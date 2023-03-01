import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TestMarchandise {

    val m1 = Marchandise(poids = 100.0, volume = 78.0)

    @Test
    fun testMarchandise() {
        assertAll(
            { assertEquals(100.0, m1.donnePoids()) },
            { assertEquals(78.0, m1.donneVolume()) },
        )
    }

    @Test
    fun testCargaisonRoutiere() {
        val ca = CargaisonRoutiere(distance = 10)
        assertAll(
            { assertEquals(0.0, ca.cout()) },
            { assertEquals(-1, ca.rechercher(m1)) }
        )
        assertTrue(ca.ajouter(marchandiseAjoutee = m1))
        assertAll(
            { assertEquals((4 * 10 * 100.0), ca.cout())},
            { assertTrue(ca.rechercher(marchandiseRecherchee = m1) != -1) }
        )
        for (i in 0 until 70) {
            ca.ajouter(Marchandise(10.0, 10.0))
        }
        assertTrue(ca.ajouter(Marchandise(37000.0, 1.0)))
        assertEquals((4 * 10 * (100.0 +37000.0 + (70 * 10.0))), ca.cout())
        assertTrue(ca.ajouter(Marchandise(199.99, 1.0)))
        assertFalse(ca.ajouter(Marchandise(20.0, 1.0)))
    }
    @Test
    fun testCargaisonFluviale() {
        val ca = CargaisonFluviale(distance = 10)
        assertAll(
            { assertEquals(0.0, ca.cout()) },
            { assertEquals(-1, ca.rechercher(m1)) }
        )
        assertTrue(ca.ajouter(marchandiseAjoutee = m1))
        assertAll(
            { assertEquals((1 * 10 * 100.0), ca.cout())},
            { assertTrue(ca.rechercher(marchandiseRecherchee = m1) != -1) }
        )
        for (i in 0 until 70) {
            ca.ajouter(Marchandise(10.0, 10.0))
        }
        assertTrue(ca.ajouter(Marchandise(37000.0, 1.0)))
        assertEquals((1 * 10 * (100.0 +37000.0 + (70 * 10.0))), ca.cout())
        assertTrue(ca.ajouter(Marchandise(199.99, 1.0)))
        assertFalse(ca.ajouter(Marchandise(300000.0, 1.0)))
    }
    @Test
    fun testCargaisonAérienne() {
        val ca = CargaisonAerienne(distance = 10)
        assertAll(
            { assertEquals(0.0, ca.cout()) },
            { assertEquals(-1, ca.rechercher(m1)) }
        )
        assertTrue(ca.ajouter(marchandiseAjoutee = m1))
        assertAll(
            { assertEquals((10 * 10 * 78.0), ca.cout())},
            { assertTrue(ca.rechercher(marchandiseRecherchee = m1) != -1) }
        )
        for (i in 0 until 70) {
            ca.ajouter(Marchandise(10.0, 10.0))
        }
        assertTrue(ca.ajouter(Marchandise(37000.0, 1.0)))
        assertEquals((10 * 10 * (78.0 +1 + (70 * 10.0))), ca.cout())
        assertTrue(ca.ajouter(Marchandise(199.99, 1.0)))
        assertFalse(ca.ajouter(Marchandise(1.0, 80000.0)))
    }
    @Test
    fun testCargaisonAérienneUrgente() {
        val ca = CargaisonAerienneUrgente(distance = 10)
        assertAll(
            { assertEquals(0.0, ca.cout()) },
            { assertEquals(-1, ca.rechercher(m1)) }
        )
        assertTrue(ca.ajouter(marchandiseAjoutee = m1))
        assertAll(
            { assertEquals((20 * 10 * 78.0), ca.cout())},
            { assertTrue(ca.rechercher(marchandiseRecherchee = m1) != -1) }
        )
        for (i in 0 until 70) {
            ca.ajouter(Marchandise(10.0, 10.0))
        }
        assertTrue(ca.ajouter(Marchandise(37000.0, 1.0)))
        assertEquals((20 * 10 * (78.0 +1 + (70 * 10.0))), ca.cout())
        assertTrue(ca.ajouter(Marchandise(199.99, 1.0)))
        assertFalse(ca.ajouter(Marchandise(1.0, 80000.0)))
    }
}


