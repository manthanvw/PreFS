/*You are entering into a maze N*N grid consist of(0's and 1's)
Initially you will start from (0,0) position in the maze, 
Your target is to reach the end position (N-1, N-1).

Among the four directions available(top, down, left, right),
you can move in two directions only, right and down.

In the maze, '0' indicates dead end and '1' indicates open way. 
You can travel through only open way.

For Example:-
Given Maze of size N=4 , starting position is (0, 0),
1 0 0 0
1 1 0 1
0 1 0 0
1 1 1 1

You can reach the (3, 3) position in the following way.
1 0 0 0
1 1 0 0
0 1 0 0
0 1 1 1

Return true, if you can reach the end position(N-1, N-1).
otherwise return false.

Input Format:
-------------
Line-1 -> An integer N, size of square board.
Next N lines -> N space separated integers 

Output Format:
--------------
Print a boolean value.

Sample Input-1:
---------------
4
1 0 0 0
1 1 0 1
0 1 0 0
1 1 1 1

Sample Output-1:
----------------
true


Sample Input-2:
---------------
4
1 1 0 0
1 0 0 1
0 1 1 0
1 0 0 1

Sample Output-2:
----------------
false

 */

import java.util.*;

public class Maze {
    public static boolean inBound(int graph[][],int x,int y,int n){
        return (x>=0 && x<n && y>=0 && y<n && graph[x][y]==1);
        
    }
    public static boolean reachedEnd(int graph[][],int n){
        if(graph[0][0]==0 || graph[n-1][n-1] == 0) return false;
        return helper(graph,0,0,n);
    }
    public static boolean helper(int graph[][],int x,int y,int n){
        if(x==n-1 && y==n-1) return true;
        if(inBound(graph,x,y,n)){
            if(helper(graph,x+1,y,n)) {
                // System.out.print("R");
                return true;
            }
            if(helper(graph,x,y+1,n)){
                // System.out.print("D");
                return true;
            } 
        }
        return false;
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int graph[][] = new int[n][n];
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                graph[i][j] = sc.nextInt();
            } 
        } 
        System.out.print(reachedEnd(graph,n));
        sc.close();
    }
}