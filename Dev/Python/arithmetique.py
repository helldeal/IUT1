from math import *
def ari7a(a,b):
    z = 0
    i = 0
    while z<=a:
        i=i+1
        z=b*i
    return i-1,-(z-a-b)
#test 
print("ar7a:")
print(ari7a(13,3))
print(ari7a(19,5))
print(ari7a(15,5))
print(ari7a(12,4))

def ari7b(a,b):
    z = 0
    y = 0
    i = a
    while b%i!=0 and a%i!=0:
        i=i-1
        z=b/i
        y=a/i
    return i
#test 
print("ar7b:")
print(ari7b(12,8))