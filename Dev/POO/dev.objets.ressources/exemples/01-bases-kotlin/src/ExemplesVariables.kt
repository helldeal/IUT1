import kotlin.math.*

var ToToTo = "azer"
val vrai : Boolean = true
var c : Char = 'a'
var nbEtudiants : Int = 113
var argent : Long = 1_000L
val age : Byte = 10
var uneLettre : Char = 'a'
var estOk : Boolean = true // false
var unPrenom : String = "Totoro"  
val resultat : Double = 99_999.999999999
var valeur : Float = 87.345f

fun main() {
  print("Affichages : $ToToTo, $vrai, $c, $nbEtudiants, ")
  print("$argent, $age, $uneLettre, $estOk, $unPrenom, ")
  println("$resultat, $valeur")

  val premiereLettre = 'a'
  val nbLettres = 5
  //
  print("Le mot 'alpha' commence par un ")
  println(premiereLettre)
  print("Le mot alpha contient ")
  print(nbLettres)
  println(" lettres")
  //
  println("Le mot 'alpha' commence par un $premiereLettre et contient $nbLettres lettres")

  val nbConsonnes = 3
  val nbVoyelles = 2
  println("Le mot 'alpha' contient ${nbConsonnes + nbVoyelles} lettres")

  var nb = 8
  var add = nb + 2  
  println(add)  // 10
  var min = add - nb  
  println(min) // 2
  var mult = 5 * min   
  println(mult)  // 10
  var div = mult / 4  
  println(div)  // 2
  var reste = 5 % min 
  println(reste)  // 1
  var div2 = mult / 4.0 
  println(div2)// 2.5

  var compteur = 1
  compteur--
  println(compteur)   // 0
  compteur++
  compteur++
  println(compteur)   // 2
  compteur += 2
  println(compteur)   // 4
  compteur -= 3
  println(compteur)   // 1
  compteur *= 7
  println(compteur)   // 7
  compteur /= 2
  println(compteur)   // 3

  println("PI arrondi = ${ceil(abs(PI))}")
  var calcul : Double = max(4.0, 3.0)
  calcul += 3
  println("$calcul")

  val grand = 5
  val petit = 2
  var cond : Boolean
  cond = grand == petit
  println("$cond") // false
  cond = grand == 5
  println("$cond") // true
  cond = grand != petit
  println("$cond") // true
  cond = grand >= petit
  println("$cond") // true
  cond = (grand < petit) && (petit > 10)
  println("$cond") // false
  cond = (grand > petit) || !(petit > 10)
  println("$cond") // true
  cond = grand in 4..Int.MAX_VALUE
  println("$cond") // true  

}