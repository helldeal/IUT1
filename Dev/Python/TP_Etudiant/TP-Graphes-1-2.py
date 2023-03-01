#!/usr/bin/env python
# coding: utf-8

# # Présentation du TP
# 
# Dans ce TP, l'objectif est d'implémenter les opérations simples sur les graphes orientés. 
# La représentation choisie pour les graphes est une matrice d'adjacence, qui sera représentée par un tableau de tableau (les noms des sommets sont des entiers et seront numérotés en commençant à 0). Nous considérons que le nombre de sommets du graphe ne pourra pas être modifié une fois le graphe construit.

# 
# ## Installation de graphviz pour pouvoir visualiser les graphes

# In[ ]:


get_ipython().system('pip install graphviz')
import graphviz
graphviz.__version__, graphviz.version()


# ## Création d'une fonction de conversion d'un graphe, défini par une matrice d'adjacence, vers le format graphviz

# In[ ]:


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

# In[ ]:


graphe1 = [[0,1,1],
          [1,0,1],
          [1,0,0]]


# #### Affichage de la matrice

# In[ ]:


print(graphe1)


# #### Création du graphe associé, au format graphviz, pour pouvoir faire l'affichage de la représentation sagittale du graphe

# In[ ]:


gdot1 = creation_graphe_graphviz(graphe1)
#print(gdot1.source)


# #### Affichage de la représentation sagittale du graphe

# In[ ]:


gdot1


# 
# 
# # Définition des premières fonctions pour manipuler les graphes

# #### Fonction qui construit un graphe vide (sans arcs), avec le nombre de sommets donné, et qui retourne la matrice d'adjacence correspondante

# In[ ]:


def graphe_vide(n):
    g = []
    for i in range(n):
        l = []
        for j in range(n):
            l.append(0)
        g.append(l)
    return g


# In[ ]:


# test de la fonction graphe_vide
graphe2 = graphe_vide(5)
print(graphe2)
gdot2 = creation_graphe_graphviz(graphe2)
gdot2


# ### Fonction qui retourne vrai si l'arc, dont les numéros de sommets extrémités sont donnés, existe

# In[ ]:


def est_arc(g, i, j):
    #todo


# In[ ]:


# test de la fonction est_arc
print(est_arc(graphe1, 0, 0))
print(est_arc(graphe1, 0, 1))


# 
# #### Fonction qui ajoute un arc au graphe, s'il n'est pas déjà présent

# In[ ]:


def ajoute_arc(g, i, j):
    #todo


# In[ ]:


# test de la fonction ajoute_arc
ajoute_arc(graphe1, 0, 0)
gdot1 = creation_graphe_graphviz(graphe1)
gdot1


# In[ ]:


# test de la fonction ajoute_arc
ajoute_arc(graphe1, 0, 1)
gdot1 = creation_graphe_graphviz(graphe1)
gdot1


# #### Fonction qui ote un arc du graphe, s'il était déjà présent

# In[ ]:


def ote_arc(g, i, j):
    #todo


# In[ ]:


# test de la fonction ote_arc
ote_arc(graphe1, 0, 0)
gdot1 = creation_graphe_graphviz(graphe1)
gdot1


# In[ ]:


# test de la fonction ote_arc
ote_arc(graphe1, 1, 1)
gdot1 = creation_graphe_graphviz(graphe1)
gdot1


# #### Fonction qui retourne le nombre de sommets du graphe

# In[ ]:


def nb_sommets(g):
    #todo


# In[ ]:


# test de la fonction nb_sommets
n = nb_sommets(graphe1)
print("Nombre de sommets :", n)


# #### Fonction qui indique si un graphe est simple

# In[ ]:


def est_simple(g):
    #todo


# In[ ]:


# test de la fonction est_simple
print("Graphe simple ?", est_simple(graphe1))


# #### Fonction qui indique si un graphe est complet

# In[ ]:


def est_complet(g):
    #todo


# In[ ]:


# test de la fonction est_complet
print("Graphe complet ?", est_complet(graphe1))


# #### Fonction qui indique si un graphe est symétrique

# In[ ]:


def est_symetrique(g):
    #todo


# In[ ]:


# test de la fonction est_symetrique
print("Graphe symétrique ?", est_symetrique(graphe1))


# #### Fonction qui retourne le degré entrant du sommet donné

# In[ ]:


def degre_entrant(g, s):
    #todo


# In[ ]:


# test de la fonction degre_entrant
print("degré entrant du sommet 0 :", degre_entrant(graphe1,0))
print("degré entrant du sommet 1 :", degre_entrant(graphe1,1))
print("degré entrant du sommet 2 :", degre_entrant(graphe1,2))


# #### Fonction qui retourne le degré sortant du sommet donné

# In[ ]:


def degre_sortant(g, s):
    #todo


# In[ ]:


# test de la fonction degre_sortant
print("degré sortant du sommet 0 :", degre_sortant(graphe1,0))
print("degré sortant du sommet 1 :", degre_sortant(graphe1,1))
print("degré sortant du sommet 2 :", degre_sortant(graphe1,2))


# #### Fonction qui retourne le degré total du sommet donné

# In[ ]:


def degre_total(g, s):
    #todo


# In[ ]:


# test de la fonction degre_total
print("degré total du sommet 0 :", degre_total(graphe1,0))
print("degré total du sommet 1 :", degre_total(graphe1,1))
print("degré total du sommet 2 :", degre_total(graphe1,2))


# #### Fonction qui retourne les degrés entrants des sommets du graphe, sous la forme d'un tableau

# In[ ]:


def degres_entrants(g):
    #todo


# In[ ]:


# test de la fonction degres_entrants
print(degres_entrants(graphe1))


# #### Fonction qui retourne les degrés sortants des sommets du graphe, sous la forme d'un tableau

# In[ ]:


def degres_sortants(g):
    #todo


# In[ ]:


# test de la fonction degres_sortants
print(degres_sortants(graphe1))


# #### Fonction qui retourne les degrés totaux des sommets du graphe, sous la forme d'un tableau

# In[ ]:


def degres_totaux(g):
    #todo


# In[ ]:


# test de la fonction degres_totaux
print(degres_totaux(graphe1))


# #### Fonction qui retourne un tableau contenant les noms des sommets successeurs du sommet donné

# In[ ]:


def successeurs(g,s):
    #todo


# In[ ]:


# test de la fonction successeurs
print("Successeurs du sommet 0 :", successeurs(graphe1,0))
print("Successeurs du sommet 1 :", successeurs(graphe1,1))
print("Successeurs du sommet 2 :", successeurs(graphe1,2))


# #### Fonction qui retourne un tableau contenant les noms des sommets prédécesseurs du sommet donné

# In[ ]:


def predecesseurs(g,s):
    #todo


# In[ ]:


# test de la fonction predecesseurs
print("Prédécesseurs du sommet 0 :", predecesseurs(graphe1,0))
print("Prédécesseurs du sommet 1 :", predecesseurs(graphe1,1))
print("Prédécesseurs du sommet 2 :", predecesseurs(graphe1,2))


# #### Fonction qui retourne la matrice d'adjacence correspondant au graphe réciproque du graphe donné

# In[ ]:


def graphe_reciproque(g):
    #todo


# In[ ]:


# test de la fonction graphe_reciproque
graphe1_rec = graphe_reciproque(graphe1)
#print(graphe1_rec)
gdot1_rec = creation_graphe_graphviz(graphe1_rec)
gdot1_rec


# #### Fonction qui retourne la matrice d'adjacence correspondant au graphe complémentaire du graphe donné

# In[ ]:


def graphe_complementaire(g):
    #todo


# In[ ]:


# test de la fonction graphe_complementaire
graphe1_comp = graphe_complementaire(graphe1)
#print(graphe1_rec)
gdot1_comp = creation_graphe_graphviz(graphe1_comp)
gdot1_comp


# #### Fonction qui retourne la matrice d'adjacence correspondant au graphe symétrique du graphe donné

# In[ ]:


def graphe_symetrique(g):
    #todo


# In[ ]:


# test de la fonction graphe_symetrique
graphe1_sym = graphe_symetrique(graphe1)
#print(graphe1_rec)
gdot1_sym = creation_graphe_graphviz(graphe1_sym)
gdot1_sym


# #### Fonction qui indique si la liste des sommets donnés correspond à un chemin, dans le graphe donné

# In[ ]:


def est_chemin(g, ls):
    #todo


# In[ ]:


# test de la fonction est_chemin
print("Chemin [] ?", est_chemin(graphe1,[]))
print("Chemin [1] ?", est_chemin(graphe1,[1]))
print("Chemin [0, 1] ?", est_chemin(graphe1,[0,1]))
print("Chemin [0, 1, 2] ?", est_chemin(graphe1,[0,1,2]))
print("Chemin [0, 2, 1] ?", est_chemin(graphe1,[0,2,1]))
print("Chemin [0, 1, 2, 2] ?", est_chemin(graphe1,[0,1,2,2]))


# #### Fonction qui indique si la liste des sommets donnés correspond à un circuit, dans le graphe donné

# In[ ]:


def est_circuit(g, ls):
    #todo


# In[ ]:


# test de la fonction est_circuit
print("Circuit [] ?", est_circuit(graphe1,[]))
print("Circuit [1] ?", est_circuit(graphe1,[1]))
print("Circuit [0, 1] ?", est_circuit(graphe1,[0,1]))
print("Circuit [0, 1, 2, 0] ?", est_circuit(graphe1,[0,1,2,0]))
print("Circuit [0, 2, 1, 0] ?", est_circuit(graphe1,[0,2,1,0]))
print("Circuit [0, 1, 2, 2] ?", est_circuit(graphe1,[0,1,2,2]))


# #### Fonction qui indique si la liste des sommets donnés correspond à un chemin élémentaire, dans le graphe donné

# In[ ]:


def est_chemin_elementaire(g, ls):
    #todo


# In[ ]:


# test de la fonction est_chemin_elementaire


# #### Fonction qui indique si la liste des sommets donnés correspond à un chemin simple, dans le graphe donné

# In[ ]:


def est_chemin_simple(g, ls):
    #todo


# In[ ]:


# test de la fonction est_chemin_simple


# #### Fonction qui indique si la liste des sommets donnés correspond à un circuit élémentaire, dans le graphe donné

# In[ ]:


def est_circuit_elementaire(g, ls):
    #todo


# In[ ]:


# test de la fonction est_circuit_elementaire


# #### Fonction qui indique si la liste des sommets donnés correspond à un circuit simple, dans le graphe donné

# In[ ]:


def est_circuit_simple(g, ls):
    #todo


# In[ ]:


#test de la fonction est_circuit_simple


# #### Fonction qui retourne vrai si le sommet donné est une source

# In[ ]:


def est_source(g, s):
    #todo


# In[ ]:


# test de la fonction est_source


# #### Fonction qui retourne vrai si le sommet donné est un puits

# In[ ]:


def est_puits(g, s):
    #todo


# In[ ]:


# test de la fonction est_puits


# #### Fonction qui retourne la représentation du graphe par liste des successeurs (sous forme de liste de listes)

# In[ ]:


def liste_successeurs(g):
    #todo


# In[ ]:


# test de la fonction liste_successeurs


# #### Fonction qui retourne vrai si le graphe g2 est un sous-graphe du graphe g1 (g1 et g2 ont le même nombre de sommets)

# In[ ]:


def est_sous_graphe(g1, g2):
    #todo


# In[ ]:


# test de la fonction est_sous_graphe


# #### Fonction qui retourne le sous-graphe induit par la liste de sommets donnée (le sous-graphe n'aura plus la même numérotation des sommets, s'il en a moins que g)

# In[ ]:


def sous_graphe(g, ls):
    #todo


# In[ ]:


# test de la fonction sous_graphe

