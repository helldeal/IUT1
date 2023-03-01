import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

import org.junit.jupiter.api.Assertions.*

class TestCalcul {
    
   @ParameterizedTest(name = "estPremier{0}")
    @ValueSource(ints = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 102647, Int.MAX_VALUE])
    fun verifPremier(candidate: Int) {
        assertTrue(estPremier(candidate))
    }
    
    @ParameterizedTest(name = "nEstPasPremier{0}")
    @ValueSource(ints = [Int.MIN_VALUE, -10, 0, 1, 4, 6, 8, 9, 10, 12, 14, 15, 16, 102647032])
    fun verifPasPremier(candidate: Int) {
        assertFalse(estPremier(candidate))
    }

    //
    //102647032

}