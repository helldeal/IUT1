#!/usr/bin/env python
# coding: utf-8

# # Présentation du TP sur la coloration
# 
# Dans ce TP, l'objectif est de pouvoir faire de la coloration de graphe, en utilisant l'algorithme de Welsh et Powell. 
# 
# La représentation choisie pour les graphes est une matrice d'adjacence, qui sera représentée par un tableau de tableau (les noms des sommets sont des entiers et seront numérotés en commençant à 0). Nous considérons que le nombre de sommets du graphe ne pourra pas être modifié une fois le graphe construit.
# 

# 
# ## Installation de graphviz pour pouvoir visualiser les graphes
# 

# In[1]:


get_ipython().system('pip install graphviz')
import graphviz
graphviz.__version__, graphviz.version()


# 
# 
# ## Création d'une fonction de conversion d'un graphe, défini par une matrice d'adjacence, vers le format graphviz
# 

# In[16]:


def creation_graphe_graphviz(g):
    # création d'un graphe non orienté
    dot = graphviz.Graph()
    
    # ajout des sommets
    for i in range(len(g)):
        dot.node(str(i))
    
    # ajout des arcs
    for i in range(len(g)):
        for j in range(i):
            if g[i][j] == 1:
                dot.edge(str(i), str(j))
    
    return dot


#  ## Création et affichage d'un premier graphe non orienté

# In[17]:


graphe1 = [[0,1,1],
          [1,0,1],
          [1,1,0]]


# #### Affichage de la matrice

# In[18]:


print(graphe1)


# #### Création du graphe associé, au format graphviz, pour pouvoir faire l'affichage de la représentation sagittale du graphe
# 

# In[21]:


gdot1 = creation_graphe_graphviz(graphe1)
print(gdot1.source)


# #### Affichage de la représentation sagittale du graphe

# In[22]:


gdot1


# ## Création et affichage d'un deuxième graphe non orienté

# In[25]:


graphe2 = [[0,1,1,1,0,0,0],
           [1,0,0,1,0,0,1],
           [1,0,0,1,1,0,0],
           [1,1,1,0,0,0,0],
           [0,0,1,0,0,1,0],
           [0,0,0,0,1,0,0],
           [0,1,0,0,0,0,0]]


# #### Création et affichage du graphe associé, au format graphviz
# 

# In[26]:


gdot2 = creation_graphe_graphviz(graphe2)
print(gdot2.source)
gdot2


# 
# 
# ## Fonction qui donne la coloration des sommets d'un graphe, en utilisant l'algorithme de Welsh-Powell, sous la forme d'une liste.
# 

# In[34]:


def coloration_sommets_welsh_powell(graphe):
    couleurs = []
    #à définir
    return couleurs


# In[38]:


# test de la fonction coloration_sommets_welsh_powell
print("coloration des sommets du graphe 1")
couleurs_sommets_1 = coloration_sommets_welsh_powell(graphe1)
print(couleurs_sommets_1)

print("\ncoloration des sommets du graphe 2")
couleurs_sommets_2 = coloration_sommets_welsh_powell(graphe2)
print(couleurs_sommets_2)


# 
# 
# ## Fonction qui donne la coloration des arêtes d'un graphe, en utilisant l'algorithme de Welsh-Powell, sous la forme d'une liste.
# 
# 

# In[39]:


def coloration_aretes_welsh_powell(graphe):
    couleurs = []
    #à définir
    return couleurs


# In[40]:


# test de la fonction coloration_aretes_welsh_powell
print("coloration des arêtes du graphe 1")
couleurs_aretes_1 = coloration_aretes_welsh_powell(graphe1)
print(couleurs_aretes_1)

print("\ncoloration des arêtes du graphe 2")
couleurs_aretes_2 = coloration_aretes_welsh_powell(graphe2)
print(couleurs_aretes_2)


# 
# ## Bonus 
# Une fois votre algorithme Welsh-Powell implémenté, vous pouvez chercher un moyen d'afficher votre graphe, avec les couleurs mises sur les sommets ou les arêtes, selon la coloration choisie (en utilisant le projet graphviz pour Python : https://pypi.org/project/graphviz/). 
# 
# Vous pouvez également ajouter une méthode permettant de charger un fichier contenant la description de votre graphe, au format utilisé par graphviz (format dot), pour initialiser votre matrice d'adjacence. 
# 
# Vous pouvez enfin tester votre code, en reprenant les exemples du cours et du TD.

# In[ ]:




