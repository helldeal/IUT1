package but1.iut.r203.chenil



fun main(args: Array<String>) {

    var ch1 = Chien("Lassie", "Yorkshire",DateChenilStub())
    ch1.setDateNaissance(2021, 2, 28)
    println(ch1)
    println(ch1.ageMois())

    var ch2 = Chien("Médor", "Chihuahua",DateChenilSystem())
    ch2.setDateNaissance(2021, 2, 15)
    println(ch2)
    println(ch2.ageMois())
}