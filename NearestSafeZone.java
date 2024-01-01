/*Brahmi and his gang was chased by group of police officers, unfortunately 
they all got locked up in a building consist of M*N rooms in the form of 
a grid. All the rooms are connected with  the adjacent rooms both horizontally
and vertically. There are few rooms for them to escape called as safe zones. 

Now help Brahmi and his gang to reach the safe zones in the building.

In the Building we have the rooms filled with following values: [0,-1,-2] 
where, -1 -> Danger zone (they should not enter into it).
0 -> Safe Zone (room to escape)
-2 -> a thief

Now create a method to print the grid after performing following step: 
Fill each room with one of the member from The Brahmi and his gang with 
the distance to its nearest safe zone.
If it is impossible to reach a safezone, fill with '-2' only.

Input Format:
-------------
Line-1 -> two integers M and N, size of the grid of rooms.
Next M Lines -> N space separated integers, from this set [-2,-1,0] only.

Output Format:
--------------
Print an integer as result.


Sample Input-1:
---------------
4 4
-2 -1 0 -2
-2 -2 -2 -1
-2 -1 -2 -1
0 -1 -2 -2

Sample Output-1:
----------------
3 -1 0 1
2 2 1 -1
1 -1 2 -1
0 -1 3 4

NOTE: Please refer the hint.
 */

import java.util.*;

public class NearestSafeZone {
    static int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public static void placeGang(int grid[][], int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    helper(grid, m, n, i, j);
                }
            }
        }
    }

    public static int helper(int grid[][], int m, int n, int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { i, j, 0 });
        boolean vis[][] = new boolean[m][n];
        while (!q.isEmpty()) {
            int cur[] = q.poll();
            int x = cur[0], y = cur[1], steps = cur[2];
            for (int dir[] : dirs) {
                int row = x + dir[0];
                int col = y + dir[1];
                if (row >= 0 && row < m && col >= 0 && col < n && !(vis[row][col]) && grid[row][col] != 0
                        && grid[row][col] != -1) {
                    vis[row][col] = true;
                    if (grid[row][col] == -2) {
                        grid[row][col] = steps + 1;
                    } else {
                        grid[row][col] = Math.min(grid[row][col], steps + 1);
                    }
                    q.offer(new int[] { row, col, steps + 1 });
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int grid[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        placeGang(grid, m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();

    }
}