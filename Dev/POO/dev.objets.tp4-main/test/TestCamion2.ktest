import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.api.Assertions.*

import kotlin.reflect.full.allSuperclasses
import kotlin.reflect.full.memberProperties
import kotlin.reflect.KVisibility

class TestCamion2 {

    @ParameterizedTest(name = "attribute {0} exists and is private ")
    @CsvSource("remorque", "placesOccupees")
    fun `private attributes`(attributeName : String) {
        val member = Camion::class.memberProperties.find{it.name == attributeName}
        assertNotNull(member)
        assertEquals(KVisibility.PRIVATE, member!!.visibility)
    }

    @ParameterizedTest(name = "extended class or interface {0}")
    @CsvSource("Propriete", "Vehicule")
    fun `extended classes`(className : String) {
        val member = Camion::class.allSuperclasses.find{it.simpleName == className}
        assertNotNull(member)
    }    


    val batman = Personne(nom = "Wayne", prenom = "Bruce")
    var batmobile = Camion(mod = "Bat Van", coul ="noire", places = 3)


    @BeforeEach
    fun initTest() {
        batmobile = Camion(mod = "Bat Van", coul ="noire", places = 3)
        batmobile.acheter(acheteur = batman)
    }

    @Test
    fun batvan_init() {
        assertFalse(batmobile.estEnMarche())
    }

    @Test
    fun batvan_demarrer_sans() {
        batmobile.demarrer()
        assertFalse(batmobile.estEnMarche())
    }
    
    @Test
    fun batvan_demarrer_avec() {
        batmobile.devientConducteur(batman)
        batmobile.demarrer()
        assertTrue(batmobile.estEnMarche())
    }

    @Test
    fun batvan_roule() {
        batmobile.devientConducteur(batman)
        batmobile.demarrer()
        assertEquals(75.3, batmobile.accelerer(acceleration = 75.3))
    }

    @Test
    fun batvan_roule2() {
        batmobile.devientConducteur(batman)
        batmobile.demarrer()
        batmobile.accelerer(acceleration = 75.3)
        batmobile.accelerer(acceleration = 12.5)
        assertEquals(75.3 + 12.5 - 12.4,  batmobile.decelerer(deceleration = 12.4))
    }

    @Test
    fun batvan_roule3() {
        batmobile.devientConducteur(batman)
        batmobile.demarrer()
        batmobile.accelerer(acceleration = 75.3)
        batmobile.arreter()
        assertEquals(0.0, batmobile.accelerer(acceleration = 72.5))
    }

    @Test
    fun batvan_roule4() {
        batmobile.devientConducteur(batman)
        batmobile.demarrer()
        batmobile.accelerer(acceleration = 42.0)
        assertEquals(90.0, batmobile.accelerer(acceleration = 75.3))
    }

    @Test
    fun batvan_roule5() {
        batmobile.devientConducteur(batman)
        batmobile.demarrer()
        batmobile.accelerer(acceleration = 75.3)
        assertEquals(75.3, batmobile.accelerer(acceleration = -10.0))
    }

    @Test
    fun batvan_roule6() {
        batmobile.devientConducteur(batman)
        batmobile.demarrer()
        batmobile.accelerer(acceleration = 75.3)
        assertEquals(75.3, batmobile.decelerer(deceleration = -10.0))
    }

    @Test
    fun batvan_roule7() {
        batmobile.devientConducteur(batman)
        batmobile.demarrer()
        batmobile.accelerer(acceleration = 75.3)
        batmobile.arreter()
        batmobile.demarrer()
        assertEquals(72.5, batmobile.accelerer(acceleration = 72.5))
    }

    @Test
    fun batvan_roule_sans() {
        batmobile.devientConducteur(batman)
        batmobile.demarrer()
        batmobile.accelerer(acceleration = 75.3)
        batmobile.plusDeConducteur()
        assertEquals(0.0, batmobile.accelerer(acceleration = 72.5))
    }

    @Test
    fun batvan_roule_charge() {    
        var batmobile00 = Voiture(mod = "Batmobile Tumbler", vitMax = 257.0, coul = "noire")
        var batmobile66 = Voiture(vitMax = 257.0, mod = "Batmobile 1966", coul = "noire")
        var batmobile89 = Voiture("Burton's Batmobile", "noire", 290.0)
        batmobile.charger(batmobile66)
        batmobile.charger(batmobile89)
        batmobile.charger(batmobile00)
        batmobile.devientConducteur(batman)
        batmobile.demarrer()
        assertEquals(75.3/2, batmobile.accelerer(acceleration = 75.3))
    }

    @Test
    fun batvan_roule_charge2() {
        var batmobile66 = Voiture(vitMax = 257.0, mod = "Batmobile 1966", coul = "noire")
        var batmobile89 = Voiture("Burton's Batmobile", "noire", 290.0)
        batmobile.charger(batmobile66)
        batmobile.charger(batmobile89)
        batmobile.devientConducteur(batman)
        batmobile.demarrer()
        batmobile.accelerer(acceleration = 75.3)
        batmobile.accelerer(acceleration = 12.5)
        assertEquals(75.3/2 + 12.5/2 - 12.4/3,  batmobile.decelerer(deceleration = 12.4))
    }

}