package but1.iut.r203.chenil

import java.time.LocalDate

class DateChenilSystem : DateChenil {
    override fun getDateToday(): LocalDate {
        return LocalDate.now()
    }
}