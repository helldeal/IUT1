from math import *
def parties(E):
    print("E:",E)
    l=[]
    for i in range (2**len(E)):
        l.append("")

    for i in range (len(E)):
        for y in range (2**(i)):
            l[y+2**(i)]=str(l[y])+' '+str(E[i])
            
  
    return l
    
print("P:",parties([1,2,3]))

#1= 1+1
#2= 1+2+1
#3= 1+3+3+1  >>  {'','1','2','1-2','3','1-3','2-3','1-2-3'}
#4= 1+4+6+4+1
#5= 1+5+10+10+5+1

