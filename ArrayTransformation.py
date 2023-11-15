'''
A crew of N players played a game for one time, and got some scores.
They have to stand in the same positions after they played the game.
 
There is a constraint that, the player-K score, should not be greater or smaller than both of his neighbors.
To achieve this constraint, there are few steps to be followed as mentioned:
    	- If the score of player-K is smaller than both his neighbors,then his score is incremented by 1.
    	- If the score of player-K is greater than both his neighbors,then his score is decremented by 1. 
    	- The first and last elements never change.
    	Repeat these steps, until the constraint is satisified.
   
  Your task is to find and print the resultant array of scores, after the constraint is achieved.
   
NOTE: Players are not allowed to swap their positions to achieve the constraint.
  
Input Format:
-------------
Line-1: An integer N, number of players.
Line-2: N space separated integers represemts scores of each player.
  
Output Format:
--------------
Print integer array, the resultant scores.
   
Sample Input-1:
---------------
6
4 3 5 2 6 3
  
Sample Output-1:
----------------
[4, 4, 4, 4, 4, 3]

Explanation: 
------------------
Initially, the scores are changed from [4, 3, 5, 2, 6, 3] to [4, 4, 4, 3, 5, 3].
Next step, the scores are changed from [4, 4, 4, 3, 5, 3] to [4, 4, 4, 4, 4, 3].
No more operations can be done to this array.
   

Sample Input-2:
---------------
8
5 1 4 2 7 4 6 3
  
Sample Output-2:
----------------
[5, 3, 3, 3, 5, 5, 5, 3]


Sample Input-3:
---------------
10
48 71 26 73 53 98 1 68 50 18

Sample Output-3:
----------------
[48, 48, 49, 63, 63, 63, 50, 50, 50, 18]



Write your python code below
'''
n = int(input())
arr = list(map(int,input().split()))
flag = True
while(flag):
    ans = []
    ans.append(arr[0])
    for i in range(1,len(arr)-1):
        if(arr[i]<arr[i+1] and arr[i]<arr[i-1]):
            ans.append(arr[i]+1)
            flag = False
        elif(arr[i]>arr[i+1] and arr[i]>arr[i-1]):
            ans.append(arr[i]-1)
            flag = False
        else:
            ans.append(arr[i])
    ans.append(arr[-1])
    arr = ans
    if(flag == True): break
    else: flag = True
print(arr)

