/*Given an undirected graph with V vertices and a number M, the task is to color 
the given graph with at most M colors such that no two adjacent vertices of 
the graph are colored with the same color. Color codes are start from 1 to M. 
You need to assign the color code to any vertex V, whihch is the least possible 
color code value.

Your task is to check whether it is possible or not.
Print 'true' if it is possible, Otherwise print 'false'.

Note: 
- In the given graph, there are no self edges.
- Coloring of a graph means the assignment of colors to all vertices.

Input Format:
-------------
Line-1: An integer V and M,
Next V lines: V space separated integers, only 1's and 0's.

Output Format:
--------------
if possible, print the coloring arrangement of V vertices.
Otherwise, print "No Solution" 


Sample Input-1:
---------------
4 3
0 1 1 1
1 0 1 0
1 1 0 1
1 0 1 0

Sample Output-1:
----------------
1 2 3 2 


Sample Input-2:
---------------
4 2
0 1 1 1
1 0 1 1
1 1 0 1
1 1 1 0

Sample Output-2:
----------------
No Solution
 */

// import java.util.Scanner;
import java.util.Arrays;

public class GraphColoring {
    public static int getColor(int arr[][],int v,int max,int color[]){
        if(v==0) return 1;
        int col = 1;
        int r = arr[0].length;
        // while(col<max){
            for(int i=0;i<r;i++){
                System.out.println(v+" "+i+" "+arr[v][i]+" "+ (arr[v][i]==1));
                if((v!=i) && (arr[v][i] ==1) && col<max) col++;
                else break;
            }
        // }
        return col;
        
    }
    public static int[] isColoured(int arr[][],int r,int c){
        int[] color = new int[r];
        for (int i=0; i<r; i++){
            color[i] = getColor(arr,i,c,color);
        } 
        return color;
    }
    public static void main (String[] args) {
        int v = 4;
        int m = 3;
        int arr[][] = {{0,1,1,1},
                       {1,0,1,0},
                       {1,1,0,1},
                       {1,0,1,0}};
        
        
        int res[] = isColoured(arr,v,m);
        if(res.length==0) System.out.print("No Solution");
        else System.out.print(Arrays.toString(res));
    }
}
