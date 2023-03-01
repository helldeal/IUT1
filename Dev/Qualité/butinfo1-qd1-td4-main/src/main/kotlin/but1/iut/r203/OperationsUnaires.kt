package but1.iut.r203

class OperationsUnaires {

    /**
     * Calcul de la factorielle d’un entier n positif ou nul
     * @param int n un nombre dont on veut calculer la factorielle
     * @return le résultat n! = 1*2*...*n et 0! = 1
     * @throws IllegalArgumentException quand on essaie une factorielle d'un nombre négatif
     * @throws ArithmeticException : out of Int bounds
     */
    fun factorielle(n: Int): Int {
        if (n < 0) throw IllegalArgumentException("Parameter is too small")
        if (n > 12) throw ArithmeticException("Output would overreach the size of an int")
        return if (n == 0) {
            1
        } else {
            (n - 1) * factorielle(n - 1)
        }
    }
}