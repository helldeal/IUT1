import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

import org.junit.jupiter.api.Assertions.*

class TestRecherche {
    
    @Test
    fun recherche1() {
        val tab =arrayOf(1, 2, 3, 4, 5, 5, 4, 6, 8, 2, 2)
        assertEquals(0, recherche(tab, 1))
    }
    @Test
    fun recherche2() {
        val tab =arrayOf(1, 2, 3, 4, 5, 5, 4, 6, 8, 2, 2)
        assertEquals(1, recherche(tab, 2))
    }
    @Test
    fun recherche6() {
        val tab =arrayOf(1, 2, 3, 4, 5, 5, 4, 6, 8, 2, 2)
        assertEquals(7, recherche(tab, 6))
    }
    @Test
    fun recherche42() {
        val tab =arrayOf(1, 2, 3, 4, 5, 5, 4, 6, 8, 2, 2)
        assertEquals(-1, recherche(tab, 42))
    }
}