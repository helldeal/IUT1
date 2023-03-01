
from cgitb import handler
import pandas as pd
import geopandas as gpd
import matplotlib.pyplot as plt
from matplotlib.patches import Patch
import contextily as ctx
import csv
### Lecture du fichier

data = gpd.read_file("a-dep2021.json")
colors=['#FFFFFF','#E2B5A4','#C48B7D','#A76258','#8A3832','#6C0000']

with open("Exercice1_REP/collegiens_REP.csv", newline='') as csvfile:
        colrep = csv.reader(csvfile, delimiter=',')
        Liste=[]
        ColListe=[]
        for row in colrep:
            Liste.append(list(row))
        for i in range(1,len(Liste)):
            if float(Liste[i][3])==0.0:
                ColListe.append(colors[0])
            elif float(Liste[i][3])<2.5:
                ColListe.append(colors[1])
            elif float(Liste[i][3])<4.5:
                ColListe.append(colors[2])
            elif float(Liste[i][3])<7.5:
                ColListe.append(colors[3])
            elif float(Liste[i][3])<12.5:
                ColListe.append(colors[4])
            else :
                ColListe.append(colors[5])
        
        data['color'] = pd.DataFrame(ColListe)
                



#

### Code d ́epartementaux des DOM
filter_dep = ["971", "972", "973", "974", "976"]
### On filtre nos donn ́ees
data = data.query('dep not in @filter_dep')

### Ouverture d’une figure
fig, axes = plt.subplots(1,1,figsize=(12,12))
### Trac ́e des donn ́ees g ́eographiques dans la figure

data=data.to_crs(epsg=3857)
data.plot(
ax = axes, # Axes de trac ́e
 linewidth=1, # Epaisseur de la ligne
 edgecolor="black", # Couleur de la ligne
 color=data["color"], # Couleur de l’aplat
 alpha = 0.5 # Transparence de l’aplat
 )
axes.set_axis_off() # Suppression des axes

legendliste=[
    Patch(facecolor=colors[0], label='Aucun REP+'),
    Patch(facecolor=colors[1], label='Moins de 2.5'),
    Patch(facecolor=colors[2], label='De 2.5 à moins de 4.5'),
    Patch(facecolor=colors[3], label='De 4.5 à moins de 7.5'),
    Patch(facecolor=colors[4], label='De 7.5 à moins de 12.5'),
    Patch(facecolor=colors[5], label='12.5 ou plus')
    ]

axes.legend(handles=legendliste,title="Part de collégiens en REP+ (en %)")

ctx.add_basemap(axes)
### Affichage
plt.show()