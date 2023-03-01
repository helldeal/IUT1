import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.Throws
import po2.td5.LivreException
import po2.td5.Edition
import po2.td5.Livre
import po2.td5.Livres
import po2.td5.Auteur
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.function.Executable
import java.util.List

internal class LivresTest {
    var l1: Livre? = null
    var l2: Livre? = null
    var l3: Livre? = null
    var l4: Livre? = null
    var l5: Livre? = null
    var l6: Livre? = null
    var l7: Livre? = null
    var l8: Livre? = null
    var l9: Livre? = null
    var l: Livres? = null
    var pratchett: Auteur? = null

    @BeforeEach
    @Throws(LivreException::class)
    fun setUp() {
        l = Livres()
        l1 = Livre(
            "L'Appel de Cthulhu", Auteur(
                "Lovecraft", "Howard Phillips"
            )
        )
        val e1l1 = Edition("9791028110468", "Bragelonne", 2020)
        l1!!.ajouteEdition(e1l1)
        l2 = Livre(
            "Les lames du Cardinal",
            Auteur("Pevel", "Pierre")
        )
        val e1l2 = Edition("9782070448531", "Gallimard", 2013)
        l2!!.ajouteEdition(e1l2)
        pratchett = Auteur("Pratchett", "Terry")
        l3 = Livre("Mortimer", pratchett!!)
        val e1l3 = Edition("9782841726912", "L'Atalante", 2014)
        val e2l3 = Edition("9782367930534", "L'Atalante", 2012)
        val e3l3 = Edition("9782266226172", "Pocket", 2011)
        l3!!.ajouteEdition(e1l3)
        l3!!.ajouteEdition(e2l3)
        l3!!.ajouteEdition(e3l3)
        l4 = Livre("Procrastination", pratchett!!)
        l5 = Livre("Les ch'tits hommes libres", pratchett!!)
        l6 = Livre("La longue terre", pratchett!!)
        val simmons = Auteur("Simmons", "Dan")
        l7 = Livre("Hyperion", simmons)
        l8 = Livre("L'echiquier du mal", simmons)
        l9 = Livre("Gagner la guerre", Auteur("Jaworski", "Jean-Philippe"))
    }

    @Test
    @Throws(LivreException::class)
    fun ajoute() {
        l!!.ajoute(l1!!)
        l!!.ajoute(l2!!)
        l!!.ajoute(l3!!)
        Assertions.assertAll(
            Executable { Assertions.assertEquals(5, l!!.nbEditions()) },
            Executable { Assertions.assertEquals(3, l!!.nbLivres()) },
            Executable { Assertions.assertIterableEquals(l!!.livres(), List.of(l1, l2, l3)) }
        )
    }

    @Test
    @Throws(LivreException::class)
    fun ajoute2() {
        l!!.ajoute(l1!!)
        Assertions.assertThrows(LivreException::class.java) { l!!.ajoute(l1!!) }
    }

    @Test
    @Throws(LivreException::class)
    fun ajoute3() {
        l!!.ajoute(l1!!)
        Assertions.assertThrows(LivreException::class.java) { l!!.ajoute(l1!!) }
    }

    @Test
    @Throws(LivreException::class)
    fun nbLivres() {
        Assertions.assertEquals(0, l!!.nbLivres())
        l!!.ajoute(l1!!)
        Assertions.assertEquals(1, l!!.nbLivres())
        l!!.ajoute(l2!!)
        Assertions.assertEquals(2, l!!.nbLivres())
        l!!.ajoute(l3!!)
        Assertions.assertEquals(3, l!!.nbLivres())
    }

    @Test
    @Throws(LivreException::class)
    fun efface() {
        l!!.ajoute(l2!!)
        Assertions.assertThrows(LivreException::class.java) { l!!.efface(l1!!) }
    }

    @Test
    @Throws(LivreException::class)
    fun efface2() {
        l!!.ajoute(l1!!)
        l!!.ajoute(l2!!)
        l!!.ajoute(l3!!)
        l!!.efface(l2!!)
        Assertions.assertAll(
            Executable { Assertions.assertEquals(2, l!!.nbLivres()) },
            Executable { Assertions.assertIterableEquals(l!!.livres(), List.of(l1, l3)) }
        )
    }

    @Test
    @Throws(LivreException::class)
    fun livresParAuteur() {
        for (ll in List.of(l1, l2, l3, l4, l5, l6, l7, l8, l9)) {
            l!!.ajoute(ll!!)
        }
        assertEquals(l?.livresParAuteur(pratchett!!)?.livres(), List.of(l3, l4, l5, l6))
    }
}