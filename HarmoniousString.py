'''
In the context of linguistic harmony, we define a "harmonious string" as a string where every alphabet it 
contains appears both in uppercase and lowercase forms. 
For instance, a string like "pqQpP" is harmonious because it has both 'P' and 'p' as well as 'Q' and 'q'.
Conversely, a string like "pqP" is not harmonious as it fails to meet this condition
, with 'q' present while 'Q' is absent.

Your are given a string S, your task is  to return the longest harmonious substring in S. 
If there are multiple answers meeting this criterion, you should return the one that appears 
earliest in the string. If there is no harmonious substring, you should return an empty string.

Input Format:
-------------------
A string S

Output Format:
-------------------
Prin the longest harmonious string.


Sample Input:
--------------
QcvcCcq

Sample Output:
---------------
cCc


Sample Input:
--------------
pqrs

Sample Output:
--------------
""

Write your python code below.
'''
'''
Test cases not passed.
'''
s = input()
ans = ""
l = list()
for i in range(len(s)):
    if(s[i].isupper()):
        if(s[i].lower() in s[i+1:] or s[i].lower() in ans):
            ans+=s[i]
        else:
            l.append(ans)
            ans = ""
    elif(s[i].islower()):
        if(s[i].upper() in s[i+1:] or s[i].upper() in ans):
            ans+=s[i]
        else:
            l.append(ans)
            ans = ""
if(len(ans)>0): l.append(ans)
maxLen = 1
final = ""
for i in l:
    if(len(i)>maxLen):
        maxLen = len(i)
        final = i
print(final,end="")
    
    
    
    