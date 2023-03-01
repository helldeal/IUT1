# Vehicule - suite

Reprenez l'*exo01* sur les vehicules.

Ajoutez à la suite de votre implémentation le "scenario" suivant :
- créer 4 autres vehicules.
- créer un "camion" ( = un tableau de vehicules) et ajouter y tous les véhicules que vous avez créé
(utiliser l'instruction `arrayOf(...)` qui créé un tableau prérempli)
- écriver une fonction `afficherC(camion : Array<Vehicule>)` qui parcoure le camion pour afficher tous les vehicules qu'il contient
- utiliser cette fonction
- créer maintenant un "parking" de 100 places (= un tableau de vehicules) : utiliser l'instruction `arrayOfNulls(...)` qui créé un tableau vide.
- ecrire une fonction `decharger(camion : Array<Vehicule>, parking : Array<Vehicule?>)` qui décharge le camion dans
le parking : on placera chaque vehicule à la même "place" dans le parking qu'il avait dans le camion.
- utiliser cette fonction 
- ecrire une fonction  `afficherP(parking : Array<Vehicule?>)` pour lui permettre d'afficher le contenu du parking 
- utiliser cette fonction
- retirer le premier vehicule du parking (mettre à `null` une des cases)
- est-ce que la fonction `afficher(parking : Array<Vehicule?>)` fonctionne toujours ? corriger si nécessaire