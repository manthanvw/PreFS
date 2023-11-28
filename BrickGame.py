'''
Mr Ibrahim and Kumar are playing a game of luck. 
There is a treasure in front of them, the treasure is on top of N bricks,
in order to win the treasure, the rules are as follows:
    - Each turn, the player remove K bricks from the bottom.
    - where K is, 0 < K < N.
    - and N should be perfectly divisible by K.

The player who cannot remove any more bricks, is called unlucky and the other
player wins the treasure. It is said that Ibrahim will start the game always.
Your task is to print 'true' if Ibrahim wins the treasure, otherwise 'false'.


Input Format:
-------------
An integer N, number of bricks.

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
3

Sample Output-1:
----------------
false

Explanation:
------------
Ibrahim removes 1 brick, Kumar removes 1 brick, 
Now, Ibrahim cannot remove any more brick.


Sample Input-2:
---------------
2

Sample Output-2:
----------------
true

Explanation: 
------------
Ibrahim removes 1 brick, Kumar cannot removes the brick.



Write your python code below
'''
def isWin(n):
    count =0
    t = n
    while(t>1):
        count+=1
        ans = 0
        for i in range(1,n):
            if((n%i == 0) and (i<=t)):
                ans = i
        t-=ans
        print(t)
    return (count%2 ==0)
def Winning(n):
    return n%2==0
n = int(input())
print(Winning(n))