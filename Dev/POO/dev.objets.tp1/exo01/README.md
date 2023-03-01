Pour compiler  des fichiers source Kotlin nous allons utiliser le 
_compilateur Kotlin en ligne de commande_ (Kotlin command-line compiler - [documentation](https://kotlinlang.org/docs/command-line.html))

1. Compilez le fichier source `Hello.kt` présent dans `src` : 
```
kotlinc src/Hello.kt -d bin
```
On appelle le compilateur Kotlin `kotlinc`, on lui demande de compiler
le fichier `Hello.kt`présent dans le dossier `src/` et on demande que le résultat de
la compilation soit placé dans `bin`(option `-d` pour `destination`)

_Sur les postes de l'IUT un message similaire à celui-ci va apparaitre :_
```
Picked up _JAVA_OPTIONS: -Dhttps.proxyHost=srv-proxy-etu-2.iut-nantes.univ-nantes.prive -Dhttps.proxyPort=3128
```
_Ce n'est pas une erreur ; n'y prêter attention._

2. Regardez dans `bin`ce qui est apparut :
```
ls -l bin/` par exemple
```

3. Exécutez le fichier Bytecode `HelloKt.class` compilé précédemment :
```
kotlin -cp bin HelloKt
``` 
La commande `kotlin` lance ma machine virtuelle Java ; on lui indique qu'il y a des
fichiers `.class` dans `bin` (option `-cp` pour `class-path`) et on lui demande d'éxécuter
le fichier compilé `HelloKt.class` ; ATTENTION, il faut **ommettre** l'extension `.class`

On peut également utiliser directement une machine virtuelle java :
```
java -cp bin HelloKt
```

