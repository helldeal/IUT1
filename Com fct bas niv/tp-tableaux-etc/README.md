# TP2 : pointeurs, tableaux, ...

Les objectifs de cette séance sont :

  1. Explorer la représentation en mémoire des tableaux (_array_) et des tranches (_slices_).
  2. Observer les mécanismes associés à l'appel de sous-programme étudiés dans lors de la séance précédente.
  3. Améliorer votre maîtrise des débugueurs en général et de `delve` en particulier.

Pour cela, nous proposons d'utiliser le programme ci-dessous (également disponible dans le répertoire `src`).

```go
package main

import (
	"fmt"
)

//go:noinline
func print(t []int32) {
	fmt.Print("{")
	for i:=0; i<len(t) - 1; i++ {
		fmt.Print(t[i], ", ")
	}
	fmt.Printf("%d}\n", t[len(t)-1])
}

//go:noinline
func swap (v1 *int32, v2 *int32) (r int32) {
	tmp := *v1
	*v1 = *v2
	*v2 = tmp
	r = *v1 + *v2
	return
}

func main() {
	var w = [8]int32{2,3,5,7,11,13,17,19}

	x := w

	y := w[:]

	z := &x

	for cpt := 0; cpt < len(y); cpt++ {
		_ = swap( &((*z)[cpt]), &(y[(cpt+2)%len(y)]) )
	}

	print(w[:])
	print(x[:])
	print(y)
	print((*z)[:])
}
```

# Questions préliminaires

Donner la sortie du programme sans l'exécuter.

# Représentation en mémoire des tableaux et des tranches 

On s'intéresse au programme principal (fonction `main.main`).
Concernant `delve`, lire la documentation des commandes `print`, `display` et `examinemem`. 
On rappelle que l'aide en ligne est disponible via la commande `help`, par exemple :

``` text
(dlv) help print
```

Cette aide est également disponible [sur le dépôt github du projet](https://github.com/go-delve/delve/blob/master/Documentation/cli/README.md).

Par ailleurs, l'aide décrivant les expressions qu'il est possible d'afficher via `print` et `display` [est ici](https://github.com/go-delve/delve/blob/master/Documentation/cli/expr.md).

Celle-ci n'étant pas toujours claire, voici par exemple une commande permettant d'afficher la valeur du pointeur de pile au format hexadécimal :

``` text
(dlv) print %x RSP
```

## Questions

1. Rappeler la différence entre un tableau et une tranche.

2. Rappaler la représentation en mémoire d'un tableau et d'une tranche.

3. Donner le type des variables `w`, `x`, `y` et `z`.

3. Quelle suite de commande permet d'afficher la représentation en mémoire de `w` ? Même question pour `x`, `y` et `z`.

4. Mettre un point d'arrêt à la ligne 34 du fichier et avancer l'exécution jusqu'à ce point. Quelle suite de commande permet d'afficher les 20 premiers mots de la pile (en partant du sommet) ? Faire afficher la pile et identifier les différents objets qu'elle contient. 

# Passage de paramètre et code de retour

## Questions 

6. Mettre un point d'arrêt à l'entrée de la fonction `main.swap`. S'y rendre et faire afficher les 40 mots au sommet de la pile. Identifier les différents objets qu'elle contient.

7. Mettre un point d'arrêt ligne 22, s'y rendre. Afficher le code assembleur associé à cette ligne. Exécuter ce code instruction par instruction, en expliquant le rôle et l'effet de chaque instruction.

8. Continuer l'exécution jusqu'à retourner dans `main.main`. Afficher à nouveau la pile et identifier les objets qu'elle contient.

9. Mettre maintenant un point d'arrêt à la fonction `main.print`. Désactiver les autres point d'arrêt puis se rendre à `main.print`. Faire afficher les 40 mots au sommet de la pile et identifier les différents objets qu'elle contient.

