def degres(P):
    return len(P)-1
def somme(P,Q):
    s=[]
    for i in range (len(P)):
        s.append("")
        s[i]=P[i]+Q[i]
    return s
def produit(P,Q):
    s=[]
    for i in range (len(P)):
        s.append("")
        s[i]=P[i]*Q[i]
    return s
def affiche(P):
    for i in range (len(P)):
        print("+",P[i],"x^",i,sep='',end='')


print(degres([1,1,1,1]))
print(somme([1,1,1,1],[5,4,3,7]))
print(produit([2,2,2,2],[5,4,3,7]))
affiche([12,3,4,2])