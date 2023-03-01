1) Compilez les sources kotlin fournis : 
```
kotlinc src/Exo5.kt -d bin
```
ne compile pas car il faut déjà avoir compiler `Calculette.kt`

```
kotlinc src/Calculette.kt -d bin
```
compile correctement, mais 
```
kotlinc src/Exo5.kt -d bin
``` 
ne compile toujours pas : il ne trouve pas les méthodes
`add()` et `mult()` appelées dans `Exo5.kt` mais déclarées dans `Calculette.kt`

```
kotlinc src/Exo5.kt -cp bin -d bin
``` 
fonctionne : il faut avoir ajouté une nouvelle option `-cp bin` (pour `class-path`) afin d'indiquer au compilateur Koltin où trouver `CalculetteKt.class`

On peut aussi compiler tout en une seule fois : 
```
kotlinc src/*.kt -cp bin -d bin
```

On dit au compilateur kotlin de compiler tous les fichiers `.kt` qu'il trouve dans `src/` en utilisant les `.class` compilés qu'il va trouver dans `bin/` et de les envoyer au fur et mesure dans `bin/`. Notez également que le compilateur gère alors les dépendances.

2) On peut toujours exécuter `Exo5Kt.class` : 
```
kotlin -cp bin Exo5Kt
```

3) Dans `bin/` il y a maintenant deux fichiers `.class` ; imaginez ce que cela donnera quand on aura 10, 20... voir 100 fichiers Koltin compilés. Difficile de retrouver quel fichier il faut exécuter et difficile à "distribuer" ;-)

On va maintenant compiler tous les fichiers Kotlin pour les placer dans un fichier archive `.jar` : 
```
kotlinc src/*.kt -include-runtime -cp bin -d bin/exo5.jar
```

On peut toujours exécuter la classe `MainKt.class` : 
```
kotlin -cp bin/exo5.jar Exo5Kt
```  
On doit juste préciser  que l'archive `.jar` est dans le `class-path`.


On peut aussi exécuter directement l'archive `.jar`  : 
```
java -jar bin/exo5.jar
```

