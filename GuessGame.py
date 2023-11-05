'''
Ramesh and Suresh are playing a game.
Initially, Ramesh has a secret number, and Suresh has to guess that number.
Ramesh now checks, How many digits of the guess number match 
the secret number exactly, if both the digit and position are matched, 
indicate them as Apples. If the digit is matched and position is different, 
indicate them as Bananas.

Ramesh will give a hint to Suresh as follows:
e.g., secret number= 1231, and guess number = 4213
Only digit=2 is matching, so apple is 1, banana is 2
Ramesh tell the answer as 1A2B

You are given secrect number and guess number as strings,
Your task to help Ramesh, to find and return the HINT.

NOTE: The length of the both secrect and guess number is same, 
		contains only digits.

Input Format:
-------------
Two strings, secret and guess

Output Format:
--------------
Print the string, the HINT.


Sample Input-1:
---------------
1807 7810

Sample Output-1:
----------------
1A3B

Explanation: 
------------
1 Apple and 3 Banana. Apple is 8, Banana are 0, 1 and 7.


Sample Input-2:
---------------
1123 0111

Sample Output-2:
----------------
1A1B

Explanation: 
------------
The 1st 1 in Suresh guess is an Apple, the 2nd or 3rd 1 is B.



Write your python code below
'''
s, g = input().split()
a = 0
b = 0
count_s = {}
count_g = {}
for i, j in zip(s, g):
    if i == j:
        a += 1
    else:
        count_s[i] = count_s.get(i, 0) + 1
        count_g[j] = count_g.get(j, 0) + 1

for digit in count_s:
    if digit in count_g:
        b += min(count_s[digit], count_g[digit])

print(f"{a}A{b}B")

'''s,g=input().split()
a=0
b=0
for i in range(len(s)):
    if(s[i]==g[i]):
        a+=1
        s = s[:i]+"_"+s[i+1:]
        g = g[:i]+"-"+g[i+1:]
hm= dict()
for i in s:
    if(i!="_"):
        for j in range(len(g)):
            if(g[j]==i):
                b+=1
                g = g[:j]+"-"+g[j+1:]
                break

            
print(f"{a}A{b}B")'''