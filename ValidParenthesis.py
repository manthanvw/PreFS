'''
Clavius, the person who suggested grouping of data using brackets.
He has suggested that the grouping should be well formed.
Well formed groupings are as follows, (), [], {}, {()}, {[]()}, {[]}(), etc.

You will be given a string S, return true if the string S is a well formed 
grouping, otherwise false.

Note: S contains only characters ( ) [ ] { }

Input Format:
-------------
A string S, contains only characters (){}[]

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
{[([])[]]}

Sample Output-1:
----------------
true


Sample Input-2:
---------------
{[([])[]}]

Sample Output-2:
----------------
false



Write your python code below
'''
def isFormed(s):
    l=[]
    for i in s:
        if(len(l)==0): l.append(i)
        else:
            if((i==']' and l[-1] == '[') or 
            (i=='}' and l[-1]=='{') 
            or (i==')' and l[-1]=='(')):
                l.pop()
            else: l.append(i)
    return len(l)==0
s = input()
l = []
print(isFormed(s))
