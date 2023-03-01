import iut.collections.ListeChainee
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class TestListeChainee {

    var liste = ListeChainee<Int>()

    @BeforeEach
    fun init() {
        liste = ListeChainee<Int>()
    }

    @Test
    fun `liste = file vide`() {
        assertAll(
            { assertTrue(liste.estVide()) },
            { assertEquals(0, liste.taille()) },
            { assertThrows<NoSuchElementException> {liste.consulterEnTete()} },
            { assertThrows<NoSuchElementException> {liste.supprimerEnTete()} },
        )
    }

    @Test
    fun `liste = file 1 elt`() {
        liste.insererEnTete(42)
        assertAll(
            { assertFalse(liste.estVide()) },
            { assertEquals(1, liste.taille()) },
            { assertDoesNotThrow { liste.consulterEnTete() }},
            { assertDoesNotThrow { liste.supprimerEnTete() }},
        )
    }

    @Test
    fun `liste = file 1 elt - consulter`() {
        liste.insererEnTete(42)
        val res = liste.consulterEnTete()
        assertEquals(42, res)
        assertAll(
            { assertFalse(liste.estVide()) },
            { assertEquals(1, liste.taille()) },
        )
    }

    @Test
    fun `liste = file 1 elt - depiler`() {
        liste.insererEnTete(42)
        val res = liste.depiler()
        assertEquals(42, res)
        assertAll(
            { assertTrue(liste.estVide()) },
            { assertEquals(0, liste.taille()) },
        )
    }

    @Test
    fun `liste = file plusieurs elts - consulter`() {
        liste.empiler(42)
        liste.empiler(0)
        liste.empiler(-2)
        liste.empiler(4)
        liste.empiler(-42)
        liste.empiler(-4)
        liste.empiler(99)
        assertAll(
            { assertFalse(liste.estVide()) },
            { assertEquals(7, liste.taille()) },
        )
        val res = liste.consulter()
        assertEquals(99, res)
        assertAll(
            { assertFalse(liste.estVide()) },
            { assertEquals(7, liste.taille()) },
        )
    }

    @Test
    fun `liste = pile plusieurs elts - depiler`() {
        liste.empiler(42)
        liste.empiler(0)
        liste.empiler(-2)
        liste.empiler(99)
        liste.empiler(4)
        liste.empiler(-42)
        liste.empiler(-4)

        assertAll(
            { assertFalse(liste.estVide()) },
            { assertEquals(7, liste.taille()) },
        )
        liste.depiler()
        liste.depiler()
        liste.depiler()
        val res = liste.depiler()
        assertEquals(99, res)
        assertAll(
            { assertFalse(liste.estVide()) },
            { assertEquals(3, liste.taille()) },
        )
    }

    @Test
    fun `liste = pile plusieurs elts - index`() {
        liste.empiler(42)
        liste.empiler(0)
        liste.empiler(-2)
        liste.empiler(99)
        liste.empiler(4)
        liste.empiler(-42)
        liste.empiler(-4)
        assertAll(
            { assertEquals(6, liste.index(42)) },
            { assertEquals(3, liste.index(99)) },
            { assertEquals(0, liste.index(-4)) },
            { assertEquals(-1, liste.index(1)) },
            { assertEquals(-1, liste.index(10000)) },
        )
    }

    @Test
    fun `liste = file plusieurs elts - index`() {
        liste.insererEnTete(42)
        liste.insererEnTete(0)
        liste.insererEnTete(-2)
        liste.insererEnTete(99)
        liste.insererEnTete(4)
        liste.insererEnTete(-42)
        liste.insererEnTete(-4)
        assertAll(
            { assertEquals(6, liste.index(42)) },
            { assertEquals(3, liste.index(99)) },
            { assertEquals(0, liste.index(-4)) },
            { assertEquals(-1, liste.index(1)) },
            { assertEquals(-1, liste.index(10000)) },
        )
    }

    @Test
    fun `liste vide - inserer 0`() {
        assertDoesNotThrow { liste.inserer(0, 42) }
        assertAll(
            { assertFalse(liste.estVide()) },
            { assertEquals(1, liste.taille()) },
        )
    }

    @Test
    fun `liste vide - inserer 1 exception`() {
        assertThrows<IndexOutOfBoundsException>
        {liste.inserer(1, 42)}
    }

    @Test
    fun `liste vide - inserer 4 exception`() {
        assertThrows<IndexOutOfBoundsException>
            {liste.inserer(4, 42)}
    }

    @ParameterizedTest(name = "inserer en position {0}")
    @ValueSource(ints = [0,1,2,3,4,5,6])
    fun `liste plusieurs elts - inserer`(pos : Int) {
        liste.insererEnTete(42)     //5
        liste.insererEnTete(0)      //4
        liste.insererEnTete(-2)     //3
        liste.insererEnTete(4)      //2
        liste.insererEnTete(-42)    //1
        liste.insererEnTete(-4)     //0
        assertDoesNotThrow { liste.inserer(pos, 99) }
        assertAll(
            { assertFalse(liste.estVide()) },
            { assertEquals(7, liste.taille()) },
            { assertEquals(pos, liste.index(99))},
            {assertEquals(99, liste.consulter(pos))},
        )
    }

    @ParameterizedTest(name = "inserer en position - details {0}")
    @ValueSource(ints = [1,2,3,4,5])
    fun `liste plusieurs elts - inserer details`(pos : Int) {
        liste.insererEnTete(42)     //5
        liste.insererEnTete(0)      //4
        liste.insererEnTete(-2)     //3
        liste.insererEnTete(4)      //2
        liste.insererEnTete(-42)    //1
        liste.insererEnTete(-4)     //0
        val avant = liste.consulter(pos-1)
        val apres = liste.consulter(pos)
        assertDoesNotThrow { liste.inserer(pos, 99) }
        assertAll(
            {assertEquals(avant, liste.consulter(pos-1))},
            {assertEquals(99, liste.consulter(pos))},
            {assertEquals(apres, liste.consulter(pos+1))},
        )
    }

    @ParameterizedTest(name = "inserer en position {0} exception")
    @ValueSource(ints = [-10,-1,7,10])
    fun `liste plusieurs elts - inserer exception`(pos : Int) {
        liste.insererEnTete(42)     //5
        liste.insererEnTete(0)      //4
        liste.insererEnTete(-2)     //3
        liste.insererEnTete(4)      //2
        liste.insererEnTete(-42)    //1
        liste.insererEnTete(-4)     //0
        assertThrows<IndexOutOfBoundsException>
            { liste.inserer(pos, 99) }
    }

    @ParameterizedTest(name = "supprimer en position {0}")
    @ValueSource(ints = [0,1,2,3,4])
    fun `liste plusieurs elts - supprimer`(pos : Int) {
        liste.insererEnTete(42)     //5
        liste.insererEnTete(0)      //4
        liste.insererEnTete(-2)     //3
        liste.insererEnTete(4)      //2
        liste.insererEnTete(-42)    //1
        liste.insererEnTete(-4)     //0
        val apres = liste.consulter(pos+1)
        val element = liste.consulter(pos)
        assertDoesNotThrow { liste.supprimer(pos) }
        assertAll(
            { assertEquals(-1, liste.index(element)) },
            { assertEquals(apres, liste.consulter(pos)) },
        )
    }

    @ParameterizedTest(name = "supprimer en position - details {0}")
    @ValueSource(ints = [0,1,2,3,4,5])
    fun `liste plusieurs elts - supprimer details`(pos : Int) {
        liste.insererEnTete(42)     //5
        liste.insererEnTete(0)      //4
        liste.insererEnTete(-2)     //3
        liste.insererEnTete(4)      //2
        liste.insererEnTete(-42)    //1
        liste.insererEnTete(-4)     //0
        val element = liste.consulter(pos)
        assertDoesNotThrow { liste.supprimer(pos) }
        assertAll(
            { assertEquals(-1, liste.index(element))},
        )
    }

    @ParameterizedTest(name = "supprimer en position {0} exception")
    @ValueSource(ints = [-10,-1,6,7,10])
    fun `liste plusieurs elts - supprimer exception`(pos : Int) {
        liste.insererEnTete(42)     //5
        liste.insererEnTete(0)      //4
        liste.insererEnTete(-2)     //3
        liste.insererEnTete(4)      //2
        liste.insererEnTete(-42)    //1
        liste.insererEnTete(-4)     //0
        assertThrows<IndexOutOfBoundsException>
        { liste.supprimer(pos) }
    }

    @Test
    fun `liste file vide - ajouterEnQueue`() {
        liste.insererEnQueue(42)
        assertAll(
            { assertFalse(liste.estVide()) },
            { assertEquals(1, liste.taille()) },
            { assertDoesNotThrow { liste.consulterEnTete() }},
            { assertDoesNotThrow { liste.supprimerEnTete() }},
        )
    }

    @Test
    fun `liste file vide - SupprimerConsulterEnQueue`() {
        assertAll(
            { assertTrue(liste.estVide()) },
            { assertEquals(0, liste.taille()) },
            { assertThrows<NoSuchElementException> {liste.supprimerEnQueue()} },
            { assertThrows<NoSuchElementException> {liste.consulterEnQueue()} },
        )
    }

    @Test
    fun `liste 1 element - ajouterSupprimerConsulterEnQueue`() {
        liste.insererEnQueue(42)
        assertAll(
            { assertFalse(liste.estVide()) },
            { assertEquals(1, liste.taille()) },
            { assertDoesNotThrow { liste.consulterEnQueue() }},
            { assertDoesNotThrow { liste.supprimerEnQueue() }},
        )
    }

    @Test
    fun `liste 1 element - ajouter - SupprimerConsulterEnQueue`() {
        liste.insererEnQueue(42)
        assertEquals(42, liste.consulterEnQueue())
        assertDoesNotThrow { liste.supprimerEnQueue() }
        assertAll(
            { assertTrue(liste.estVide()) },
            { assertEquals(0, liste.taille()) },
        )
    }
}