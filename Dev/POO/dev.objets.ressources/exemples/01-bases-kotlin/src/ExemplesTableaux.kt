fun main() {

    // declarer un tableau vide

    val notes0 = arrayOfNulls<Double>(4)
    val matieres0 = arrayOfNulls<String>(10)


    // declarer un tableau prérempli

    val notes : Array<Double> = arrayOf(12.0, 7.0, 10.5, 8.2, 17.8)
    val matieres : Array<String> = arrayOf("Info", "Math", "Anglais", "Comm", "Eco")

    var nbNotes = notes.size
    val noteInfo = notes[0]
    println(noteInfo)
    println(notes[2])
    notes[2] = 8.2
    println(notes[2])

    val mat = matieres[0]
    println(mat)
    println(matieres[2])
    matieres[2] = "Russe" 
    println(matieres[2])


    for (indice in 0..notes.size-1) {
        println(notes[indice])
    }

    for (note in notes) {
        println(note)
    }

    println("moyenne ${moyenne(notes)}")

    val notes2 = doubleArrayOf(12.0, 7.0, 10.5, 8.2, 17.8)
    affiche(notes2)
    val notes1 = DoubleArray(10)
    affiche(notes1)

    affiche0(notes)
    //affiche(notes0)
}

fun moyenne(tableau:Array<Double>) : Double {
    var moy = 0.0
    for (note in tableau) {
        moy += note
    }
    return moy / tableau.size
}

fun affiche0(tableau:Array<Double>) {
    print("[ ")
    for (note in tableau) {
        print("$note ")
    }
    println("]")
}

fun affiche(tableau:DoubleArray) {
    print("[ ")
    for (note in tableau) {
        print("$note ")
    }
    println("]")
}