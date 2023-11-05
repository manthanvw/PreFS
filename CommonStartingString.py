'''
Mr Sayyad is given a list of words. Mr Sayyad observed a similarity among 
the list of words, there exists a common subword in every word in the list, 
from the index-0 (from the beginning of the word). 

Your task is to find out the common subword which is largest.

Input Format:
-------------
Single line space separated integers, the list[].

Output Format:
--------------
Print the string, the largest common word.


Sample Input-1:
---------------
money monkey monday

Sample Output-1:
----------------
mon


Sample Input-2:
---------------
corn cook book clock

Sample Output-2:
----------------
""  //empty string
'''


l = input().split()
s = ""
least = l[0]
k = 0
l.sort()

for i in l[0]:
    if(i == l[-1][k]):
        s+=i
        k+=1
    else: break
        
print(s)

