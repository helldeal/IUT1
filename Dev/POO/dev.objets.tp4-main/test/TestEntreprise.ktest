import org.junit.jupiter.api.Test

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.api.Assertions.*

import kotlin.reflect.full.allSuperclasses
import kotlin.reflect.full.memberProperties
import kotlin.reflect.KVisibility

class TestEntreprise {

    val batman = Personne(nom = "Wayne", prenom = "Bruce")

    @ParameterizedTest(name = "attribute {0} exists and is private ")
    @CsvSource("raisonSociale", "forme", "gerant")
    fun `private attributes`(attributeName : String) {
        val member = Entreprise::class.memberProperties.find{it.name == attributeName}
        assertNotNull(member)
        assertEquals(KVisibility.PRIVATE, member!!.visibility)
    }

    @ParameterizedTest(name = "extended class or interface {0}")
    @CsvSource("Proprietaire", "Propriete")
    fun `extended classes`(className : String) {
        val member = Entreprise::class.allSuperclasses.find{it.simpleName == className}
        assertNotNull(member)
    } 

    @Test
    fun `est une scop`() {
        val ent = Entreprise(raisonSociale = "Wayne's entreprise", forme = "SCOP", gerant = batman)
        assertEquals("Wayne's entreprise SCOP", ent.donneNomComplet())
        assertEquals("SCOP", ent.donneForme())
        assertEquals(batman, ent.donneGerantActuel())
    }

    @Test
    fun `est une scop 2`() {
        val ent = Entreprise(raisonSociale = "Wayne's entreprise", gerant = batman)
        assertEquals("Wayne's entreprise SCOP", ent.donneNomComplet())
        assertEquals("SCOP", ent.donneForme())
        assertEquals(batman, ent.donneGerantActuel())
    }

    @Test
    fun `est une SA`() {
        val ent = Entreprise(raisonSociale = "Wayne's entreprise", forme = "SA", gerant = batman)
        assertEquals("Wayne's entreprise SA", ent.donneNomComplet())
        assertEquals("SA", ent.donneForme())
        assertEquals(batman, ent.donneGerantActuel())
    }

    @Test
    fun `est une EURL`() {
        val ent = Entreprise(raisonSociale = "Wayne's entreprise", forme = "EURL", gerant = batman)
        assertEquals("EURL", ent.donneForme())
    }

    @Test
    fun `est une XX-SCOP`() {
        val ent = Entreprise(raisonSociale = "Wayne's entreprise", forme = "XXX", gerant = batman)
        assertEquals("SCOP", ent.donneForme())
    }

    @Test
    fun `est vendue`() {
        val ent = Entreprise(raisonSociale = "Wayne's entreprise", forme = "SA", gerant = batman)
        val ironman = Personne(prenom = "Tony", nom = "Stark")
        ent.acheter(acheteur = ironman)
        assertEquals(ironman, ent.donneGerantActuel())
    }

    @Test
    fun `est vendue a une entreprise`() {
        val ent = Entreprise(raisonSociale = "Wayne's entreprise", forme = "SA", gerant = batman)
        val ironman = Personne(prenom = "Tony", nom = "Stark")
        val acheteuse = Entreprise(raisonSociale = "Stark industrie", gerant = ironman)
        ent.acheter(acheteur = acheteuse)
        assertEquals(acheteuse, ent.donneGerantActuel())
    }
}