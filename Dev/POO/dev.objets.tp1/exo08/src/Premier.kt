/*
La fonction estPremier doit indiquer par un booléen si un nombre est premier
ou pas

@author init.dev (L.Jezequel)

@ n un nombre entier
@return un booléen indiquant si n est premier ou pas
*/
fun estPremier(n : Int) : Boolean {
    var res : MutableList<Int> = mutableListOf<Int>()
    var ok: Boolean
    if (n < 2){
        return false
    }
    for (i in 3..n step 2) {
        ok = true
        for (j in res){
            if (j.toDouble() > 0.5 * i.toDouble()){
                break
            }
            if (i.mod(j) == 0) {
                ok = false
                break
            }
        }
        if (ok){
            res.add(i)
        }
    }
    return n in res
}
