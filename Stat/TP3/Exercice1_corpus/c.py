

import json
import unidecode


def filetofreq(txt,fichier):
    new_file = open(fichier,"w")
    dictionnary ={}
    Alphabet=['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',' ']
    with open(txt, "r",encoding="UTF-8") as txt:
        lignes = unidecode.unidecode(txt.read().lower()) 
        print(lignes)
        for i in range(0,26):
            freqlettre=lignes.count(Alphabet[i])/(len(lignes)-lignes.count(Alphabet[26]))*100
            dictionnary[Alphabet[i]]=freqlettre
    
    json.dump(dictionnary,new_file)
    new_file.close()   
    


filetofreq("Corpus/amourSwann.txt","freq_lettre_fr_approx.json")
     

