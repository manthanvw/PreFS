
/*In the scenic landscape of a hilly region, there are N hills numbered from 
0 to N-1, and ropeways connecting some pairs of hills represented by 
ropeways[i] = [ai, bi]. Each ropeway allows easy travel between the connected 
hills, and any hill can be reached from any other hill directly or indirectly 
through the ropeways.

You are given the initial ropeway connections in the hilly region. You can 
remove the ropeways between two directly connected hills, and use them between 
any pair of disconnected hills to make them directly connected.

Your task is to find the minimum number of times you need to do this in order 
to make all the hills are connected. If it is not possible, return -1.

Input Format:
-------------
Line-1: An integer N and R.
next R lines: Two separated integers, hill-i and hill-j. 

Output Format:
--------------
Print an integer result.


Sample Input:
-------------
7 6
0 1
0 2
1 3
4 5
4 6
5 6

Sample Output:
--------------
1

Explanation: 
------------
Remove ropeway between hill-5 and hill-6 and use it to connect hill-3 and hill-4.


Sample Input:
-------------
5 3
0 1
1 2
2 0

Sample Output:
--------------
-1

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
        parent[m] = n;
    }

    public int connect(int hills[][], int n) {
        for (int i = 0; i < n; i++) {
            union(hills[i][0], hills[i][1]);
        }
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < size; i++) {
            hs.add(find(i));
        }
        return hs.size() - 1;
    }
}

public class MinimumRopewayRemovals {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        if (r < n - 1) {
            System.out.println(-1);
            sc.close();
            return;
        }
        int hills[][] = new int[r][2];
        for (int i = 0; i < r; i++) {
            hills[i][0] = sc.nextInt();
            hills[i][1] = sc.nextInt();
        }
        DSU obj = new DSU(n);
        int ans = obj.connect(hills, r);
        System.out.println(ans);
        sc.close();
    }
}

// import java.util.*;
// class Test{
// public static void main (String[] args) {
// Scanner sc = new Scanner(System.in);
// int n = sc.nextInt(), r = sc.nextInt(), ropes[][] = new int[r][2];
// for(int i = 0; i < r; i++){
// ropes[i][0] = sc.nextInt();
// ropes[i][1] = sc.nextInt();
// }
// System.out.println(minCost(ropes, n, r));
// }
// static int minCost(int[][] ropes, int n, int r){
// if(r < n - 1) return -1;
// int ans = 0, parents[] = new int[n];
// for(int i = 0; i < n; i++) parents[i] = i;
// for(int rope[]: ropes){
// int h1 = rope[0], h2 = rope[1];
// if(parents[h1] != parents[h2]) union(parents, h1, h2);
// // System.out.println(Arrays.toString(parents));
// }
// HashSet<Integer> hs = new HashSet<>();
// for(int i=0;i<n;i++){
// hs.add(parents[i]);
// }
// return hs.size()-1;
// }
// static void union(int parents[], int h1, int h2){
// int k = parents[h1];
// for(int i = 0; i < parents.length; i++) if(parents[i] == k) parents[i] =
// parents[h2];
// }
// }
