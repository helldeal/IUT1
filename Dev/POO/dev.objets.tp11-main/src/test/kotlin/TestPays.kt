import exo2.Pays
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class TestPays {
    var france: Pays? = null
    var allemagne: Pays? = null
    var france2: Pays? = null
    @BeforeEach
    fun setUp() {
        allemagne = Pays("Allemagne", "Berlin", "Europe", 81413145, 357021.0)
        france = Pays("France", "Paris", "Europe", 66808385, 640597.0)
        france2 = Pays("France", "", "", 0, 0.0)
    }

    @Test
    fun compareTo() {
        Assertions.assertTrue(allemagne!!.compareTo(france!!) > 0)
        Assertions.assertTrue(france!!.compareTo(france2!!) > 0)
        Assertions.assertTrue(france!!.compareTo(france!!) == 0)
    }

    @Test
    fun testEquals() {
        Assertions.assertEquals(france, france2)
        Assertions.assertNotEquals(allemagne, france)
    }
}