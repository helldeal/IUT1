import math as mt
import statistics as st
from operator import index
import random 
import csv
import pandas as pd 
import geopandas as gpd
import matplotlib.pyplot as plt 
import contextily as ctx
import numpy as np


#Calcul de la distance entre deux points
def distance(a,b):
    return (mt.sqrt((a[0]-b[0])**2 + (a[1]-b[1])**2))

#CSV en liste
def dataF(file):
    data = pd.read_csv(file)
    x=data["0"].tolist()
    y=data["1"].tolist()
    datalist=[]
    for i in range(0,len(x)):
        datalist.append([x[i],y[i]])
    return datalist

#Génère nb points aléatoires parmis data 
def initPts(data,nb):
    init=[]
    a=0
    while a<nb:
        init.append(random.choice(data))
        a+=1
    return init

#Calcul du point moyen d'une liste de points
def pointMoyen(liste):
    listX=[]
    listY=[]
    for i in liste:
        listX.append(i[0])
        listY.append(i[1]) 
    return ([st.mean(listX), st.mean(listY)])

#Algorithme de la méthode A
def methodA(data,ListPtsInit,NbMaxIter):
    listOfClasses=[]
    for i in range(0, len(ListPtsInit)):
        listOfClasses.append([])
    listOfCentroids=ListPtsInit
    for i in range(0,NbMaxIter):
        for j in data:
            pluspetitedistance=distance(j,listOfCentroids[0])
            cpt=0
            cptpetit=0
            for k in range(1, len(listOfCentroids)):
                cpt+=1
                d=distance(j,listOfCentroids[k])
                if d<pluspetitedistance:
                    pluspetitedistance=d
                    cptpetit=cpt
            listOfClasses[cptpetit].append(j)
        for i in range(0,len(listOfClasses)):
            listOfCentroids[i]=pointMoyen(listOfClasses[i])
    return listOfClasses,listOfCentroids

#Exemple de la méthode A
listpoints=dataF("data/data0.csv")
def MethodAExample(Title):
    listX=[]
    listY=[]
    plt.figure()
    data,centres=methodA(listpoints, initPts(listpoints,2), 20)
    for i in data:
        for j in i:
            listX.append(j[0])
            listY.append(j[1])
        plt.scatter(listX,listY)
        listX=[]
        listY=[]
    plt.title(Title)
    plt.savefig(f"{Title}.pdf")

#MethodAExample()

# Calcul de l'inertie d'une classe
def inertie(listeClasse, listePointsMoyens):
    listInertia=0
    for i in range(0,len(listeClasse)):
        somme=0
        for j in listeClasse[i]:
            somme+=distance(listePointsMoyens[i], j)
        listInertia+=somme
    return listInertia

#Affiche l'évolution de l'inertie en fonction du nombre de 
#classes afin de determiner le nombre de classes adapté
def Elbow(data, NbClassMax):
    x = np.arange(NbClassMax)
    y = []
    listpoints=dataF("data/data0.csv")
    plt.figure()
    for i in range(1,NbClassMax+1):
        classes, centres=methodA(data, initPts(listpoints,i), 20)  
        y.append(inertie(classes, centres))
    plt.plot(x,y)
    plt.show()

#Elbow(listpoints, 12)

#Algorithme de la méthode A intelligente
def MethodAIntel(data, NbMaxIter):
    databis=data.copy()
    L=[]
    moy=pointMoyen(data)
    while len(data)>NbMaxIter:
        distinit=distance(data[0],moy)
        for i in data:
            if distance(moy,i)>distinit:
                mtemps=i
        ListeOfClasseMtemps=[]
        for k in data:
            if distance(k,mtemps)<distance(k,moy):
                ListeOfClasseMtemps.append(k)
                mtemps=pointMoyen(ListeOfClasseMtemps)

        if len(ListeOfClasseMtemps)>NbMaxIter:
            L.append(mtemps)
        data = [elements for elements in data if elements not in ListeOfClasseMtemps]
        ListOfClasses, ListOfCentroids=methodA(databis , L, 25)
    return ListOfClasses, ListOfCentroids

#Exemple de la méthode A intelligente
def MethodAIntelExample(Title):
    listX=[]
    listY=[]
    plt.figure()
    data,centres=MethodAIntel(dataF("data/data0.csv"),20)
    for i in data:
        for j in i:
            listX.append(j[0])
            listY.append(j[1])
        plt.scatter(listX,listY)
        listX=[]
        listY=[]
    plt.title(Title)
    plt.savefig(f"{Title}.pdf")

#######PARTIE2######

#Csv en liste avec l'ajout d'un booléen et d'un indicateur de classe(Int)
def dataMark(file):
    data = pd.read_csv(file)
    x=data["0"].tolist()
    y=data["1"].tolist()
    datalist=[]
    for i in range(0,len(x)):
        datalist.append([x[i],y[i], False, -1])
    return datalist

#Renvoie tous les points voisins d'un point en fonction 
#d'une distance epsilon
def Voisins(liste_points, point, epsilon):
    voisins=[]
    for i in liste_points:
        if distance(point, i)<epsilon:
            voisins.append(i)
    return voisins

#Permet à partir d'une classe d'ajouter des points a celle ci si 
#ce point remplit certaines conditions 
#(distance adaptée, nombre de voisins adapté)
def ExtensionClasse(s, point, pointsVoisins, C, epsilon, Nmin):
    ptsVoisPrime=[]
    s.append(point)
    for p in pointsVoisins:
        if p[2]==False:
            p[2]=True
            ptsVoisPrime=Voisins(s,p,epsilon)
            if len(ptsVoisPrime)>=Nmin:
                pointsVoisins+=ptsVoisPrime
        if p[3]==-1:
            p[3]==C
    return pointsVoisins

#Algorithme de la méthode B utilisant les deux précédentes fonctions
def MethodB(data, epsilon, Nmin):
    allFinalClasses=[]
    bruit=[]
    C=2
    for p in data:
        if p[2]==False:
            p[2]=True
            pointsVoisins=Voisins(data,p,epsilon)
            if len(pointsVoisins)<Nmin:
                bruit.append(p)
                p[3]=1
            else :
                C+=1
                cla=ExtensionClasse(data, p, pointsVoisins, C, epsilon, Nmin)
                allFinalClasses.append(cla)
    allFinalClasses.append(bruit)
    return allFinalClasses

#Exemple de la méthode B
def MethodBExample(Title):
    listX=[]
    listY=[]
    plt.figure()
    listePts=MethodB(dataMark("data/data1.csv"),0.5,3)
    for i in listePts:
        plt.scatter([p[0] for p in i], [p[1] for p in i])
    plt.scatter(listX,listY)
    plt.title(Title)
    plt.savefig(f"{Title}.pdf")


#Quelques valeurs de epsilon et de NbMin fonctionelles :
#listePts=MethodB(dataMark("data/data1.csv"),0.5,3)
#listePts=MethodB(dataMark("data/data2.csv"),0.8,5)

def CompareMethods(Title):
    fig, (ax0, ax1, ax2, ax3)=plt.subplots(1,4)
    listX=[]
    listY=[]
    data,centres=MethodAIntel(dataF("data/data1.csv"),20)
    for i in data:
        for j in i:
            listX.append(j[0])
            listY.append(j[1])
        ax0.scatter(listX,listY)
        listX=[]
        listY=[]
    ax0.set_title("Methode A")

    listX=[]
    listY=[]
    listePts=MethodB(dataMark("data/data1.csv"),0.5,3)
    for i in listePts:
        ax1.scatter([p[0] for p in i], [p[1] for p in i])
    ax1.scatter(listX,listY)
    ax1.set_title("Methode B")

    listX=[]
    listY=[]
    data,centres=MethodAIntel(dataF("data/data0.csv"),20)
    for i in data:
        for j in i:
            listX.append(j[0])
            listY.append(j[1])
        ax2.scatter(listX,listY)
        listX=[]
        listY=[]
    ax2.set_title("Methode A")

    listX=[]
    listY=[]
    listePts=MethodB(dataMark("data/data0.csv"),0.5,3)
    for i in listePts:
        ax3.scatter([p[0] for p in i], [p[1] for p in i])
    ax3.scatter(listX,listY)
    ax3.set_title("Methode B")

    fig.savefig(f"{Title}.pdf")

#######PARTIE3######

def csvRead(file):
    read=pd.read_csv(file)
    return read

#définie un point grace a sa latitude et a sa longitude
def dataMark2(longitudes,latitudes):
    datalist=[]
    for i in range(0,len(longitudes)):
        datalist.append([longitudes[i],latitudes[i], False, -1])
    return datalist

#Affiche les manifestations en pays de la loire et 
#partitionne ces manifestations
def graphePL(Title):
    latitudes=[]
    longitudes=[]
    données=csvRead("MANIFESTATION_DATA_TABLE.csv")
    for i in données["LATITUDE"]:
        latitudes.append(i)
    for j in données["LONGITUDE"]:
        longitudes.append(j)
    fig, axes=plt.subplots(1,1,figsize=(12,12))
    classes=MethodB(dataMark2(longitudes,latitudes),0.129,60)
    for i in classes:
        plt.scatter([p[0] for p in i], [p[1] for p in i], zorder=2)
    #plt.scatter(longitudes,latitudes)
    data=gpd.read_file('region-pays-de-la-loire.geojson')
    plt.scatter(longitudes,latitudes)
    ax = data.plot(ax=axes, label="yo",linewidth=1.5, edgecolor='black',  alpha  =0.5)
    crs = data.to_crs(epsg=4326)
    ctx.add_basemap(ax, crs=crs.crs)
    plt.title(Title)
    plt.savefig(f"{Title}.pdf")
