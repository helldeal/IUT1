import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class TestPersonne {
    
    @Test
    fun batman() {
        val batman = Personne(nom = "Wayne", prenom = "Bruce")
        assertEquals("Bruce WAYNE", batman.donneNomComplet())
    }

    @Test
    fun ironman() {
        val ironman = Personne(prenom = "Tony", nom = "Stark")
        assertEquals("Tony STARK", ironman.donneNomComplet())
    }
}