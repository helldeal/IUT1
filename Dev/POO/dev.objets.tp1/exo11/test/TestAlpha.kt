import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

import org.junit.jupiter.api.Assertions.*

class TestAlpha {
    
    @ParameterizedTest(name = "{0} trié alphabetiquement =? {1}")
    @MethodSource("getData")
    fun `tris alphabétiques`(src : Array<String>, res : Array<String>) {
        alphabetique(src)
        assertArrayEquals(res, src)
    }

    companion object {
        @JvmStatic
        fun getData(): List<Arguments> {
            return listOf<Arguments>(
                    Arguments.of(arrayOf(""),
                                 arrayOf("")),
                    Arguments.of(arrayOf("42"), 
                                 arrayOf("42")),
                    Arguments.of(arrayOf("Cerf", "Requin"),
                                 arrayOf("Cerf", "Requin")),
                    Arguments.of(arrayOf("Requin", "Cerf"),
                                 arrayOf("Cerf", "Requin")),
                    Arguments.of(arrayOf("Requin", "", "Cerf"),
                                 arrayOf("", "Cerf", "Requin")),
                    Arguments.of(arrayOf("Chinchilla", "Cygne", "Girafe", "Iguane", "Mollusque", "Morue", "Papillon", "Pie",  "Voler"),
                                 arrayOf("Chinchilla", "Cygne", "Girafe", "Iguane", "Mollusque", "Morue", "Papillon", "Pie",  "Voler")),
                    Arguments.of(arrayOf("Papillon", "Iguane", "Chinchilla", "Girafe", "Morue", "Cygne", "Voler", "Pie", "Mollusque"),
                                 arrayOf("Chinchilla", "Cygne", "Girafe", "Iguane", "Mollusque", "Morue", "Papillon", "Pie",  "Voler")),
                    Arguments.of(arrayOf("Chinchilla", "Cygne", "Girafe", "Iguane", "Iguane", "Mollusque", "Morue", "Papillon", "Pie", "Pie", "Voler"),
                                 arrayOf("Chinchilla", "Cygne", "Girafe", "Iguane", "Iguane", "Mollusque", "Morue", "Papillon", "Pie", "Pie", "Voler")),
                    Arguments.of(arrayOf("Papillon", "Iguane", "Chinchilla", "Girafe", "Morue", "Pie", "Iguane", "Cygne", "Voler", "Pie", "Mollusque"),
                                 arrayOf("Chinchilla", "Cygne", "Girafe", "Iguane", "Iguane", "Mollusque", "Morue", "Papillon", "Pie", "Pie", "Voler"))
            )
        }
    }
}