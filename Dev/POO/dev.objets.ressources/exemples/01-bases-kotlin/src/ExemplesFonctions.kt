
fun log(msg : String = "hello", niv : Int = 1) {
  println("*** LOG($niv):$msg ***")
}

fun mult(a : Int, b : Double, c : Double) : Double {
  var resultat = a * b * c
  return resultat
}

fun mult2(a : Int, b : Double, c : Double) = a * b * c

fun main() {
  log("azerty", 3)
  log("qwerty", 1)
  log("dvorak")
  // echoue : log(5)
  log()
  log(niv = 7, msg = "qwertz")
  log(msg = "colemak")
  log(niv = 4)

  val x = mult(2, 3.0, 1.0)
  println(x)  //  6.0
  val y = mult(2, x, x)
  println(y)  // 72.0

  val x2 = mult2(2, 3.0, 1.0)
  println(x2)  //  6.0
  val y2 = mult2(2, x2, x2)
  println(y2)  // 72.0
}