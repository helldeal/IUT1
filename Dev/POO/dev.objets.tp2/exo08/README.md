# Triangle rectangle

On peut passer différents arguments après l'appel d'une classe Kotlin _exécutable_ (= qui contient une fonction `main()`). Dans le code, on récupère ces paramètres dans un tableau en paramètre de la fonction `main()`.

On veut récupérer 3 valeurs numériques, passées comme arguments, puis vérifier qu'elles décrivent bien les longeurs des côtés d'un triangle rectangle.

1. développer une fonction `estRectangle()` qui détermine si les 3 valeurs passées en paramètres déterminent bien un triangle rectangle

2. utiliser cette fonction dans la fonction  `main()` en prenant les valeurs 
dans les arguments passés lors de l'appel de la classe. L'ordre des arguments n'a pas d'importance.
Vérifiez également qu'il ya le bon nombre d'arguments ; affichez des messages d'erreur sinon. Utilisez un `when`.
Vérifiez aussi que le type des arguments est correct. Utilisez par exemple, la méthode  `toDoubleOrNull()` de `String`.

3. Testez votre code. Des valeurs correctes sont :
```
5.0 4.0 3.0
4.0 5.0 3.0
4.0 3.0 5.0
3 5 4
8 10 6
9 15 12
4059 4060 5741
```
Essayez des cas d'erreurs également.