import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Assertions.*

class TestParking {

    val batman = Personne(nom = "Wayne", prenom = "Bruce")
    val robin = Personne(nom = "Dick", prenom = "Grayson")
    var batmobile = Voiture(mod = "Batmobile Tumbler", vitMax = 257.0, coul = "noire")
    var batmobile66 = Voiture(vitMax = 257.0, mod = "Batmobile 1966", coul = "noire")
    var batmobile89 = Voiture("Burton's Batmobile", "noire", 290.0)
    var parking = Parking(places = 2)

    @BeforeEach
    fun initTest() {
        batmobile = Voiture(mod = "Batmobile Tumbler", vitMax = 257.0, coul = "noire")
        batmobile.acheter(acheteur = batman)
        batmobile66 = Voiture(vitMax = 257.0, mod = "Batmobile 1966", coul = "noire")
        batmobile66.acheter(batman)
        batmobile89 = Voiture("Burton's Batmobile", "noire", 290.0)
        batmobile89.acheter(robin)
        parking = Parking(places = 2)
    }
    
    @Test
    fun initparking() {
        assertAll(
            { assertEquals(2, parking.nombreDePlacesLibres()) },
            { assertEquals(2, parking.nombreDePlacesTotales()) },
            { assertTrue(parking.placeLibre(numeroPlace = 0)) },
            { assertTrue(parking.placeLibre(numeroPlace = 1)) },
            { assertFalse(parking.placeLibre(numeroPlace = 2)) },
            { assertFalse(parking.placeLibre(numeroPlace = -10)) },
            { assertFalse(parking.placeLibre(numeroPlace = 10)) }
        )
    }

    @Test
    fun parking1voiture() {
        assertTrue(parking.stationner(voitureStationnee = batmobile, numeroPlace = 1))
        assertAll(
            { assertEquals(1, parking.nombreDePlacesLibres()) },
            { assertEquals(2, parking.nombreDePlacesTotales()) },
            { assertTrue(parking.placeLibre(numeroPlace = 0)) },
            { assertFalse(parking.placeLibre(numeroPlace = 1)) }
        )
    }

   @Test
    fun parking1voitureKO() {
        assertFalse(parking.stationner(voitureStationnee = batmobile, numeroPlace = 10))
        assertAll(
            { assertEquals(2, parking.nombreDePlacesLibres()) },
            { assertEquals(2, parking.nombreDePlacesTotales()) },
            { assertTrue(parking.placeLibre(numeroPlace = 0)) },
            { assertTrue(parking.placeLibre(numeroPlace = 1)) }
        )
    }


   @Test
    fun parking1voitureKO2() {
        assertFalse(parking.stationner(voitureStationnee = batmobile, numeroPlace = -10))
        assertAll(
            { assertEquals(2, parking.nombreDePlacesLibres()) },
            { assertEquals(2, parking.nombreDePlacesTotales()) },
            { assertTrue(parking.placeLibre(numeroPlace = 0)) },
            { assertTrue(parking.placeLibre(numeroPlace = 1)) }
        )
    }



    @Test
    fun parking1voiture2foisMemePlace() {
        assertTrue(parking.stationner(numeroPlace = 1, voitureStationnee = batmobile))
        assertFalse(parking.stationner(voitureStationnee = batmobile, numeroPlace = 1))
        assertAll(
            { assertEquals(1, parking.nombreDePlacesLibres()) },
            { assertEquals(2, parking.nombreDePlacesTotales()) },
            { assertTrue(parking.placeLibre(numeroPlace = 0)) },
            { assertFalse(parking.placeLibre(numeroPlace = 1)) }
        )
    }

    @Test
    fun parking1voiture2fois2Places() {
        assertTrue(parking.stationner(numeroPlace = 1, voitureStationnee = batmobile))
        assertFalse(parking.stationner(numeroPlace = 0, voitureStationnee = batmobile))
        assertAll(
            { assertEquals(1, parking.nombreDePlacesLibres()) },
            { assertEquals(2, parking.nombreDePlacesTotales()) },
            { assertTrue(parking.placeLibre(numeroPlace = 0)) },
            { assertFalse(parking.placeLibre(numeroPlace = 1)) }
        )
    }

    @Test
    fun parking2voituresMemePlace() {
        assertTrue(parking.stationner(numeroPlace = 1, voitureStationnee = batmobile))
        assertFalse(parking.stationner(numeroPlace = 1, voitureStationnee = batmobile89))
        assertAll(
            { assertEquals(1, parking.nombreDePlacesLibres()) },
            { assertEquals(2, parking.nombreDePlacesTotales()) },
            { assertTrue(parking.placeLibre(numeroPlace = 0)) },
            { assertFalse(parking.placeLibre(numeroPlace = 1)) }
        )
    }

    @Test
    fun parking2voitures2places() {
        assertTrue(parking.stationner(numeroPlace = 1, voitureStationnee = batmobile))
        assertTrue(parking.stationner(numeroPlace = 0, voitureStationnee = batmobile89))
        assertAll(
            { assertEquals(0, parking.nombreDePlacesLibres()) },
            { assertEquals(2, parking.nombreDePlacesTotales()) },
            { assertFalse(parking.placeLibre(numeroPlace = 0)) },
            { assertFalse(parking.placeLibre(numeroPlace = 1)) }
        )
    }

}