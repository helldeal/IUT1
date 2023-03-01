import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

import org.junit.jupiter.api.Assertions.*

class TestJustePlusGrande {
    
    @Test
    fun justePlusGrande1() {
        val tab =arrayOf(1, 2, 3, 4, 5, 6, 7, 8)
        assertEquals(6, justePlusGrandeQue(tab,5))
    }
   
    @Test
    fun justePlusGrande2() {
        val tab =arrayOf(1, 2, 3, 4, 5, 6, 7, 8)
        tab.shuffle()
        assertEquals(4, justePlusGrandeQue(tab,3))
    }

    @Test
    fun justePlusGrande3() {
        val tab =arrayOf(1, 2, 3, 4, 5, 6, 7, 8)
        assertEquals(null, justePlusGrandeQue(tab,8))
    }
   
    @Test
    fun justePlusGrande4() {
        val tab =arrayOf(1, 2, 3, 4, 5, 6, 7, 8)
        tab.shuffle()
        assertEquals(null, justePlusGrandeQue(tab,8))
    }

    @Test
    fun justePlusGrande5() {
        val tab =arrayOf(8)
        assertEquals(null, justePlusGrandeQue(tab,8))
    }

        @Test
    fun justePlusGrande6() {
        val tab =arrayOf(1, 2, 3, 4, 6, 7, 8)
        assertEquals(6, justePlusGrandeQue(tab,5))
    }
   
    @Test
    fun justePlusGrande7() {
        val tab =arrayOf(1, 2, 4, 5, 6, 7, 8)
        tab.shuffle()
        assertEquals(4, justePlusGrandeQue(tab,3))
    }

    @Test
    fun justePlusGrande8() {
        val tab =arrayOf(1, 2, 3, 4, 5, 6, 7)
        assertEquals(null, justePlusGrandeQue(tab,8))
    }
   
    @Test
    fun justePlusGrande9() {
        val tab =arrayOf(1, 2, 3, 4, 5, 6, 7)
        tab.shuffle()
        assertEquals(null, justePlusGrandeQue(tab,8))
    }

    @Test
    fun justePlusGrande10() {
        val tab =arrayOf(5)
        assertEquals(null, justePlusGrandeQue(tab,8))
    }

        @Test
    fun justePlusGrande11() {
        val tab =arrayOf(5,5)
        assertEquals(null, justePlusGrandeQue(tab,8))
    }
}