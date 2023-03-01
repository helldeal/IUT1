import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class CalculKtTest {

    @Test
    fun sum() {
        assertEquals(40, sum(40,1))
    }

    @Test
    fun product() {
        assertEquals(42, product(21, 2))
    }

}