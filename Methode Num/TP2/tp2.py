#Exercice 2.1:  Dichotomie 

#1 :

#2 :
import numpy as np
import matplotlib.pyplot as plt

def fonction(x):
    return x*np.tan(x)-1


def dichotomie(a,b,e):
    it=0
    while abs(b-a)>e:
        it+=1
        m=(a+b)/2
        if (fonction(a)*fonction(m)>0):
            a=m
        else:
            b=m
        print(a,b,"itération n°",it)
    return b
        


#3
# x=np.linspace(-np.pi, np.pi)
# plt.plot(x, fonction(x)) 
# plt.show() 
#dichotomie(0, np.pi, 0.00000001)

#Exercice 2.3 : Méthode de Newton
def f(x):
    return x**2-2
def df(x):  
    return 2*x


def Newton(x0, N):
    for i in range(N):
        x0=x0-(f(x0)/df(x0))
    return x0

def VitesseNewton():
    y=[]
    for i in range(10):
        y.append(Newton(1, i)) 
    x=np.arange(len(y))
    plt.plot(x, y) 
    plt.show() 

# x=np.linspace(-2, 4)
# plt.plot(x, f(x)) 
# plt.show() 

#print(Newton(10, 10))

#VitesseNewton()

def Secante(x0,x1,N):
    for i in range(N):
        t1=(f(x1)-f(x0))/(x1-x0)
        x0=x1-(f(x1)/t1)
    return x0

def VitesseSecante():
    y=[]
    for i in range(10):
        y.append(Secante(0,2, i)) 
    x=np.arange(len(y))
    plt.plot(x,y)
    plt.show()

print(Secante(0,2,10))
print(Newton(10, 10))