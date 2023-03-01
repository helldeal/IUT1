
import pandas as pd
import matplotlib.pyplot as plt
import TP1_mobilite_sociale as do

def ex1_4_1():
    fig, ax = plt.subplots()
    ax.barh(y='A', width = 3, left= 0, height = 0.5)
    ax.barh(y='A', width = 2, left= 3, height = 0.5)
    ax.barh(y='B', width = 1, left= 0, height = 0.5)
    ax.barh(y='B', width = 4, left= 1, height = 0.5)
    plt.show()

def ex1_4_2():
    fig, ax = plt.subplots()
    ax.barh(y='A', width = 3, left= 0, height = 0.5)
    ax.barh(y='A', width = 2, left= 3, height = 0.5)
    ax.barh(y='B', width = 1, left= 0, height = 0.5)
    ax.barh(y='B', width = 4, left= 1, height = 0.5)
    ax.set_ylim(-1,1)
    ax.xaxis.set_visible(False)
    plt.show()

def ex1_4_3():
    agriculteur = [27.6, 9.0, 12.2, 14.8, 26.0, 10.4]
    category_colors = ["tab:olive","tab:purple",
    "tab:blue","tab:cyan", "tab:brown","tab:orange"]
    fig, ax = plt.subplots(figsize=(8, 5))
    add=0
    for i in range(len(agriculteur)):
        ax.barh(y='Agriculteur', width = agriculteur[i],color= category_colors[i], left= add, height = 0.5)
        add+=agriculteur[i]
    ax.set_ylim(-1,1)
    ax.set_title("Catégorie socioprofessionelle \ndes hommes ayant un père agriculteur")
    ax.legend([do.category_names[0],do.category_names[1],do.category_names[2],do.category_names[3],do.category_names[4],do.category_names[5]],loc='center left', bbox_to_anchor=(1, 0.5))
    ax.xaxis.set_visible(False)
    plt.tight_layout()
    plt.show()


def ex1_4_4():
    category_colors = ["tab:olive","tab:purple",
    "tab:blue","tab:cyan", "tab:brown","tab:orange"]
    fig, ax = plt.subplots(2,1,figsize=(13, 7))
    
    ax[0].set_title("CSP des hommes en fonction de la CSP de leur père")
    for nom,données in do.resultsHomme.items():
        add=0
        for i in range(len(données)):
            a=ax[0].barh(y=nom, width = données[i],color= category_colors[i], left= add, height = 0.5)
            ax[0].bar_label(a, label_type='center')
            add+=données[i]
    
    
    ax[1].set_title("CSP des femmes en fonction de la CSP de leur père")
    for nom,données in do.resultsFemme.items():
        add=0
        for i in range(len(données)):
            a=ax[1].barh(y=nom, width = données[i],color= category_colors[i], left= add, height = 0.5)
            ax[1].bar_label(a, label_type='center')
            add+=données[i]


    ax[0].legend([do.category_names[0],do.category_names[1],do.category_names[2],do.category_names[3],do.category_names[4],do.category_names[5]],loc='center left', bbox_to_anchor=(1, 0.5))
    ax[0].xaxis.set_visible(False)
    ax[1].xaxis.set_visible(False)
    plt.tight_layout()
    plt.show()

def main():
    #ex1_4_1()
    #ex1_4_2()
    #ex1_4_3()
    ex1_4_4()

if __name__ == '__main__':
    main()