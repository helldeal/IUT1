package but1.iut.r203.chenil

import java.time.LocalDate

class DateChenilStub: DateChenil  {
    override fun getDateToday(): LocalDate {
        return LocalDate.of(2022,1,1)
    }
}