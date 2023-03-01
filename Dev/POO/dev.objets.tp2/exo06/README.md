Implémentez la méthode `chiffrement(original : String, decalage : Int) : String` 

qui réalise un chiffrement de la  chaine de caractère en réalisant un simple décalage : cette méthode
de chiffrement "très simple" est également connue sous le nom de
"chiffre de César" : https://fr.wikipedia.org/wiki/Chiffrement\_par\_d%C3%A9calage

Quelques indications :
- on commencera par passer la chaine originale en majuscule
- vous pouvez utiliser un tableau de caractères représentant l'alphabet
    - cela permet d'avoir rapidement la lettre correspondant à une position, 
    - cela perment aussi de déterminer la position d'une lettre
    - tips: insérer un caractère vide dans la premiere case du tableau peut faciliter la vie
- construisez la chaine chiffrée par concaténation sucessive

Des tests vous permettront de valider votre implémentation