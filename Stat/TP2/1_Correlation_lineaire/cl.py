
import csv as csv
from unicodedata import decimal
import matplotlib.pyplot as plt


def csvopen(A):
    with open(A, newline='') as csvfile:
        data = csv.reader(csvfile, delimiter=',')
        Liste=[]
        for row in data:
            Liste.append(list(row))
        for i in range(1,len(Liste)):
            Liste[i] = [float(s.replace(',','.')) for s in Liste[i]] 

        Lx=[]
        Ly=[]
        for i in range(1,len(Liste)):
            Lx.append(Liste[i][0])
            Ly.append(Liste[i][1])
    return Lx,Ly

def point_moyen(X,Y):
    moyX=sum(X)/len(X)
    moyY=sum(Y)/len(Y)
    return moyX,moyY
    
def coeff_corr(X,Y):
    add=0
    for i in range(len(X)):
        add+=X[i]*Y[i]
    add=add/len(X)
    mX,mY=point_moyen(X,Y)
    return add-mX*mY

def coeffs_droite_reg(X,Y):   
    mX,mY=point_moyen(X,Y)
    a=coeff_corr(X,Y)/coeff_corr(X,X)
    b=mY-(coeff_corr(X,Y)/coeff_corr(X,X)*mX)
    
    return a,b

def etude(X,Y):
    ig, ax = plt.subplots()
    mX,mY=point_moyen(X,Y)
    ax.scatter(X, Y,color='blue',label='données')
    ax.scatter(mX, mY,color='Orange',label='point moyen')
    a,b=coeffs_droite_reg(X,Y)
    correc=[]
    for i in X:
        correc.append(a*i+b)
    ax.plot(X, correc,color='Orange',label='droite de régression linéaire')
    ax.set_title(f"coefficient de corrélation : {coeff_corr(X,Y)}")
    plt.legend()
    plt.show()

def main():
    Lx,Ly=csvopen("ExBsetB.csv")
    L2x,L2y=csvopen("ExBsetA.csv")
    Lx+=L2x
    Ly+=L2y
    etude(Lx,Ly)

if __name__ == '__main__':
    main()