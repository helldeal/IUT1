import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.Throws
import po2.td5.LivreException
import po2.td5.Edition
import org.junit.jupiter.api.function.ThrowingSupplier
import po2.td5.Livre
import po2.td5.Livres
import po2.td5.Auteur
import org.junit.jupiter.api.BeforeEach
import java.util.List

internal class LivreTest {
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
    var e1l3: Edition? = null
    var e2l3: Edition? = null
    var e3l3: Edition? = null

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
        e1l3 = Edition("9782841726912", "L'Atalante", 2014)
        e2l3 = Edition("9782367930534", "L'Atalante", 2012)
        e3l3 = Edition("9782266226172", "Pocket", 2011)
        l3!!.ajouteEdition(e1l3!!)
        l3!!.ajouteEdition(e2l3!!)
        l3!!.ajouteEdition(e3l3!!)
        l4 = Livre("Procrastination", pratchett!!)
        l5 = Livre("Les ch'tits hommes libres", pratchett!!)
        l6 = Livre("La longue terre", pratchett!!)
        val simmons = Auteur("Simmons", "Dan")
        l7 = Livre("Hyperion", simmons)
        l8 = Livre("L'echiquier du mal", simmons)
        l9 = Livre("Gagner la guerre", Auteur("Jaworski", "Jean-Philippe"))
    }

    @Test
    fun editionsTriParAn() {
        Assertions.assertIterableEquals(l3!!.editionsTriParAn(), List.of(e3l3, e2l3, e1l3))
    }

    @Test
    fun compareTo() {
        var un = l3
        for (deux in List.of(l1, l2, l4, l5, l6)) {
            Assertions.assertTrue(un!!.compareTo(deux!!) > 0)
            Assertions.assertTrue(deux!!.compareTo(un) < 0)
            Assertions.assertTrue(un.compareTo(un) == 0)
            un = deux
        }
    }
}