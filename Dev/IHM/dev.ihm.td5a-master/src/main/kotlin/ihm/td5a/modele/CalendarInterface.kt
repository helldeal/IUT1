package ihm.td5a.modele

interface CalendarInterface {
    /**
     * @return le tableau de mois
     */
    fun giveAllMonths(): Array<String>

    /**
     * @return le numero de mois qui commence à 0
     */
    fun getMonth():Int

    /**
     * @return retourne l'année
     */
    fun getYear(): Int

    /**
     * @return le numéro de jour dans le mois, commence à 1
     */
    fun getDayNumber(): Int

    /**
     * @return le numéro de jour de la semaine, commence à 1
     */
    fun getDayOfWeek(): Int

    /**
     * @return retourne le jour de la semaine en français
     */
    fun getDay():String

    /**
     * change le mois du calendrier par la valeur i
     * @param i le numero de mois
     */
    fun moveMonth(i: Int)
    /**
     * pour changer le jour du mois du calendrier
     * @param i le nouveau jour du mois
     */
    fun moveDayOfMonth(i: Int)

}