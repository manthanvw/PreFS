/*Mr Sudhakar is given a checkerboard of size 400*400, where the indices starts 
from (-200,-200) and ends at (199,199). In one step, he can move the box from 
position (p,q) to one of the following positions in L shape like as follows: 
	- (p-2, q-1), (p-2, q+1), (p+2, q-1), (p+2, q+1)
	- (p-1, q+2), (p+1, q+2), (p-1, q-2), (p+1, q-2)

Initially the box is at (0,0) position, and need to move the box to position (m,n).
You will be given two integers m and n indicates the position(m,n).

Now your task is to help by Mr Sudhakar to find the minimum number of steps 
required to move the box from (0,0) to (m,n).

Note: It is allowed to move out of the board also.
Please do refer the image in the hint for better understanding.


Input Format:
-----------------
Two space separated integers, m and n, position.

Output Format:
------------------
Print an integer, minimum number of steps to reach (m,n).


Sample Input-1:
---------------
2 4

Sample Output-1:
----------------
2

Explanation:
-------------
Initially, you are at (0,0) position, you can reach (2,4) as follows:
(0,0) -> (1, 2) -> (2, 4) 


Sample Input-2:
---------------
4 7

Sample Output-2:
----------------
5

Explanation:
------------
Initially, you are at (0,0) position, you can reach (4,7) as follows:
(0,0) -> (1, 2) -> (2, 4) -> (1, 6) -> (3, 5) -> (4, 7)

 */



import java.util.*;
public class KnightMoves {
    public static int getMinPath(int m,int n){
        int dirs[][] = {{1,2},{2,1},{1,-2},{2,-1},{-1,2},{-2,1},{-1,-2},{-2,-1}};
        Queue<int[]> q = new LinkedList<>();
        Set<int[]> s = new HashSet<>();
        q.offer(new int[]{0,0,0});
        int count =1;
        while(! q.isEmpty()){
            // int size = q.size();
            // System.out.println("I am here");
            int curPos[] = q.poll();
            // System.out.println(Arrays.toString(curPos));
            int row = curPos[0];
            int col = curPos[1];
            int steps = curPos[2];
            if(row==m && col==n) return steps+1;
            for (int dir[]:dirs){
                int x = row+dir[0];
                int y = col+dir[1];
                if(x>=-200 && x<=199 && y>=-200 && y<=199 && (!s.contains(new int[]{x,y}))){
                    // System.out.println(x+" "+y);
                    if(x==m && y==n) return steps+1;
                    else {
                        q.offer(new int[]{x,y,steps+1});
                        count++;
                        s.add(new int[]{x,y});
                    }
                }
            }
        }
        return count;
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        System.out.print(getMinPath(m,n));
        sc.close();
    }
}