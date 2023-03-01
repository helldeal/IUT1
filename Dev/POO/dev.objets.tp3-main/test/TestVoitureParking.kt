import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Assertions.*

class TestVoitureParking {

    val batman = Personne(nom = "Wayne", prenom = "Bruce")
    var batmobile = Voiture(mod = "Batmobile Tumbler", vitMax = 257.0, coul = "noire")
    var parking = Parking(places = 3)

    @BeforeEach
    fun initTest() {
        batmobile = Voiture(mod = "Batmobile Tumbler", vitMax = 257.0, coul = "noire")
        batmobile.acheter(acheteur = batman)
        parking = Parking(places = 3)
    }
    
    @Test
    fun batmobile_pasgarer1() {
        batmobile.demarrer()
        batmobile.accelerer(acceleration = 75.3)
        assertFalse(batmobile.estGaree())
    }

    @Test
    fun batmobile_garer1() {
        batmobile.demarrer()
        batmobile.accelerer(acceleration = 75.3)
        batmobile.stationner(nouveauParking = parking)
        assertAll(
            { assertTrue(batmobile.estGaree()) },
            { assertFalse(batmobile.estEnMarche()) }
        )
    }

    @Test
    fun batmobile_garer2() {
        batmobile.demarrer()
        batmobile.accelerer(acceleration = 75.3)
        batmobile.stationner(nouveauParking = parking)
        batmobile.quitterStationnement()
        assertAll(
            { assertFalse(batmobile.estGaree()) },
            { assertTrue(batmobile.estEnMarche()) }
        )
    }

}