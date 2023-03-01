import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class TestCalculette {
    
    @Test
    fun `2 + 4 == 6`() {
        assertEquals(6, add(2, 4))
    }

    @Test
    fun `2 + 3 == 5`() {
        assertEquals(5, add(2, 3))
    }

    @Test
    fun `2 x 2 == 4`() {
        assertEquals(4, mult(2, 2))
    }

    @Test
    fun `3 x 3 == 9`() {
        assertEquals(9, mult(3, 3))
    }

    @Test
    fun `2 x 3 == 6`() {
        assertEquals(6, mult(2, 3))
    }


}