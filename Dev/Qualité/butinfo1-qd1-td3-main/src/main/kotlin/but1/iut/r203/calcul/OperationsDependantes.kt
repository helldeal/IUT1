package but1.iut.r203.calcul

/**
 * @author mottu-jm
 */
class OperationsDependantes {

    /**
     * Diviser deux entiers
     * @param dividende : entier naturel
     * @param diviseur : entier naturel
     * @return quotient : flottant
     * @throws ArithmeticException : out of Int bounds
     */
    fun diviserNaturelConsole(): Float {
        var dividende = Integer.valueOf(readLine())
        var diviseur = Integer.valueOf(readLine())
        if (diviseur == 0) {
            throw ArithmeticException("Trying to do a division by zero")
        }
        if (dividende < 0 || diviseur < 0) {
            throw ArithmeticException("Trying to do a division of non natural number(s)")
        }
        return (dividende.toFloat() / diviseur)
    }

    /**
     * Calcul de la factorielle d’un entier positif ou nul entré dans la console
     * @return le résultat n! = 1*2*...*n et 0! = 1
     * @throws IllegalArgumentException quand on essaie une factorielle d'un nombre négatif
     * @throws ArithmeticException quand le calcul ne peut pas être fait
     */
    fun factorielleConsole(): Int {
        var paramConsole = Integer.valueOf(readLine())
        var retourFact = 1
        if (paramConsole < 0) throw IllegalArgumentException("Parameter is too small")
        if (paramConsole > 12) throw ArithmeticException("Output would overreach the size of an int")
        for (i in 2..paramConsole)
            retourFact*=i
        return retourFact
    }
}