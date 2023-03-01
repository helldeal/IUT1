
import math
import string
import pandas as pd
import matplotlib.pyplot as plt
import numpy as np
import json
import unidecode

alphabet=string.ascii_lowercase
ALPHABET=string.ascii_uppercase

def is_upper(x):
    for i in ALPHABET:
        if x==i:
            return True
    return False

def caesar_crypt(msg,decal):

    new_alphabet=alphabet[decal:]+alphabet[:decal]
    new_ALPHABET=ALPHABET[decal:]+ALPHABET[:decal]
    msg_crypt=""
    for i in msg :
        if is_upper(i):
            for y in range (0, len(ALPHABET)):
                if i== ALPHABET[y]:
                    msg_crypt+=new_ALPHABET[y]
        else: 
            for y in range (0, len(alphabet)):
                if i== alphabet[y]:
                    msg_crypt+=new_alphabet[y]
    return msg_crypt


def filetofreq(text,fichier):
    new_file = open(fichier,"w")
    dictionnary ={}
    Alphabet=['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',' ']
    with open(text, "r",encoding="UTF-8") as txt:
        lignes = unidecode.unidecode(txt.read().lower()) 
        for i in range(0,26):
            freqlettre=lignes.count(Alphabet[i])/(len(lignes)-lignes.count(Alphabet[26]))*100
            dictionnary[Alphabet[i]]=freqlettre
    
    json.dump(dictionnary,new_file)
    new_file.close()   

def bar_freq(fichier):
    dictionary = json.load(open(fichier, 'r'))
    xAxis = [key for key, value in dictionary.items()]
    yAxis = [value for key, value in dictionary.items()]

    fig, ax = plt.subplots()
    ax.bar(xAxis,yAxis)
    plt.tight_layout()
    ax.set_title("Fréquence d'apparition d'une lettre")
    plt.show()
    

def bar_freq1_freq2(fichier1,fichier2):
    dictionary = json.load(open(fichier1, 'r'))
    xAxis = [key for key, value in dictionary.items()]
    yAxis = [value for key, value in dictionary.items()]
    dictionary2 = json.load(open(fichier2, 'r'))
    xAxis2 = [key for key,value in dictionary2.items()]
    yAxis2 = [value for key, value in dictionary2.items()]

    fig, ax = plt.subplots()
    ax.bar(np.arange(len(xAxis))+0.2,yAxis,0.4,label="Freq 1")
    ax.bar(np.arange(len(xAxis2))-0.2,yAxis2,0.4,label="Freq 2")
    plt.tight_layout()
    plt.legend()
    ax.set_title("Fréquence d'apparition d'une lettre")
    plt.show()

def bar_compare_freq(fichier1,fichier2,decal):
    dictionary = json.load(open(fichier1, 'r'))
    xAxis = [key for key, value in dictionary.items()]
    yAxis = [value for key, value in dictionary.items()]
    dictionary2 = json.load(open(fichier2, 'r'))
    xAxis2 = [key for key,value in dictionary2.items()]
    yAxis2 = [value for key, value in dictionary2.items()]
    yAxis2=yAxis2[decal:]+yAxis2[:decal]

    fig, ax = plt.subplots()
    ax.bar(np.arange(len(xAxis))+0.2,yAxis,0.4,label="Freq 1")
    ax.bar(np.arange(len(xAxis2))-0.2,yAxis2,0.4,label="Freq 2")
    plt.tight_layout()
    plt.legend()
    ax.set_title("Fréquence d'apparition d'une lettre")
    plt.show()

def manualdecrypt(fichier1,fichier2):
    for i in range(1,26):
        print("décalage :",i) 
        bar_compare_freq(fichier1,fichier2,i)


def moy(x):
    add=0
    for e in x:
        add+=e
    return add/len(x)

def covar(X,Y):
    som=0
    if len(X) == len(Y):
        for i in range(0,len(X)):
            a=(X[i]-moy(X)) * (Y[i]-moy(Y))
            a/=len(X)
            som+=a
            a=0
        return som
    else:
        return "error"

def variance(X):
    a=0
    for i in range(0,len(X)):
        a+=(X[i]-moy(X))**2
    return a*(1/len(X))

def coeff_corr(X,Y):
    return covar(X,Y)/(math.sqrt(variance(X)*variance(Y)))

def correlation_freqs(fichier1,fichier2):
    dictionary = json.load(open(fichier1, 'r'))
    yAxis = [value for key, value in dictionary.items()]
    dictionary2 = json.load(open(fichier2, 'r'))
    yAxis2 = [value for key, value in dictionary2.items()]

    corr=-1
    decal=0

    for i in range(1,26):
        yAxis2=yAxis2[1:]+yAxis2[:1]
        print("décalage :",i," crypt correlation :",coeff_corr(yAxis,yAxis2))
        if corr<coeff_corr(yAxis,yAxis2):
            decal=i
            corr=coeff_corr(yAxis,yAxis2)
    print("Décalage de décryptage :", decal)
    return decal

def decrpt(fichier):
    filetofreq(fichier,"freq.json")
    with open(fichier,"r",encoding="UTF-8") as txt:
        new_file = open("decrypted_with_caesar.txt","w")
        str=txt.read()
        strdecry=caesar_crypt(str,-correlation_freqs("freq_lettre_fr.json","freq.json"))
        new_file.write(strdecry)
        new_file.close()

def main():
    filetofreq("encrypted_with_caesar.txt","freq1.json")
    
    #bar_freq("freq_lettre_fr.json")
    #bar_freq1_freq2("freq_lettre_fr.json","freq1.json")
    #bar_compare_freq("freq_lettre_fr.json","freq1.json",3)
    #manualdecrypt("freq_lettre_fr.json","freq1.json") #ici c'est 17 de décalage
    correlation_freqs("freq_lettre_fr.json","freq1.json")
    decrpt("encrypted_with_caesar.txt")
        

main()