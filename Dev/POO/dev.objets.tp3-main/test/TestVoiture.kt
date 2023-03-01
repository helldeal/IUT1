import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Assertions.*

class TestVoiture {
    
    val batman = Personne(nom = "Wayne", prenom = "Bruce")
    var batmobile = Voiture(mod = "Batmobile Tumbler", vitMax = 257.0, coul = "noire")

    @BeforeEach
    fun initTest() {
        batmobile = Voiture(mod = "Batmobile Tumbler", vitMax = 257.0, coul = "noire")
        batmobile.acheter(acheteur = batman)
    }

    @Test
    fun batmobile_init() {
        assertFalse(batmobile.estEnMarche())
    }

    @Test
    fun batmobile_demarrer() {
        batmobile.demarrer()
        assertTrue(batmobile.estEnMarche())
    }

    @Test
    fun batmobile_roule() {
        batmobile.demarrer()
        assertEquals(75.3, batmobile.accelerer(acceleration = 75.3))
    }

    @Test
    fun batmobile_roule2() {
        batmobile.demarrer()
        batmobile.accelerer(acceleration = 75.3)
        batmobile.accelerer(acceleration = 72.5)
        assertEquals(75.3 + 72.5 - 12.4,  batmobile.decelerer(deceleration = 12.4))
    }

    @Test
    fun batmobile_roule3() {
        batmobile.demarrer()
        batmobile.accelerer(acceleration = 75.3)
        batmobile.arreter()
        assertEquals(0.0, batmobile.accelerer(acceleration = 72.5))
    }

    @Test
    fun batmobile_roule4() {
        batmobile.demarrer()
        batmobile.accelerer(acceleration = 200.0)
        assertEquals(257.0, batmobile.accelerer(acceleration = 75.3))
    }

    @Test
    fun batmobile_roule5() {
        batmobile.demarrer()
        batmobile.accelerer(acceleration = 75.3)
        assertEquals(75.3, batmobile.accelerer(acceleration = -10.0))
    }

    @Test
    fun batmobile_roule6() {
        batmobile.demarrer()
        batmobile.accelerer(acceleration = 75.3)
        assertEquals(75.3, batmobile.decelerer(deceleration = -10.0))
    }

    @Test
    fun batmobile_roule7() {
        batmobile.demarrer()
        batmobile.accelerer(acceleration = 75.3)
        batmobile.arreter()
        batmobile.demarrer()
        assertEquals(72.5, batmobile.accelerer(acceleration = 72.5))
    }
}