# Point - suite

Reprenez l'*exo02* sur les points.

Ajoutez à la suite de votre implémentation :
- déclarer un tableau __vide__ de taille 10.
- ajouter comme premier élément du tableau le point `p1`.
- développer une fonction `afficher(points : Array<Point?>)` qui affiche tous les points présents dans `points`.
- utiliser la fonction sur le tableau déclaré précédemment ; uniquement `p1` devrait s'afficher

- développer une fonction `remplir(points : Array<Point?>)` qui remplit le tableau de point de la manière suivante : le i-ème point du tableau est construit comme une copie de son prédécesseur sur laquelle on applique une translation (`dx`, `dy`), les valeurs de `dx` et `dy` étant tirées aléatoirement entre `1` et `10`.

Pour réaliser un tirage aléatoire, utiliser la fonction `Random.nextInt(start,end)` qui renvoie un entier aléatoire compris entre `start` et `end` inclus ; nécessite d'importer `kotlin.random.*`

- utiliser la fonction `remplir()` puis afficher le tableau de points obtenus 


- copier le JAR `fenetre.jar` de `exo04/lib/` dans `exo02/lib/`

- On vous fourni ici une classe `Fenetre` capable d'afficher des points dans une fenetre, si on l'utilise correctement
    
    - `Fenetre(titre : String)` - construit une fenetre
    - `montrer()` - affiche la fenetre 
    - `ajouter(p : Point)` - ajoute un point à la fenetre
    -

- créer un objet `Fenetre` et afficher le

- ajouter tous les points de votre tableau de points à la fenetre avant de l'afficher.
