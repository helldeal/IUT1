import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

import org.junit.jupiter.api.Assertions.*

class TestAlpha {
    
    @ParameterizedTest(name = "{0} chiffre avec decalage {1} =? {2}")
    @MethodSource("getData")
    fun `chiffrements`(origin : String, deca : Int, chiffre : String) {
        assertEquals(chiffre, chiffrement(origin, deca))
    }

    companion object {
        @JvmStatic
        fun getData(): List<Arguments> {
            return listOf<Arguments>(
                    Arguments.of("ABCDEFGH", 0, "ABCDEFGH"),
                    Arguments.of("abcdefgh", 0, "ABCDEFGH"),
                    Arguments.of("ABCDEFGH", 26, "ABCDEFGH"),
                    Arguments.of("abcdefgh", 26, "ABCDEFGH"),
                    Arguments.of("abcdefgh", 1, "BCDEFGHI"),
                    Arguments.of("ABCDEFGH", 1, "BCDEFGHI"),
                    Arguments.of("ab@c d-ef/gh", 1, "BC@D E-FG/HI"),
                    Arguments.of("hgfedcba", 1, "IHGFEDCB"),
                    Arguments.of("abcdefgh", 3, "DEFGHIJK"),
                    Arguments.of("abcdefgh", 5, "FGHIJKLM"),
                    Arguments.of("abcdefgh", 7, "HIJKLMNO"),
            )
        }
    }
}