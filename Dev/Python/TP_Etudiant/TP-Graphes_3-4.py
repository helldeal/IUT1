#!/usr/bin/env python
# coding: utf-8

# # Présentation du TP 3-4
# 
# Dans ce TP, l'objectif est d'implémenter les opérations de calcul de composantes fortement connexes ainsi que de fermeture transitive, sur les graphes orientés. 
# 
# La représentation choisie pour les graphes est une matrice d'adjacence, qui sera représentée par un tableau de tableau (les noms des sommets sont des entiers et seront numérotés en commençant à 0). Nous considérons que le nombre de sommets du graphe ne pourra pas être modifié une fois le graphe construit.

# 
# ## Installation de graphviz pour pouvoir visualiser les graphes

# In[1]:


get_ipython().system('pip install graphviz')
import graphviz
graphviz.__version__, graphviz.version()


# ## Création d'une fonction de conversion d'un graphe, défini par une matrice d'adjacence, vers le format graphviz

# In[2]:


def creation_graphe_graphviz(g):
    # création d'un graphe orienté
    dot = graphviz.Digraph()
    
    # ajout des sommets
    for i in range(len(g)):
        dot.node(str(i))
    
    # ajout des arcs
    for i in range(len(g)):
        for j in range(len(g)):
            if g[i][j] == 1:
                dot.edge(str(i), str(j))
    
    return dot


# 
# ## Création et affichage d'un premier graphe orienté
# 

# In[3]:


graphe1 = [[0,1,1],
          [1,0,1],
          [1,0,0]]


# #### Affichage de la matrice

# In[4]:


print(graphe1)


# #### Création du graphe associé, au format graphviz, pour pouvoir faire l'affichage de la représentation sagittale du graphe

# In[5]:


gdot1 = creation_graphe_graphviz(graphe1)
#print(gdot1.source)


# #### Affichage de la représentation sagittale du graphe

# In[6]:


gdot1


# ## Création et affichage d'un deuxième graphe orienté

# In[7]:


graphe2 = [[0,0,1,1,0,0,0],
          [1,0,0,0,0,0,1],
          [0,0,0,0,1,0,0],
          [0,1,1,0,0,0,0],
          [0,0,0,0,0,0,0],
          [0,0,0,0,1,0,0],
          [0,0,0,0,0,0,1]]


# #### Création et affichage du graphe associé, au format graphviz

# In[8]:


gdot2 = creation_graphe_graphviz(graphe2)
#print(gdot2.source)
gdot2


# 
# 
# # Définition des premières fonctions pour manipuler les graphes (fonctions données)
# 

# #### Fonction qui construit un graphe vide (sans arcs), avec le nombre de sommets donné, et qui retourne la matrice d'adjacence correspondante

# In[9]:


def graphe_vide(n):
    g = []
    for i in range(n):
        l = []
        for j in range(n):
            l.append(0)
        g.append(l)
    return g


# #### Fonction qui retourne vrai si l'arc, dont les numéros de sommets extrémités sont donnés, existe

# In[10]:


def est_arc(g, i, j):
    return g[i][j] == 1


# 
# #### Fonction qui ajoute un arc au graphe, s'il n'est pas déjà présent

# In[11]:


def ajoute_arc(g, i, j):
    g[i][j] = 1


# #### Fonction qui ote un arc du graphe, s'il était déjà présent

# In[12]:


def ote_arc(g, i, j):
    g[i][j] = 0


# #### Fonction qui retourne le nombre de sommets du graphe

# In[13]:


def nb_sommets(g):
    return len(g)


# #### Fonction qui retourne un tableau contenant les noms des sommets successeurs du sommet donné

# In[46]:


def successeurs(g,s):
    succs = []
    for i in range(len(g)):
        if g[s][i]==1:
            succs.append(i)
    return succs


# #### Fonction qui retourne un tableau contenant les noms des sommets prédécesseurs du sommet donné

# In[47]:


def predecesseurs(g,s):
    preds = []
    for i in range(len(g)):
        if g[i][s]==1:
            preds.append(i)
    return preds


# # Définition des fonctions à écrire
# 

# #### Fonction qui donne la liste des sommets descendants du sommet d'indice donné

# In[16]:


def liste_descendants(g, s):
    descs = []
    file = []
    
    file.append(s)
    while len(file) > 0:
        scour = file[0]
        file = file[1:]
        succs = successeurs(g, scour)
        for i in range(len(succs)):
            if(succs[i] not in descs):
                file.append(succs[i])
                descs.append(succs[i])
    
    return descs


# In[38]:


# test de la fonction liste_descendants
print("descendants du graphe 1")
print("\tsommet 0 : ", liste_descendants(graphe1, 0))
print("\tsommet 1 : ", liste_descendants(graphe1, 1))
print("\tsommet 2 : ", liste_descendants(graphe1, 2))

print("\ndescendants du graphe 2")
print("\tsommet 0 : ", liste_descendants(graphe2, 0))
print("\tsommet 1 : ", liste_descendants(graphe2, 1))
print("\tsommet 2 : ", liste_descendants(graphe2, 2))
print("\tsommet 3 : ", liste_descendants(graphe2, 3))
print("\tsommet 4 : ", liste_descendants(graphe2, 4))
print("\tsommet 5 : ", liste_descendants(graphe2, 5))
print("\tsommet 6 : ", liste_descendants(graphe2, 6))


# #### Fonction qui donne la liste des sommets ascendants du sommet d'indice donné

# In[18]:


def liste_ascendants(g, s):
    ascs = []
    #todo
    return ascs


# In[39]:


# test de la fonction liste_ascendants
print("ascendants du graphe 1")
print("\tsommet 0 : ", liste_ascendants(graphe1, 0))
print("\tsommet 1 : ", liste_ascendants(graphe1, 1))
print("\tsommet 2 : ", liste_ascendants(graphe1, 2))

print("\nascendants du graphe 2")
print("\tsommet 0 : ", liste_ascendants(graphe2, 0))
print("\tsommet 1 : ", liste_ascendants(graphe2, 1))
print("\tsommet 2 : ", liste_ascendants(graphe2, 2))
print("\tsommet 3 : ", liste_ascendants(graphe2, 3))
print("\tsommet 4 : ", liste_ascendants(graphe2, 4))
print("\tsommet 5 : ", liste_ascendants(graphe2, 5))
print("\tsommet 6 : ", liste_ascendants(graphe2, 6))


# #### Fonction qui donne la composante fortement connexe du sommet s, sous la forme d'une liste de sommets

# In[20]:


def cfc_sommet(g, s):
    cfc = []
    #todo
    return cfc


# In[40]:


# test de la fonction cfc_sommet
print("composantes fortement connexes des sommets du graphe 1")
print("\tsommet 0 : ", cfc_sommet(graphe1, 0))
print("\tsommet 1 : ", cfc_sommet(graphe1, 1))
print("\tsommet 2 : ", cfc_sommet(graphe1, 2))

print("\ncomposantes fortement connexes des sommets du graphe 2")
print("\tsommet 0 : ", cfc_sommet(graphe2, 0))
print("\tsommet 1 : ", cfc_sommet(graphe2, 1))
print("\tsommet 2 : ", cfc_sommet(graphe2, 2))
print("\tsommet 3 : ", cfc_sommet(graphe2, 3))
print("\tsommet 4 : ", cfc_sommet(graphe2, 4))
print("\tsommet 5 : ", cfc_sommet(graphe2, 5))
print("\tsommet 6 : ", cfc_sommet(graphe2, 6))


# #### Fonction qui donne la liste des composantes fortement connexes du graphe, sous la forme d'une liste de listes de sommets

# In[22]:


def cfc_graphe(g):
    lcfc = []
    #todo
    return lcfc


# In[41]:


# test de la fonction cfc_graphe
print("composantes fortement connexes des sommets du graphe 1")
print(cfc_graphe(graphe1))

print("\ncomposantes fortement connexes des sommets du graphe 2")
print(cfc_graphe(graphe2))


# #### Fonction qui retourne vrai si le graphe est fortement connexe

# In[24]:


def est_fortement_connexe(g):
    #todo
    return False


# In[42]:


# test de la fonction est_fortement_connexe
print("graphe 1 fortement connexe ?", est_fortement_connexe(graphe1))

print("\ngraphe 2 fortement connexe ?", est_fortement_connexe(graphe2))


# #### Fonction qui construit le graphe correspondant à la fermeture transitive du graphe en paramètre

# In[26]:


def graphe_fermeture_transitive(g):
    gf = graphe_vide(len(g))
    #todo
    return gf


# In[36]:


# test de la fonction graphe_fermeture_transitive du 1er graphe
print("fermeture transitive du graphe 1")
graphe1_ft = graphe_fermeture_transitive(graphe1)
#print(graphe1_ft)
graphe1_ft = creation_graphe_graphviz(graphe1_ft)
graphe1_ft


# In[37]:


# test de la fonction graphe_fermeture_transitive du 2e graphe
print("fermeture transitive du graphe 2")
graphe2_ft = graphe_fermeture_transitive(graphe2)
#print(graphe2_ft)
graphe2_ft = creation_graphe_graphviz(graphe2_ft)
graphe2_ft


# #### Fonction qui donne la composante connexe du sommet s, sous la forme d'une liste de sommets

# In[28]:


def cc_sommet(g, s):
    cc = []
    #todo
    return cc


# In[43]:


# test de la fonction cc_sommet
print("composantes connexes des sommets du graphe 1")
print("\tsommet 0 : ", cc_sommet(graphe1, 0))
print("\tsommet 1 : ", cc_sommet(graphe1, 1))
print("\tsommet 2 : ", cc_sommet(graphe1, 2))

print("\ncomposantes connexes des sommets du graphe 2")
print("\tsommet 0 : ", cc_sommet(graphe2, 0))
print("\tsommet 1 : ", cc_sommet(graphe2, 1))
print("\tsommet 2 : ", cc_sommet(graphe2, 2))
print("\tsommet 3 : ", cc_sommet(graphe2, 3))
print("\tsommet 4 : ", cc_sommet(graphe2, 4))
print("\tsommet 5 : ", cc_sommet(graphe2, 5))
print("\tsommet 6 : ", cc_sommet(graphe2, 6))


# #### Fonction qui donne la liste des composantes connexes du graphe, sous la forme d'une liste de listes de sommets

# In[30]:


def cc_graphe(g):
    lcc = []
    #todo
    return lcc


# In[44]:


# test de la fonction cc_graphe
print("composantes connexes des sommets du graphe 1")
print(cc_graphe(graphe1))

print("\ncomposantes connexes des sommets du graphe 2")
print(cc_graphe(graphe2))


# #### Fonction qui retourne vrai si le graphe est connexe

# In[32]:


def est_connexe(g):
    #todo
    return False


# In[45]:


# test de la fonction est_connexe
print("graphe 1 connexe ?", est_connexe(graphe1))

print("\ngraphe 2 connexe ?", est_connexe(graphe2))


# In[ ]:




