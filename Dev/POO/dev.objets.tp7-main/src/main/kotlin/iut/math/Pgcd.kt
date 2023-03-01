package iut.math

/**
 * renvoie le "Plus Grand Commun Diviseur" de deux entiers
 * @param aa un entier
 * @param bb un entier
 * @return le pgcd de aa et bb
 */
fun pgcd(aa : Int, bb : Int) : Int {
    var a=aa
    var b=bb
    var r =a
    while(r!=0){
        r=a%b
        a=b
        b=r
    }
    return a
}