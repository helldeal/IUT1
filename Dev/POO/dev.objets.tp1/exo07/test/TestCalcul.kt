import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

import org.junit.jupiter.api.Assertions.*

class TestCalcul {
    
    @Test
    fun calcul0() {
        assertEquals(5, calcul(0))
    }

    @Test
    fun calcul10() {
        assertEquals(35, calcul(10))
    }

    @Test
    fun calculMin5() {
        assertEquals(-10, calcul(-5))
    }

    fun estPair3() {
        assertFalse(estPair(3))
    }

    @ParameterizedTest(name = "estPair{0}")
    @ValueSource(ints = [0, 2, 4, 6, 8, 10, 100, 20_000, -10, Int.MIN_VALUE])
    fun verifPair(candidate: Int) {
        assertTrue(estPair(candidate))
    }

    @ParameterizedTest(name = "nEstPasPair{0}")
    @ValueSource(ints = [1, 3, 5, 7, 101, 20_003, -5, -10_007, Int.MAX_VALUE])
    fun verifImpair(candidate: Int) {
        assertFalse(estPair(candidate))
    }
}