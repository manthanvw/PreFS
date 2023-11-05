'''
You are given a set of positive numbers s[].
A variable 'count' stores the count of maximum repeated number/numbers in the set s[]. 

Your task is to find all continuous subsets of numbers from the given set which should have same 'count' value as original set and print the size of the subset which is minimum.

Input Format:
-------------
Line-1: An integer N represents size of the set s[].
Line-2: N space separated positive integers.
 
Output Format:
--------------
Print an integer.
 
Constraints:
 1 <= N <= 50000
 0<= s[i] <= 49999

 
Sample Input-1:
---------------
5
3 2 3 4 5

 
Sample Output-1:
----------------
3

Explanation:
------------
Maximum repeated number is 3  and the count=2.
The continuous subsets with the same count are [3 2 3 4 5],[3 2 3 4], [3 2 3].
the least size is 3 with subset[3 2 3].
 
Sample Input-2:
---------------
5
5 6 6 7 5

Sample Output-2:
----------------
2

Explanation:
------------
Maximum repeated numbers are 5 and 6  and the count=2.
The continuous subsets with the same count are [5 6 6 7 5],
[5 6 6 7], [6 6 7 5],[5 6 6] [6 6 7] [6 6].
The least size is 2 with subset[6 6].


=== Write your python code below ===

'''

import math
size = int(input())
l = list(map(int,input().split()))
d = list()
firstC = dict()
oc = dict()
res = math.inf
maxCount = 0
for i in l:
    maxCount = max(maxCount,l.count(i))
for i in set(l):
    firstC[i] = l.index(i)
    oc[i] = 0
for i in range(len(l)):
    oc[l[i]] = oc[l[i]]+1
    if(oc[l[i]]==maxCount): res=min(res,i-firstC[l[i]]+1)
print(res)