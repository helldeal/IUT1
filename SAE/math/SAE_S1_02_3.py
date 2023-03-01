import random
import time
import numpy as np
from tqdm import tqdm
def reste(a,b):
    x=b
    while (a-b)>=x:
        x=x+b
    return a-x

#=======================================================================

def divisible(a,b):
    if reste(a,b)==0:
        return True 
    return False

#=======================================================================

def diviseurs(a):
    l=[]
    for i in range(1,int(a/2)):
        if divisible(a,i):
            l.append(i)

    return l

#=======================================================================

def list_prime(n):
    l=[]
    for i in range(100,n):
        if len(diviseurs(i))==1:
            l.append(i)
    return l


#=======================================================================
        
def pgcd(a,b):
    if b==0:
        return a
    else:
        r=a%b
        return pgcd(b,r)
#=======================================================================				
def extended_gcd(a,b):
  #algorithme d'euclide
    if a == 0:
        return (b, 0, 1)
    else:
        d, u, v = extended_gcd(b % a, a)
        return (d, v - (b // a) * u, u)
        
#======================================================================

def key_creation():
    #décaration de p et q, 2 nombre premiers entre 100 et 1000
    l=list_prime(1000)
    p=random.choice(l)
    q=random.choice(l)
    while p==q:
      q=random.choice(l)
    #le module de chiffrement n 
    n=p*q

    #valeur de l’indicatrice d’Euler en n
    Pn=(p-1)*(q-1)

    #calcul de la clé publique
    e=random.choice(l)
    while pgcd(Pn,e)!=1:
        e=random.choice(l)

    #calcul de la clé privée
    _,d,_=extended_gcd(e,Pn)
    while d<0:
      d+=Pn

    print("\nclé publique : (",n,e,") \n\nclé privée :",d)
    return n,e,d
    
#=======================================================================

def convert_msg(M):
    #convertion de chaques caractères en ASCII
    asci = []
    for lettre in M:
        asci.append(str(ord(lettre)))

        #certains caractères sont codés sur + de 3 digits en ASCII il faut donc les refuser
        if len(str(ord(lettre)))>3:
          raise TypeError("Le caractère %s n'est pas valide" % lettre)
    return asci

#=======================================================================
  
def encryption(n,pub,msg):
    print("\n\n\nEnvoi :")

    #convertion du msg en ASCII + ajustement de chaque code pour 3 digits
    msg=convert_msg(msg)
    for i in range(len (msg)):
        while len(str(msg[i]))<3:
            msg[i]="0"+str(msg[i])
    print("\nListe en ASCII :",msg)

    #transformation de la liste en un seul nombre
    msgconca="".join(msg)
    print("\nmessage concatené :",msgconca)

    
    #création d'une liste avec le nombre diviser en plusieurs blocs de 4 digits
    while len(msgconca)%4 != 0:
	    msgconca = msgconca + '0'
    index=0
    bloc=['']
    for i in msgconca:
      if len(bloc[index])>=4:
        bloc.append(i)
        index+=1
      else:
        bloc[index]+=i
    print("\nmessage en bloc :",bloc)

    #cryptage de la nouvelle liste
    for i in range (len(bloc)):
      bloc[i]=int(bloc[i])**pub%n
    print("\nmessage crypté :",bloc)
    bloc=binaire(bloc)
    return bloc

#=======================================================================

def decryption(n,priv,msg):
    print("\n\n\nRéception :")

    print("\nmessage reçu :",msg)
    msg=decimal(msg)

    #décryptage de la liste
    print("\n")
    for i in tqdm(range (len(msg)),desc = 'Décryptage'):
      msg[i]=str(msg[i]**priv%n)  

    #on rajoute les 0 en debut de blocs pour refaire des blocs de 4
    for i, s in enumerate(msg):
        if len(s) < 4:
          while len(s) < 4:
            s = '0' + s
          msg[i] = s
    print("\nmessage en bloc décodé :",msg)

    
    #transformation de la liste décryptée en un seul nombre
    msgdecry="".join(msg)
    print("\nmessage concatené décodé :",msgdecry)

    #création d'une liste avec le nombre diviser en plusieurs blocs de 3 digits afin de pouvoir les retraduire en ASCII
    bloc=['']
    index=0
    for i in msgdecry:
      if len(bloc[index])>=3:
        bloc.append(i)
        index+=1
      else:
        bloc[index]+=i
    #On enlevève les élèments nuls résidus de la mise en blocs
    if int(bloc[len(bloc)-1])==0:
      bloc.pop(len(bloc)-1)
    print("\nListe en ASCII décodée :",bloc)

    #convertion depuis l'ASCII pour obtenir des caractères
    mot=''
    for i in range(len(bloc)):
      bloc[i]=chr(int(bloc[i]))
      mot=mot+bloc[i]
    return mot

#=======================================================================

def noise(vect_msg):

  #prend un vecteur vect_msg et renvoie ce vecteur potentiellement bruite

  #on fait une copie du vecteur initial
  vect = vect_msg.copy()
  #une chance sur quatre de ne pas bruiter le vecteur
  test = np.random.randint(0,4)
  if test>0:
    index = np.random.randint(0,np.size(vect))
    vect[index] = (vect[index] +1)%2
  return vect

#=======================================================================

def binaire(msg):
  for i in range(len(msg)):
    msg[i]=format(msg[i], "b")
    for y, s in enumerate(msg[i]):
      while len(msg[i])%7 != 0:
          msg[i]='0'+msg[i]
      
  print("\nmessage crypté en binaire :",msg)
  return msg

#=======================================================================

def decimal(msg):
  for i in range(len(msg)):
    msg[i]=int(msg[i],2)
  print("\nmessage reçu en décimal :",msg)
  return msg

#=======================================================================$

M=input("Message: ")
start_time = time.time()
n,pub,priv=key_creation()
msgcry=encryption(n,pub,M)
msgdecry=decryption(n,priv,msgcry)

print("\nMessage décodé :",msgdecry)
if msgdecry==M:
  print("\nMessage transmis avec succès !")
else :
  print("\nErreur de transmission")

print("\nProgramme terminé --- %s secondes ---" % (time.time() - start_time))
