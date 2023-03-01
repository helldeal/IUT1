fun main() {

  // if... else...

  // Survenue d'une nouvelle abs
  var cptAbs : Int = 3
  var justifiee : Boolean = false

  if (!justifiee) {
    println("Absence comptabilisée")
    cptAbs+= 1
  } 

  if (justifiee) 
    println("rien à faire")

  if (cptAbs >= 5)
    println("Echec ($cptAbs abs)")
  else if (cptAbs == 4) {
    println("Alerte rouge ($cptAbs abs)")
    println("* alerter tuteur *")
  }
  else if (cptAbs in 1..3)
    println("Attention ($cptAbs abs)")
  else
    println("Pas d'absence")

  // when...

  when {
    cptAbs >= 5 -> println("Echec ($cptAbs abs)")
    cptAbs == 4 -> {
      println("Alerte rouge ($cptAbs abs)")
      println("* alerter tuteur *")
    }
    cptAbs in 1..3  -> println("Attention ($cptAbs abs)")
    else -> println("Pas d'absence")
  }

  when (cptAbs) {
    in 5.. Int.MAX_VALUE -> println("Echec ($cptAbs abs)")
    4 -> { 
      println("Alerte rouge ($cptAbs abs)")
      println("* alerter tuteur *")
    }
    in 1..3 -> println("Attention ($cptAbs abs)")
    else -> println("Pas d'absence")
  }


  // if... else... avec retour de valeur
  val a : Int = 30
  val b : Int = 20
  var max : Int
  // version sans
  if (a >= b) {
    println("$a plus grand que $b")
    max = a
  }
  else {
    println("$a plus petit que $b")
    max = b
  }
  println(max)

  // version avec retour de valeur du if 
  max = if (a > b) {
    println("$a plus grand que $b")
    a // la dernière instruction du bloc est retournée
  }
  else if (a < b) {
    println("$a plus petit que $b")
    b
  }
  else b
  println(max)

  // when... avec retour de valeur
  max = when {
    a > b -> a
    a < b -> b
    else -> {
      println("$a égal à $b")
      a
    }
  }
  println(max)

} // eof main()