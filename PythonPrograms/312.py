from random import random

D = {
	"123":0,
	"132":0,
	"321":0,
	"231":0,
	"312":0,
	"213":0,
	}       
                
def shuffle(B):
	nb = len(B)
	num = ""
	for i in range(nb):
		r = int(random()*N)
		B[i],B[r] = B[r],B[i]
	for i in range(nb):
		num = num + str(B[i])
                                
	if(num == "123"):
		D["123"] +=1
                       
	if(num == "132"):
		D["132"] +=1
                               
	if(num == "321"):
		D["321"] +=1
                                
	if(num == "231"):
		D["231"] +=1
                                
	if(num == "312"):
		D["312"] +=1
                                
	if(num == "213"):
		D["213"] +=1		
                                
N = 3
for i in range(60000):
	B = [b for b in range(1 , N+1)]
	shuffle(B)
	print("B->\n",B)
                   
	print(D)
