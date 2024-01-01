/*
 * A device is secured with a digital lock, 
The digital lock is made up of a 3*3 grid like below:
| 1 | 2 | 3 |
| 4 | 5 | 6 |
| 7 | 8 | 9 |

The lock is secured by creating pattern using the above grid.
A valid pattern as formed as follows:

Rules for a valid pattern:
	- Each pattern must connect at least m keys and at most n keys.
	- All the keys must be distinct.
	- If the line connecting two consecutive keys in the pattern passes through 
	  any other keys, the other keys must have already the part of the pattern. 
	  No jumps through a key which is not part of the pattern is allowed.
	- The order of keys used matters.
 
You will be given two integers m and n, where 1 ≤ m ≤ n ≤ 9, 
Your task is to count the total number of patterns of the device lock, 
which consist of minimum of m keys and maximum n keys. 

Examples of valid and invalid patterns:
	Invalid move: 4 - 1 - 3 - 6
	Line 1 - 3 passes through key 2 which had not been part of the pattern.

	Invalid move: 4 - 1 - 9 - 2
	Line 1 - 9 passes through key 5 which had not been part of the pattern.

	Valid move: 2 - 4 - 1 - 3 - 6
	Line 1 - 3 is valid because it passes through key 2, which had been part 
	of the pattern

	Valid move: 6 - 5 - 4 - 1 - 9 - 2
	Line 1 - 9 is valid because it passes through key 5, which had been part 
	of the pattern

Input Format:
-------------
Two space separated integers M and N.

Output Format:
--------------
Print an integer, number of valid patterns formed using the grid.


Sample Input-1:
---------------
1 1

Sample Output-1:
----------------
9


Sample Input-2:
---------------
1 2

Sample Output-2:
----------------
65

*/


/*The below code doesnt't work */
/*The below code doesnt't work */
/*The below code doesnt't work */
/*The below code doesnt't work */

import java.util.*;

public class ValidPatterns {
    static int count = 0;
    static int[][] dest = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 },
            { 1, 1 }, { -1, 1 }, { 1, -1 }, { -1, -1 },
            { 1, 2 }, { 2, 1 }, { -1, 2 }, { 2, -1 },
            { -2, 1 }, { 1, -2 }, { -1, -2 }, { -2, -1 } };

    public static void getPatterns(int[][] grid, int m, int n) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = 1;
                helper(grid, m, n, i, j, 1);
                grid[i][j] = 0;
            }
        }
    }

    public static void helper(int[][] grid, int m, int n, int row, int col, int index) {
        // System.out.println(Arrays.deepToString(grid));
        if (index > n) {
            return;
        }
        if (index >= m) {
            count++;
        }
        for (int des[] : dest) {
            int x = row + des[0];
            int y = col + des[1];
            if (x >= 0 && x < 3 && y >= 0 && y < 3) {
                if (grid[x][y] != 1) {
                    grid[x][y] = 1;
                    helper(grid, m, n, x, y, index + 1);
                    grid[x][y] = 0;
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int grid[][] = new int[3][3];
        getPatterns(grid, m, n);
        System.out.print(count);
        sc.close();
    }
}