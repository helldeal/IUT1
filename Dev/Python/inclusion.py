from math import *
def membre(a,B):
    for i in B : 
        if a==i:
            return True
    return False


def inclusion(A,B):
    for i in A :
        if not(membre(i,B)):
            return False
    return True

def egal(A,B):
    return inclusion(A,B) and inclusion(B,A)
        
    
A={1,2}
B={1,2,3}
print(A,B,inclusion(A,B))
print(A,B,egal(A,B))