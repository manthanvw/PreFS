/*
There are P people in a Village, some of the people are relatives, 
others are not. Their relationship is transitive. 

For example, 
if A is a direct relative of B, and B is a direct relative of C, 
then A is an indirect relative of C. And we define a Relation Chain as 
a group of people who are direct or indirect relatives.

Given a P*P matrix R represents the relationship between people 
in the village. If R[i][j] = 1, then the i and j persons are direct 
relatives with each other, otherwise not. 

Your task is to find out the total number of Relation Chains 
among all the people.

Input Format:
-------------
Line-1 : An integer P, number of people
Next P lines : P space separated integers.

Output Format:
--------------
Print an integer, the total number of Relation Chains


Sample Input-1:
---------------
3
1 1 0
1 1 0
0 0 1

Sample Output-1:
----------------
2

Explanation:
------------
The 0-th and 1-st people are direct relatives, so they are in a relation chain.
The 2-nd person himself is in a relation chain. So return 2.


Sample Input-2:
---------------
3
1 1 0
1 1 1
0 1 1

Sample Output-2:
----------------
1

Explanation:
------------
The 0-th and 1-st people are direct relatives, 1-st and 2-nd people 
are direct relatives. So, the 0-th and 2-nd people are indirect relatives.
All of them in the same relative chain. So return 1.

*/

import java.util.*;

class DSU {
    private int parent[];
    private int size;

    DSU(int n) {
        size = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    private int find(int i) {
        if (parent[i] == i)
            return i;
        else
            return find(parent[i]);
    }

    private void union(int i, int j) {
        int m = find(i);
        int n = find(j);
        for (int k = 0; k < size; k++) {
            if (parent[k] == m) {
                parent[k] = n;
            }
        }
    }

    public int getRel(int rel[][]) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i != j) {
                    if (rel[i][j] == 1) {
                        if (find(i) != find(j)) {
                            union(i, j);
                        }
                    }
                }
            }
        }
        for (int i : parent) {
            hs.add(i);
        }
        return hs.size();
    }
}

public class FriendCircles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int rel[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rel[i][j] = sc.nextInt();
            }
        }

        DSU dsu = new DSU(n);
        int ans = dsu.getRel(rel);
        System.out.println(ans);
        sc.close();
    }
}