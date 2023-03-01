import but1.iut.r203.chenil.Chien
import but1.iut.r203.chenil.DateChenil
import but1.iut.r203.chenil.DateChenilStub
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import io.mockk.every
import io.mockk.mockk
import java.time.LocalDate

internal class      ChienTest {

    @Test
    fun ageMois1() {
        var ch1 = Chien("A", "B", DateChenilStub())
        ch1.setDateNaissance(2021, 2, 28)
        assertEquals(ch1.ageMois(),10)
    }
    @Test
    fun ageMois2() {
        var ch1 = Chien("A", "B", DateChenilStub())
        ch1.setDateNaissance(2021, 12, 31)
        assertEquals(ch1.ageMois(),0)
    }
    @Test
    fun ageMois3() {
        var ch1 = Chien("A", "B", DateChenilStub())
        ch1.setDateNaissance(2021, 12, 1)
        assertEquals(ch1.ageMois(),1)
    }
    @Test
    fun ageMoisMock() {
        var mockDate1= mockk<DateChenil>()
        every { mockDate1.getDateToday() } returns LocalDate.of(2022,2,28)
        var ch1= Chien("AAA","BBB", mockDate1)
        ch1.setDateNaissance(2021,2,15)
        var agech1=ch1.ageMois()
        assertEquals(12,agech1)
    }
}