'''
Arjun wants to build a swimming pool, in the backyard of his farm-house.
The backyard has an empty land of size m*n. 
Some part of the backyard is used to build the swimming pool
You will be given the m*n grid values (0's and 1's). 
where 1 indicates swimming pool, and 0 indiactes empty land.

Your task to find the perimeter of the swimming pool.

Note: There is only one swimming pool.

Input Format:
-------------
Line-1: Two integers M and N, size of the backyard.
Next M lines: N space separated integers, either 0 or 1
0- represents empty land and 1- represents the swimming pool 

Output Format:
--------------
Print an integer, the perimeter of the swimming pool


Sample Input-1:
---------------	
4 4
0 1 0 0
1 1 1 0
0 1 0 0
1 1 0 0
 
Sample Output-1:
----------------
16


Sample Input-2:
---------------
1 2
1 0
 
Sample Output-2:
----------------
4

For explanation of sample test cases given refer Hint-1.



Write your python code below
'''
def getCount(arr,i,j,r,c):
    des = [[1,0],[0,1],[-1,0],[0,-1]]
    count =4
    for d in des:
        row = i+d[0]
        col = j+d[1]
        if(row>=0 and row<r and col>=0 and col<c):
            if(arr[row][col]==1):
                count-=1
    return count
   
def perimeter(arr,r,c):
    ans = 0
    for i in range(r):
        for j in range(c):
            if(arr[i][j]==1):
                ans+=getCount(arr,i,j,r,c)
    return ans
r,c = map(int,input().split())
arr = [list(map(int,input().split()))[:c] for i in range(r)]
print(perimeter(arr,r,c))
