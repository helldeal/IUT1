package iut.collections

interface File<E> : Pile<E> {
    fun insererEnTete(element : E) {
        empiler(element)
    }
    fun consulterEnTete() : E {
        return consulter()
    }
    fun supprimerEnTete() {
        depiler()
    }

    fun insererEnQueue(element : E)
    fun consulterEnQueue() : E
    fun supprimerEnQueue()

}