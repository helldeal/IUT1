import numpy as np
listX1 = list(np.random.standard_normal(50))
listX2 = listX1 + [18,19,20,30]

L = [18,19,20,30]

def mean(list):
    add=0
    for i in list:
        add+=i
    return add/len(list)
    

print(L,mean(L))

def variance(list):
    add=[]
    for i in range(len(list)):
        add.append(pow(list[i],2))
    return mean(add)-pow(mean(list),2)

print(L,variance(L))

def ecart_type(list):
    return list[len(list)-1]-list[0]

print(L,ecart_type(L))

def median(list):
    if len(list)%2==0:
        return [list[len(list)/2],list[len(list)/2]]
    return

print(L,median(L))