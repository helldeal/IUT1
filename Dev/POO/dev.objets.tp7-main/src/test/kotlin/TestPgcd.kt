import iut.math.pgcd
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TestPgcd {

    @Test
    fun testPgcd() {
        assertEquals(3, pgcd(6, 9))
    }

    @Test
    fun testPgcd2() {
        assertEquals(1, pgcd(2, 3))
    }

    @Test
    fun testPgcd3() {
        assertEquals(6, pgcd(18, 12))
    }
}