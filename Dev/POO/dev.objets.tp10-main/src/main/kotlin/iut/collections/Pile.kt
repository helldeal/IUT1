package iut.collections

interface Pile<E> : Collection<E> {

    fun empiler(element : E)
    fun consulter() : E
    fun depiler() : E

}