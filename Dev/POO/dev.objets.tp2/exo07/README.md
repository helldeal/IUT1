Implémentez les fonction demandées en utilisant (le plus possible) les
méthodes de la classe `Array<T>` :

- `indexOf(element : T) : Int` : donne la position de l'élément dans le tableau courant, -1 sinon
- `maxOrNull() : T?` : retourne le plus grand élément du tableau courant, ou `null` s'il n'y a pas d'éléments
- `minOrNull() : T?` : retourne le plus petit élément du tableau courant, ou `null` s'il n'y a pas d'éléments
- `reverse()` : inverse le tableau courant
- `reversedArray() : Array<T>` : retourne un tableau inversé du tableau courant
- `shuffle()` : mélange le tableau courant
- `sort()` : trie le tableau courant
- `sortedArray() : array<T>` : retourne une tableau trié du tableau courant
- `sortedArrayDescending() : array<T>`  : retourne une tableau trié du tableau courant
- `sum()`: retourne la somme de tous les éléments du tableau courant
- `binarySearch(element : T) : Int` : applique la recherche dichotomique - présuppose que le tableau courant est trié -
 retourne la position de l'élément dans le tableau courant s'il est présent, sinon, retourne `(-insertionpoint - 1)`
 où `insertionpoint` est la position où l'élément devrait être inséré pour maintenir le tableua trié

https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/