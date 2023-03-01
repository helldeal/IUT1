package iut.collections

interface Liste<E> : File<E> {
    fun index(element : E) : Int
    fun consulter(index : Int) : E
    fun inserer(index : Int, element : E)
    fun supprimer(index : Int)
}
