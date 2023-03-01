# dev.objets.tp7

Dans `src/main/kotlin/iut.math/Pgcd.kt` implémentez la 
fonction` pgcd(..)`

https://fr.wikipedia.org/wiki/Plus_grand_commun_diviseur


Dans `src/main/kotlin/iut.math/Rational.kt`, la classe `Rational` définie un nombre rationnel par deux entiers 
`numerator` et `denominator`, le `denominator` ne pouvant pas valoir `0`.

On peut créer un rationnel à partir d'un unique entier ; dans ce cas
son `denominator` vaut 1

https://fr.wikipe`dia.org/wiki/Nombre_rationnel`

en particulier https://fr.wikipedia.org/wiki/Nombre_rationnel#Arithm%C3%A9tique_des_rationnels

### Implémentez les méthodes suivantes

1. ajoutez une méthode `toString()` qui renvoie un chaine de caractères 
représentant le rationnel

Ex : `Rational(2,3) => "2/3"`

_Vous pouvez décommenter une partie des lignes de `Main.kt` pour tester votre code_

2. On souhaite pouvoir utiliser l'opérateur `+` pour réaliser 
la somme de deux rationnels. Ex: 


        var r23 = Rational(2,3)
        var r12 = Rational(1,2)
        var result = r23 + r12

Ajoutez le code nécessaire.

3. On souhaite maintenant pouvoir realiser 
la somme d'un rationnel avec un entier. Ex :


        var r23 = Rational(2,3)
        var result = r23 + 3

4. Implémentez une méthode `opposite() : Rational`
qui retourne l'opposé du rationnel courant
   https://fr.wikipedia.org/wiki/Oppos%C3%A9_(math%C3%A9matiques)

Complétez `Main.kt` pour tester votre code

5. On souhaite pouvoir utiliser l'opérateur `-`
pour réaliser la différence de 2 rationnels. 
NB : Utilisez `+` et `opposite()` 


       var r23 = Rational(2,3)
       var r12 = Rational(1,2)
       var result = r23 - r12

Complétez `Main.kt` pour tester votre code

6. Implémentez une méthode `reduce() : Rational` qui renvoie 
un rationnel = forme irréductible du rationnel courant ; 
le signe est porté par le numérateur si le nombre est négatif ;
le nombre est positif, pas de signe moins

NB : utilisez la fonction `pgcd(..)`

Complétez `Main.kt` pour tester votre code

7. On souhaite pouvoir utiliser les opérateurs `==` et `!=`
pour vérifier l'égalité/inégalité entre deux rationnels ;
deux rationnels sont égaux si les numérateurs et dénominateurs
de leurs formes irréductibles sont égaux


        var r23 = Rational(2,3)
        var r12 = Rational(1,2)
        var r36 = Rational(3,6)
        r23  == r12   // false
        r23 != r12    // true
        r12 == r36    // true

Complétez `Main.kt` pour tester votre code

9. On souhaite utiliser les opérateurs `<`, `>`, `<=` ou `>=`
pour comparer deux rationnels ; 
pour cela il faut i) 
ramener les deux rationnels sur le même dénominateur, 
puis ii) comparer leurs numérateurs


        var r23 = Rational(2,3)
        var r12 = Rational(1,2)
        var r36 = Rational(3,6)
        r23  > r12   // true
        r23 <= r12    // false
        r12 <= r36    // true

Complétez `Main.kt` pour tester votre code

10. On souhaite utiliser l'opérateur `*` pour multiplier
deux rationnels ensemble.
On souhaite également pouvoir multiplier un rationnel par un entier.

Complétez `Main.kt` pour tester votre code

11. donnez une fonction `inverse() : Rational?` qui donne l'inverse
d'un rationnel
    
    https://fr.wikipedia.org/wiki/Inverse

12. On souhaite utiliser l'opérateur `/` pour diviser
    deux rationnels ensemble.

On souhaite également pouvoir diviser un rationnel par un entier.




