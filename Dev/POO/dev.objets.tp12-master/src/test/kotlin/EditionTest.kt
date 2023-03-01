import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.Throws
import po2.td5.LivreException
import po2.td5.Edition

internal class EditionTest {
    @Test
    @Throws(LivreException::class)
    fun isbn13_ok() {
        Assertions.assertDoesNotThrow<Edition> { Edition("9782841726912", "L'Atalante", 2014) }
        Assertions.assertDoesNotThrow<Edition> { Edition("9782367930534", "L'Atalante", 2012) }
        Assertions.assertDoesNotThrow<Edition> { Edition("9780716703440", "Pocket", 2011) }
    }

    @Test
    @Throws(LivreException::class)
    fun isbn_ko() {
        Assertions.assertThrows(LivreException::class.java) { Edition("782841726913", "L'Atalante", 2014) }
        Assertions.assertThrows(LivreException::class.java) { Edition("978236793053", "L'Atalante", 2012) }
        Assertions.assertThrows(LivreException::class.java) { Edition("978E266226171", "Pocket", 2011) }
    }

    @Test
    @Throws(LivreException::class)
    fun isbn13_ko() {
        Assertions.assertThrows(LivreException::class.java) { Edition("9782841726913", "L'Atalante", 2014) }
        Assertions.assertThrows(LivreException::class.java) { Edition("9782367930532", "L'Atalante", 2012) }
        Assertions.assertThrows(LivreException::class.java) { Edition("9782266226171", "Pocket", 2011) }
    }

    @Test
    @Throws(LivreException::class)
    fun isbn1O_ok() {
        Assertions.assertDoesNotThrow<Edition> { Edition("0786703873", "L'Atalante", 2014) }
        Assertions.assertDoesNotThrow<Edition> { Edition("0786709642", "L'Atalante", 2012) }
        Assertions.assertDoesNotThrow<Edition> { Edition("950400072X", "Pocket", 2011) }
    }

    @Test
    @Throws(LivreException::class)
    fun isbn10_ko() {
        Assertions.assertThrows(LivreException::class.java) { Edition("0786709645", "L'Atalante", 2014) }
        Assertions.assertThrows(LivreException::class.java) { Edition("07867X9644", "L'Atalante", 2012) }
        Assertions.assertThrows(LivreException::class.java) { Edition("950400071X", "Pocket", 2011) }
    }
}