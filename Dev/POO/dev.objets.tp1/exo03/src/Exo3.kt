fun main() {
    fun main() {
        var alpha : Double
        var beta : Int = 42
        var delta : Double = 42.0
        beta--
        println("delta : $delta")
        alpha = delta
        delta += 3
        println("delta : $delta, alpha : $alpha")
        val test : Boolean = alpha == delta
        println("test : $test")
        alpha = dec2(delta, beta)
        println("delta : $delta, alpha : $alpha")
    }
    
    fun dec2(epsilon : Double, gamma: Int) : Double{
        return epsilon - gamma.toDouble() - 2
    }
    
}
