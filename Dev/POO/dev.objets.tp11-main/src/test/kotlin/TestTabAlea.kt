import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class TestTabAlea {

    @Test
    fun testTabAlea10() {
        val taille = 10
        var tableau = tableauAleatoireDistinct(taille)
        val trie = tableau.sortedArray()
        val autre = tableauAleatoireDistinct(taille)
        assertAll(
            { Assertions.assertEquals(1, tableau.minOrNull()) },
            { Assertions.assertEquals(taille, tableau.maxOrNull()) },
            { Assertions.assertNotEquals(trie, tableau) },
            { Assertions.assertNotEquals(autre, tableau) },
            {
                for (v in tableau)
                    Assertions.assertEquals(1, tableau.count({ it == v }))
            }
        )
    }

    @Test
    fun testTabAlea1000() {
        val taille = 1000
        var tableau = tableauAleatoireDistinct(taille)
        val trie = tableau.sortedArray()
        val autre = tableauAleatoireDistinct(taille)
        assertAll(
            { Assertions.assertEquals(1, tableau.minOrNull()) },
            { Assertions.assertEquals(taille, tableau.maxOrNull()) },
            { Assertions.assertNotEquals(trie, tableau) },
            { Assertions.assertNotEquals(autre, tableau) },
            {
                for (v in tableau)
                    Assertions.assertEquals(1, tableau.count({ it == v }))
            }
        )
    }

    @Test
    fun testTabAlea100000() {
        val taille = 100000
        var tableau = tableauAleatoireDistinct(taille)
        val trie = tableau.sortedArray()
        assertAll(
            { Assertions.assertEquals(1, tableau.minOrNull()) },
            { Assertions.assertEquals(taille, tableau.maxOrNull()) },
            { Assertions.assertNotEquals(trie, tableau) },
            {
                for (v in tableau)
                    Assertions.assertEquals(1, tableau.count({ it == v }))
            }
        )
    }


}