import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

import org.junit.jupiter.api.Assertions.*

class TestEnvers {
    
    @Test
    fun envers11() {
        val tab = arrayOf(1, 2, 3, 4, 5, 5, 4, 6, 8, 2, 2)
        val res = arrayOf(2, 2, 8, 6, 4, 5, 5, 4, 3, 2, 1)
        envers(tab)
        assertArrayEquals(res, tab)
    }
    @Test
    fun envers10() {
        val tab = arrayOf(1, 2, 3, 4, 5, 5, 4, 6, 8, 2)
        val res = arrayOf(2, 8, 6, 4, 5, 5, 4, 3, 2, 1)
        envers(tab)
        assertArrayEquals(res, tab)
    }
    @Test
    fun envers3() {
        val tab = arrayOf(6, 8, 2)
        val res = arrayOf(2, 8, 6)
        envers(tab)
        assertArrayEquals(res, tab)
    }
    @Test
    fun envers2() {
        val tab = arrayOf(2, 4)
        val res = arrayOf(4, 2)
        envers(tab)
        assertArrayEquals(res, tab)
    }
    @Test
    fun envers1() {
        val tab = arrayOf(42)
        val res = arrayOf(42)
        envers(tab)
        assertArrayEquals(res, tab)
    }
}