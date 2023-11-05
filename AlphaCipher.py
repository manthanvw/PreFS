'''
AlphaCipher is a string formed from another by rearranging its letters

You are given two strings A and B,
Print true, if B is an AlphaCipher of A,
Otherwise false

Input Format:
-------------
Two space separated strings, A and B

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
dormitory dirtyroom

Sample Output-1:
----------------
true


Sample Input-2:
---------------
listen silent

Sample Output-2:
----------------
true


Sample Input-3:
---------------
car rat

Sample Output-3:
----------------
false


=== Write your python code below ===

'''

def isAC(w1,w2):
    d1 = dict()
    if(len(w1) != len(w2)): return False
    for i in w1:
        d1[i] = 0
    for i in w1:
        d1[i]+=1
    for i in w2:
        if(i in d1.keys()):
            d1[i]-=1
        
    for i in d1.values():
        if(i!=0): return False
        
    
    return True
    
    
    

w1,w2 = input().split()
print(isAC(w1,w2))
