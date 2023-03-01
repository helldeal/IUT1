import iut.collections.PileChainee
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*

class TestPileChainee {

    var pile = PileChainee<Int>()

    @BeforeEach
    fun init() {
        pile = PileChainee<Int>()
    }

    @Test
    fun `pile vide`() {
        assertAll(
            { assertTrue(pile.estVide()) },
            { assertEquals(0, pile.taille()) },
            { assertThrows<NoSuchElementException> {pile.consulter()} },
            { assertThrows<NoSuchElementException> {pile.depiler()} },
        )
    }

    @Test
    fun `pile 1 elt`() {
        pile.empiler(42)
        assertAll(
            { assertFalse(pile.estVide()) },
            { assertEquals(1, pile.taille()) },
            { assertDoesNotThrow { pile.consulter() }},
            { assertDoesNotThrow { pile.depiler() }},
        )
    }

    @Test
    fun `pile 1 elt - consulter`() {
        pile.empiler(42)
        val res = pile.consulter()
        assertEquals(42, res)
        assertAll(
            { assertFalse(pile.estVide()) },
            { assertEquals(1, pile.taille()) },
        )
    }

    @Test
    fun `pile 1 elt - depiler`() {
        pile.empiler(42)
        val res = pile.depiler()
        assertEquals(42, res)
        assertAll(
            { assertTrue(pile.estVide()) },
            { assertEquals(0, pile.taille()) },
        )
    }

    @Test
    fun `pile plusieurs elts - consulter`() {
        pile.empiler(42)
        pile.empiler(0)
        pile.empiler(-2)
        pile.empiler(4)
        pile.empiler(-42)
        pile.empiler(-4)
        pile.empiler(99)
        assertAll(
            { assertFalse(pile.estVide()) },
            { assertEquals(7, pile.taille()) },
        )
        val res = pile.consulter()
        assertEquals(99, res)
        assertAll(
            { assertFalse(pile.estVide()) },
            { assertEquals(7, pile.taille()) },
        )
    }

    @Test
    fun `pile plusieurs elts - depiler`() {
        pile.empiler(42)
        pile.empiler(0)
        pile.empiler(-2)
        pile.empiler(99)
        pile.empiler(4)
        pile.empiler(-42)
        pile.empiler(-4)

        assertAll(
            { assertFalse(pile.estVide()) },
            { assertEquals(7, pile.taille()) },
        )
        pile.depiler()
        pile.depiler()
        pile.depiler()
        val res = pile.depiler()
        assertEquals(99, res)
        assertAll(
            { assertFalse(pile.estVide()) },
            { assertEquals(3, pile.taille()) },
        )
    }


}