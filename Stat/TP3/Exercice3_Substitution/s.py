import json
import string
import random
import numpy as np
import unidecode
import c 

   

def crypt(msg) :
    new=msg.replace(' ','')
    new = unidecode.unidecode(new)
    new=new.upper()
    c=list(new)
    random.shuffle(c)
    return ''.join(c)

def chiffre(msg,key):
    ALPHABET=string.ascii_uppercase
    new=msg.lower()
    new=new.replace(' ','')
    new = unidecode.unidecode(new)
    new=new.upper()
    for i in range(0,len(new)):
        for y in range(0,len(ALPHABET)):
            if new[i]==ALPHABET[y]:
                new = new[:i] + key[y] + new[i+1:]
                break
    return new

def dictquad(text):
    new_file = open("dictquad.json","w")
    with open(text, "r",encoding="UTF-8") as txt:
        lignes = txt.readlines()
        for ligne in lignes:
            DICT_QUAD[ligne[0:4]]=int(ligne[5:].replace("\n","")) 
        
    json.dump(DICT_QUAD,new_file)
    new_file.close()  

def logscore(chain):
    logsum = 0
    min_freq = 1e-10
    for i in range(len(chain)-3): 
        logsum += np.log10(DICT_QUAD.get(chain[i:i+4], min_freq))
    return -logsum
    
def neigh_keys(key):
    all_neigh_keys=[]
    for i in range(0,len(key)):
        for j in range(i,len(key)):
            if j!=i:
                new_key=key[:i]+key[j:j+1]+key[i+1:j]+key[i:i+1]+key[j+1:]
                all_neigh_keys.append(new_key)
                new_key=key
    return all_neigh_keys

def neigh_keys_2(key):
    all_neigh_keys=[]
    for i in range(0,len(key)):
        for j in range(0,len(key)):
            if j!=i :
                if j>i:
                    new_key=key[:i]+key[i+1:j+1]+key[i]+key[j+1:]
                    all_neigh_keys.append(new_key)
                    new_key=key
                elif i>j:
                    new_key=key[:j]+key[i]+key[j:i]+key[i+1:]
                    all_neigh_keys.append(new_key)
                    new_key=key
                
    return all_neigh_keys

def all_neigh_keys(keys1,keys2):
    neigh_keys=keys1
    for i in keys2:
        if (i not in neigh_keys):
            neigh_keys.append(i)
    return neigh_keys



DICT_QUAD={}
key=crypt(string.ascii_uppercase)
#key="ABCD"
print(key)
#print(len(all_neigh_keys(neigh_keys(key),neigh_keys_2(key))))

#print(chiffre('abc',key))
#c.decrpt("texte_chiffre_substitution.txt")

dictquad("quadrigramme.txt")
with open("texte_chiffre_substitution.txt", "r",encoding="UTF-8") as txt:
    lignes = txt.read()
    oldkey=[]
    oldkey.append(key)
    ls=999999999999999.9
    ret=lignes
    new=chiffre(lignes,key)
    keyref=key

    for i in range(0,10000000):
        k=0
        print(keyref)
        newkey=all_neigh_keys(neigh_keys(keyref),neigh_keys_2(keyref))
        while key in oldkey:
            key=newkey[k]
            k+=1

        oldkey.append(key)
        new=chiffre(lignes,key)
        print("key :",key,"n°",k,"new :",logscore(new),"ret :",logscore(ret))
        if logscore(ret)>logscore(new):
            print("--------------------------------------------------------------------------------------------------OK")
            ls=logscore(new)
            ret=new
            keyref=key
        else:
            print("--------------------------------------------------------------------------------------------------retour")
            if k==925:
                break
    
    print("ret",ret)

