import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

import org.junit.jupiter.api.Assertions.*

class TestPlusGrand {
    
    @Test
    fun lePlusGrand1() {
        val tab =arrayOf(1, 2, 3, 4, 5, 5, 4, 6, 8, 2, 2)
        assertEquals(8, lePlusGrand(tab))
    }
    @Test
    fun lePlusGrand2() {
        val tab =arrayOf(1, 2, 3, 4, 5, 5, 4, 6, 8, 2, 2, 42)
        assertEquals(42, lePlusGrand(tab))
    }
    @Test
    fun lePlusGrand6() {
        val tab =arrayOf(42, 1, 2, 3, 4, 5, 5, 4, 6, 8, 2, 2)
        assertEquals(42, lePlusGrand(tab))
    }
    @Test
    fun lePlusGrand4() {
        val tab =arrayOf(1, 2, 3, 4, 5, 5, 4, 6, 42, 2, 2)
        assertEquals(42, lePlusGrand(tab))
    }

    @Test
    fun lePlusGrand42() {
        val tab =arrayOf(42)
        assertEquals(42, lePlusGrand(tab))
    }
    @Test
    fun lePlusGrand0() {
        val tab = arrayOf<Int>()
        assertEquals(null, lePlusGrand(tab))
    }
}