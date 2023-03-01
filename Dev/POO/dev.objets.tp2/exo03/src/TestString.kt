fun main() {
    val anti = "anticonstitutionnellement"
    println(anti)
    println(anti.length)
    println("${anti.get(2)},${anti.get(3)},${anti.get(19)}")
    println(anti.subSequence(1, 4))
    println(anti.indexOf('n'))
    println(anti.indexOfLast { it=='n' })
    println(anti.indexOf('y'))
    val cc = "bonjour"
    println(cc+" tout"+" le monde")
    var conc25 = ""
    for (i in 0 until 25){
        conc25+=cc.random()
    }
    println(conc25)
    var capcc = cc.uppercase()
    println(capcc)
    var mincapcc = capcc.lowercase()
    println(mincapcc)
    println(mincapcc.equals(cc))
    println(mincapcc.compareTo(cc))
}
