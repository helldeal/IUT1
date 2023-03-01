# Point

Dans `lib/` vous avez une classe `Point` qui vous est fournie. Vous travaillerez dans `src/TestPoint.kt`.

Implémentez le "scénario" suivant : 
- Créer un Point p1 initialisé à (0,0), l'afficher.
- Créer un Point p2 initialisé à (1,2), l'afficher.
- Afficher la coordonnée x de p1, puis de p2.
- Modifier la coordonnée y de p2 en y affectant la valeur 3 , afficher p2.
- Translater p2 de 1 en x et de 1 en y, afficher p2.
- Déplacer p1 en (2,10), l'afficher.
- Calculer la distance de p2 à l'origine, l'afficher.
- Calculer la distance entre p1 et p2, l'afficher.
- Affecter p1 à p2, afficher les deux.
- Translater p1 de (2,1), afficher p1 et p2 (surpris(e) ?)

Pour cela, vous utiliserez les méthodes fournies par la classe `Point` :

- `Point() : Point `-- créé un nouveau Point initialisé à (0,0)
- `Point(x : Int, y : Int) : Point `-- créé un nouveau Point initialisé aux paramètres (`x``,y`)
- `Point(pt : Point) : Point` -- créé un nouveau Point initialisé comme le paramètre `pt`
- `deplacer(newX : Int, newY : Int)` -- déplace le point courant en (`newX`,`newY`) (i.e les nouvelles coordonnées du Point sont (`newX`,`newY`) )
- `distance(autrePt : Point) : Double` -- renvoie la distance entre le Point courant et le Point donné en paramètre
- `distanceOrigine() : Double` -- renvoie la distance à l'origine du Point courant
- `getX()` -- renvoie x du Point courant
- `getY()` -- renvoie y du Point courant
- `setX(int x)` -- modifie x du Point courant
- `setY(int y)` -- modifie y du Point courant
- `translater(int dx : Int, dy : Int)` -- translate le point courant de `dx` et `dy` (i.e les nouvelles coordonnées de mon Point sont (`x+dx`,`y+dy`) )