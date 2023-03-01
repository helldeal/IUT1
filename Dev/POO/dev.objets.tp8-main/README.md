# TP8 : Matrice 

## Matrice carrée

La classe `iut.math.SquareMatrix` devra définir une _matrice
carrée d'ordre `n`_ (ordre= dimension de la matrice carrée)
avec toutes les opérations nécessaires.

Globalement  : 
[Wikipedia Matrice](https://fr.wikipedia.org/wiki/Matrice_(math%C3%A9matiques))
et
[une documentation d'un inconnu sur Internet (merci à lui)](doc_matrice.pdf)

Pour simplifier, la matrice contiendra des _entiers_.

Pour implémenter la matrice, vous vous baserez sur un attribut _privé_
de type tableau de tableau : `Array< Array<Int>>`

Utilisez `Main.kt` ainsi que `TestMatrix.kt` pour valider votre développement

1. Le constructeur de la matrice initialisera une 
[matrice nulle](https://fr.wikipedia.org/wiki/Matrice_nulle)
   Assurez-vous également que l'ordre permet bien de définir une matrice ; sinon
   une exception `IllegalArgumentException` sera levée

3. `order() : Int` donne l'ordre de la matrice

4. `isNull() : Boolean` indique si la matrice est nulle

5. `toString(): String` renvoie une chaine de caractères 
permettant d'afficher la matrice



        -2	5	-7	1	-10
        4	8	-4	5	-8
        8	1	9	-6	3
        1	8	-7	-1	2
        7	-7	6	-1	-7



Utilisez `"\t"` pour un tabulation et `"\n"` pour un retour à la ligne


5. `setAsIdentity()` transforme la matrice courante en une
[matrice identité](https://fr.wikipedia.org/wiki/Matrice_identit%C3%A9)
d'ordre n

6. `isIdentity() : Boolean` indique si la matrice courante est
une matrice identité

7. `randomize(from : Int, until :Int)` affecte à la matrice
courante des valeurs tirées aléatoirement entre `from` et `until` ;
utilisez 
[kotlin.random.Random](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.random/-random/)
assurez-vous que  `from` et `until` sont bien définis, sinon 
une exception `IllegalArgumentException` sera levée

8. Redéfinissez l'égalité `==`  pour une matrice carrée

9. Redéfinissez la [somme](https://fr.wikipedia.org/wiki/Matrice_(math%C3%A9matiques)#Addition_des_matrices_et_multiplication_par_un_scalaire) 
`M1 + M2` de deux matrices 
Si la somme n'est pas possible, une exception `ArithmeticException` sera levée

10. Redéfinissez le [produit](https://fr.wikipedia.org/wiki/Matrice_(math%C3%A9matiques)#Addition_des_matrices_et_multiplication_par_un_scalaire)
`M * k` d'une matrice par un entier

11. Redéfinissez l'opposé d'une matrice `-M`, en utilisant le produit

12. Redéfinissez la différence de deux matrices `M1 - M2` en utilisant
la somme et l'opposé

13. `transposite() : SquareMatrix` donne la 
[transposée](https://fr.wikipedia.org/wiki/Matrice_transpos%C3%A9e) 
de la matrice courante 

14. `isSymetrical() : Boolean` indique si la matrice courante est 
[symétrique](https://fr.wikipedia.org/wiki/Matrice_sym%C3%A9trique)

15. `isAntiSymetrical() : boolean` indique si la matrice courante est
[antisymetrique](https://fr.wikipedia.org/wiki/Matrice_antisym%C3%A9trique)

16. Redéfinissez le [produit](https://fr.wikipedia.org/wiki/Produit_matriciel#Produit_matriciel_ordinaire)
`M1 * M2` de deux matrices ;
Si le produit n'est pas possible, une exception `ArithmeticException` sera levée


## Matrice quelconque

En utilisant l'héritage, généralisez dans une classe `iut.math.Matrix` votre code précédent 
au cas de matrices quelconques de taille `m x n`

Qui hérite de qui ? quelles méthodes sont généralisable ? lesquelles sont spécifiques ? 
lesquelles sont à redéfinir ?

