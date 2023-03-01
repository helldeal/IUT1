import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

import org.junit.jupiter.api.Assertions.*

class TestSomme {
    
    @Test
    fun somme0() {
        val tab =arrayOf(0)
        assertEquals(0, somme(tab))
    }
    @Test
    fun somme1() {
        val tab =arrayOf(1)
        assertEquals(1, somme(tab))
    }
    @Test
    fun somme10() {
        val tab =arrayOf(2, 3, 1, 4)
        assertEquals(10, somme(tab))
    }
    @Test
    fun somme42() {
        val tab =arrayOf(1, 2, 3, 4, 5, 5, 4, 6, 8, 2, 2)
        assertEquals(42, somme(tab))
    }
}