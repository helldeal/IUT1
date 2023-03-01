import pandas as pd
import matplotlib.pyplot as plt
import numpy as np
data = pd.read_csv('consommation_menages.csv', sep=',',decimal=',')


print("1 : ",data)
print("2 : ",type(data))
print("3 : ",data.info)
print("4 : ",data.Fonction)
print("5 : ",data['Fonction'])
print("6 : ",data['1960'])
print("7 : ",data[['1960','2020']])



def ex1_1_1():
    fig, ax = plt.subplots()
    plt.xticks(rotation=35,ha="right")
    ax.bar(data['Fonction'], data['1960'])
    plt.tight_layout()
    ax.set_title("Consomation des ménages en 1960")
    plt.show()

def ex1_1_2():
    fig, ax = plt.subplots()
    ax.pie(data['2020'],  labels=data['Fonction'], autopct='%1.1f%%')
    ax.set_title("Consomation des ménages en 2020")
    plt.show()

def ex1_1_3():
    width=0.35
    fig, ax = plt.subplots()
    plt.xticks(rotation=35,ha="right")
    b1=ax.bar(np.arange(len(data['Fonction']))- width/2, data['1960'],width, label='1960')
    b2=ax.bar(np.arange(len(data['Fonction']))+ width/2, data['2020'],width, label='2020')
    ax.set_xticks(np.arange(len(data['Fonction'])))
    ax.set_xticklabels(data['Fonction'])
    ax.set_title("Consomation des ménages en 1960 et 2020")
    plt.tight_layout()
    plt.show()



def main():
    #ex1_1_1()
    #ex1_1_2()
    ex1_1_3()
if __name__ == '__main__':
    main()
