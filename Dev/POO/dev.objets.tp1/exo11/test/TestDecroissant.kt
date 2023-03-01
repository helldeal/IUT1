import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

import org.junit.jupiter.api.Assertions.*

class TestDecroissant {
    
    @ParameterizedTest(name = "{0} trié décroissant =? {1}")
    @MethodSource("getData")
    fun `tris décroissants`(src : Array<Int>, res : Array<Int>) {
        decroissant(src)
        assertArrayEquals(res, src)
    }

    companion object {
        @JvmStatic
        fun getData(): List<Arguments> {
            return listOf<Arguments>(
                    Arguments.of(arrayOf(42),
                                 arrayOf(42)),
                    Arguments.of(arrayOf(4, 2),
                                 arrayOf(4, 2)),
                    Arguments.of(arrayOf(2, 4),
                                 arrayOf(4, 2)),
                    Arguments.of(arrayOf(8, 7, 6, 5, 4, 3, 2, 1),
                                 arrayOf(8, 7, 6, 5, 4, 3, 2, 1)),
                    Arguments.of(arrayOf(6, 5, 3, 1, 8, 7, 2, 4),
                                 arrayOf(8, 7, 6, 5, 4, 3, 2, 1)),
                    Arguments.of(arrayOf(8, 6, 5, 5, 4, 4, 3, 2, 2, 2, 1), //doublons
                                 arrayOf(8, 6, 5, 5, 4, 4, 3, 2, 2, 2, 1)),
                    Arguments.of(arrayOf(2, 2, 8, 6, 4, 5, 1, 5, 4, 3, 2), // doublons
                                 arrayOf(8, 6, 5, 5, 4, 4, 3, 2, 2, 2, 1))
             )
        }
    }
}