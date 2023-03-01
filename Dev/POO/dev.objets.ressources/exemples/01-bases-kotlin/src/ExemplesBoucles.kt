fun main() {


var cptRebourd = 10
println("Depart dans...")
while (cptRebourd >= 0) {
  println(cptRebourd)
  cptRebourd--
}
println("Go !!!")


println("Depart dans...")
for (compteur in 10 downTo 0 step 1) {
  println(compteur)
}
println("Go !!!")

println("Depart dans...")
for (compteur in 10 downTo 0) {
  println(compteur)
}
println("Go !!!")

println("Depart dans...")
for (compteur in 10 downTo 0 step 2) {
  println(compteur)
}
println("Go !!!")

println("Depart a 10...")
for (compteur in 0 until 10) {
  println(compteur)
}
println("Go !!!")

println("Depart a 10...")
for (compteur in 0..9) {
  println(compteur)
}
println("Go !!!")

}