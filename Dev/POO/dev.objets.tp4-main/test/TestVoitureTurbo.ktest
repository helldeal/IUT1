import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.api.Assertions.*

import kotlin.reflect.full.allSuperclasses
import kotlin.reflect.full.memberProperties
import kotlin.reflect.KVisibility


class TestVoitureTurbo {

    @ParameterizedTest(name = "attribute {0} exists and is private ")
    @CsvSource("turbo")
    fun `private attributes`(attributeName : String) {
        val member = VoitureTurbo::class.memberProperties.find{it.name == attributeName}
        assertNotNull(member)
        assertEquals(KVisibility.PRIVATE, member!!.visibility)
    }

    @ParameterizedTest(name = "extended class or interface {0}")
    @CsvSource("Propriete", "Vehicule", "Voiture")
    fun `extended classes`(className : String) {
        val member = VoitureTurbo::class.allSuperclasses.find{it.simpleName == className}
        assertNotNull(member)
    }    
    
    val batman = Personne(nom = "Wayne", prenom = "Bruce")
    var batmobile = VoitureTurbo(mod = "Batmobile Tumbler", vitMax = 257.0, coul = "noire")

    @BeforeEach
    fun initTest() {
        batmobile = VoitureTurbo(mod = "Batmobile Tumbler", vitMax = 257.0, coul = "noire")
        batmobile.acheter(acheteur = batman)
    }

    @Test
    fun batmobile_init() {
        assertFalse(batmobile.estEnMarche())
    }

    @Test
    fun batmobile_demarrer_sans() {
        batmobile.demarrer()
        assertFalse(batmobile.estEnMarche())
    }
    
    @Test
    fun batmobile_demarrer_avec() {
        batmobile.devientConducteur(batman)
        batmobile.demarrer()
        assertTrue(batmobile.estEnMarche())
    }

    @Test
    fun batmobile_roule() {
        batmobile.devientConducteur(batman)
        batmobile.demarrer()
        assertEquals(75.3, batmobile.accelerer(acceleration = 75.3))
    }

    @Test
    fun batmobile_roule2() {
        batmobile.devientConducteur(batman)
        batmobile.demarrer()
        batmobile.accelerer(acceleration = 75.3)
        batmobile.accelerer(acceleration = 72.5)
        assertEquals(75.3 + 72.5 - 12.4,  batmobile.decelerer(deceleration = 12.4))
    }

    @Test
    fun batmobile_roule3() {
        batmobile.devientConducteur(batman)
        batmobile.demarrer()
        batmobile.accelerer(acceleration = 75.3)
        batmobile.arreter()
        assertEquals(0.0, batmobile.accelerer(acceleration = 72.5))
    }

    @Test
    fun batmobile_roule4() {
        batmobile.devientConducteur(batman)
        batmobile.demarrer()
        batmobile.accelerer(acceleration = 200.0)
        assertEquals(257.0, batmobile.accelerer(acceleration = 75.3))
    }

    @Test
    fun batmobile_roule5() {
        batmobile.devientConducteur(batman)
        batmobile.demarrer()
        batmobile.accelerer(acceleration = 75.3)
        assertEquals(75.3, batmobile.accelerer(acceleration = -10.0))
    }

    @Test
    fun batmobile_roule6() {
        batmobile.devientConducteur(batman)
        batmobile.demarrer()
        batmobile.accelerer(acceleration = 75.3)
        assertEquals(75.3, batmobile.decelerer(deceleration = -10.0))
    }

    @Test
    fun batmobile_roule7() {
        batmobile.devientConducteur(batman)
        batmobile.demarrer()
        batmobile.accelerer(acceleration = 75.3)
        batmobile.arreter()
        batmobile.demarrer()
        assertEquals(72.5, batmobile.accelerer(acceleration = 72.5))
    }

    @Test
    fun batmobile_roule_sans() {
        batmobile.devientConducteur(batman)
        batmobile.demarrer()
        batmobile.accelerer(acceleration = 75.3)
        batmobile.plusDeConducteur()
        assertEquals(0.0, batmobile.accelerer(acceleration = 72.5))
    }

    @Test
    fun batmobile_roule_turbo() {
        batmobile.devientConducteur(batman)
        batmobile.demarrer()
        batmobile.accelerer(acceleration = 75.3)
        batmobile.changeTurbo(etat = true)
        batmobile.accelerer(acceleration = 20.0)
        assertEquals(75.3 + (3*20) - 12.4,  batmobile.decelerer(deceleration = 12.4))
    }
}