from math import *

def reste(a,b):
    x=b
    while (a-b)>=x:
        x=x+b
    return a-x

print(reste(10,3)==1)
print(reste(12,4)==0)
print(reste(10,14)==-4)


def divisible(a,b):
    if reste(a,b)==0:
        return True 
    return False

print(divisible(10,3)==False)
print(divisible(12,4)==True)
print(divisible(10,14)==False)  

def diviseurs(a):
    l=[]
    for i in range(1,int(a/2)):
        if divisible(a,i):
            l.append(i)

    return l

print(diviseurs(100))
print(diviseurs(7))
print(diviseurs(24))

def premier(a):
    if len(diviseurs(a))==1:
        return True
    return False

print(premier(100)==False)   
print(premier(7)==True)
print(premier(24)==False)  

def tous_les_premiers(a):
    l=[]
    for i in range(1,a,2):
        if premier(i):
            l.append(i)
    return l        

print(tous_les_premiers(10))   