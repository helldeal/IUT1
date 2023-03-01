import pandas as pd
import geopandas as gpd
import matplotlib.pyplot as plt
from matplotlib.patches import Patch
import contextily as ctx
import csv
### Lecture du fichier



def mise_en_forme_data():
    data = gpd.read_file("a-dep2021.json")

    # with open("Exercice2_COVID/data_covid_hosp.csv", newline='') as csvfile:
    #         colrep = csv.reader(csvfile, delimiter=',')
    #         Liste=[]
    #         ColListe=[]
    #         for row in colrep:
    return

def visualisation_data(date):
    data = mise_en_forme_data()
    fig, axes = plt.subplots(1,1,figsize=(10,10))
    data.plot(ax=axes, column=date, cmap='magma_r',legend=True)