import org.junit.jupiter.api.Test

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.api.Assertions.*

import kotlin.reflect.full.allSuperclasses
import kotlin.reflect.full.memberProperties
import kotlin.reflect.KVisibility

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

    @ParameterizedTest(name = "attribute {0} exists and is private ")
    @CsvSource("nom", "prenom")
    fun `private attributes`(attributeName : String) {
        val member = Personne::class.memberProperties.find{it.name == attributeName}
        assertNotNull(member)
        assertEquals(KVisibility.PRIVATE, member!!.visibility)
    }

    @ParameterizedTest(name = "extended class or interface {0}")
    @CsvSource("Proprietaire")
    fun `extended classes`(className : String) {
        val member = Personne::class.allSuperclasses.find{it.simpleName == className}
        assertNotNull(member)
    } 
}