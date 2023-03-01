package ihm.td5a.modele

import java.util.*

val tabMonth = arrayOf(
    "janvier",
    "février",
    "mars",
    "avril",
    "mai",
    "juin",
    "juillet",
    "août",
    "septembre",
    "octobre",
    "novembre",
    "décembre"
)

val tabDay= arrayOf("dimanche", "lundi", "mardi", "mercredi", "jeudi", "vendredi", "samedi")

class Calendrier: CalendarInterface {

    private var calendar: Calendar

    /**
     * instanciation du Calendar
     */
    init {
        this.calendar = Calendar.getInstance()
    }


    /**
     * @return le tableau de mois
     */
    override fun giveAllMonths(): Array<String> {
        return tabMonth
    }

    /**
     * @return le numero de mois qui commence à 0
     */
    override fun getMonth():Int{
        return calendar.get(Calendar.MONTH)
    }

    /**
     * @return retourne l'année
     */
    override fun getYear(): Int {
        return calendar.get(Calendar.YEAR)
    }

    /**
     * @return le numéro de jour dans le mois, commence à 1
     */
    override fun getDayNumber(): Int{
        return calendar.get(Calendar.DAY_OF_MONTH)
    }

    /**
     * @return le numéro de jour de la semaine, commence à 1
     */
    override fun getDayOfWeek(): Int{
        return calendar.get(Calendar.DAY_OF_WEEK)
    }


    /**
     * @return retourne le jour de la semaine en français
     */
    override fun getDay():String{
        return tabDay[this.getDayOfWeek()-1]
    }

    /**
     * change le mois du calendrier par la valeur i
     * @param i le numero de mois
     */
    override fun moveMonth(i: Int){
        this.calendar.set(Calendar.MONTH,i)
    }

    /**
     * pour changer le jour du mois du calendrier
     * @param i le nouveau jour du mois
     */
    override fun moveDayOfMonth(i: Int){
        this.calendar.set(Calendar.DAY_OF_MONTH,i)
    }
}
