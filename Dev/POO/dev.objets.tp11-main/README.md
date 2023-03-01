# dev.objets.tp11 : collections 

Dans ce TP nous allons utiliser les collections prédéfinies en Kotlin,
comme étudiées dans le CM à propos des 
[Collections](https://gitlab.univ-nantes.fr/iut.info1.dev.objets/dev.objets.ressources/-/blob/main/CMs/08-kotlin-collections.pdf)


## exo 1 : utiliser une liste et un ensemble

Dans `UtiliserList.kt`, déclarez et instanciez une `MutableList` 
Kotlin de `String`. 
Ajoutez y successivement une dizaine de valeurs, avec des doublons, etc.
Parcourez la liste pour afficher successivement chacune des valeurs.
Ajoutez des éléments à une position donnée, au début, à la fin.
A chaque étape, affichez la liste.
Recherchez la présence/l'absence d'un élément, la position d'un élément, etc.
Triez la liste dans l'ordre alphabétique

Déclarez maintenant un ensemble `LinkedHashSet` de `String`.
Ajoutez y successivement une dizaine de valeurs, avec des doublons, etc.
Parcourez l'ensemble pour afficher successivement chacune des valeurs.

Observez le retour du `add()` quand la valeur est un doublon déjà présent 
dans l'ensemble.
Notez qu'on ne peut pas ajouter à une position donnée dans un ensemble.

Créez un nouvel ensemble de type `HashSet` et ajoutez y en une seule
fois tout le contenu de l'ensemble précédent. Affichez le nouvel ensemble


## exo 2 : pays

Vous utiliserez la fonction `main()` pour tester votre code, au-fur-et-à-mesure.
Des cas de tests sont également fourni.

Complétez la classe `Pays` qui doit comporter 5 attributs 
: `nom : String`, `capitale ; String`, `continent : String`, 
`population : Int` et `superficie : Double`. 

Complétez la classe `Monde`. Utilisez une `List<Pays>` pour y stocker des pays. 

La méthode `remplir(nomFichier : String)` lit ligne à ligne, 
un fichier `.csv` et ajouter tous les pays lus ; Le fichier `data/pays.csv`
sera utilisé ; utilisez un `Scanner` pour lire ligne à ligne le fichier, puis
utilisez la méthode `split()` de la classe `String` pour découper la ligne.

Pour la méthode `mondeTrieSelonSuperficie()`, commencez par 
créer une classe `ComparateurPays` qui hérite de l'interface `Comparator<Pays>`.
La comparaison utilisera la superficie.
Utilisez le comparateur créé pour implémenter `mondeTrieSelonSuperficie()`


## exo 3 : tableau rempli aleatoirement

Implémentez la méthode `tableauAleatoireDistinct(n : Int) : Array<Int>`
du fichier `TabAlea.kt`qui renvoie un tableau de taille `n` rempli avec
des valeurs aléatoires toutes distinctes  comprises entre 1 et `n`.

Pour cela utilisez astucieusement un `HashSet` de `Int` et la méthode
`add()` pour savoir si un entier a déjà été tiré au sort ou s'il doit
être ajouté au tableau.
