package iut.math
/**
 * Fabrique un rationnel à partir de deux entiers passés en paramètre ;
 * @param numerator le numérateur
 * @param denominator le dénominateur
 * Par convention, si le denominateur vaut 0, alors on le positionne à 1
 */
class Rational (numerator : Int, denominator :Int=1) {
    private val numerator : Int
    private val denominator : Int

    init {
        this.numerator = numerator
        this.denominator  = if (denominator == 0) 1 else denominator
    }

    override fun toString(): String {
        return "$numerator/$denominator"
    }

    operator fun plus(i : Rational):Rational{
        var hg=this.denominator*i.numerator
        var hd=i.denominator*this.numerator
        var bas = this.denominator*i.denominator
        var res = hd+hg
        var pgcd =pgcd(res,bas)
        return Rational(res/pgcd,bas/pgcd)
    }
    operator fun plus(i : Int):Rational{
        return plus(Rational(i,1))
    }

    fun opposite() :Rational{
        return Rational(-numerator,denominator)
    }
    operator fun minus(i : Rational):Rational{
        var y=i.opposite()
        return this+y
    }

    fun reduce() :Rational{
        var pgcd =pgcd(numerator,denominator)
        return Rational(numerator/pgcd,denominator/pgcd)
    }

    override fun equals(i : Any?):Boolean{
        if (i is Rational) {
            var y = Rational(i.numerator, i.denominator).reduce()
            var z = Rational(numerator, denominator).reduce()
            return y.numerator==z.numerator && z.denominator==y.denominator
        }
        return false
    }

    operator fun compareTo(i: Rational):Int{
        var hg=this.denominator*i.numerator
        var hd=i.denominator*this.numerator
        return hd.compareTo(hg)
    }

    operator fun times(i : Rational):Rational{
        var bas = this.denominator*i.denominator
        var res =this.numerator*i.numerator
        var pgcd =pgcd(res,bas)
        return Rational(res/pgcd,bas/pgcd)
    }

    fun inverse() : Rational{
        return Rational(denominator,numerator)
    }

    operator fun div(i : Rational):Rational{
        var y=i.inverse()
        return this*y
    }
}