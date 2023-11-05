/*There are two teams Titans and Warriors with same N number of players.
Both the teams have same set of jersey numbers for their players.

Both the teams stand in two lines opposite to each other from index 0...N-1.
Players from Team-Titans  in line-1 and Team-Warriors in line-2.

You have to find an index mapping M[], from Titans to Warriors. 
A mapping M[i] = j, means the jersey number of player[i] in Titans team appears 
in Warriors team at index j.

The teams Titans and Warriors may contain duplicate jersey numbers.
Your task is to return, lexicographically smallest order.

Input Format:
-------------
Line-1: An integer N, number of players in each team.
Line-2: N space separated integers, T[] jersey numbers of Titans team
Line-3: N space separated integers, W[] jersey numbers of Warriors team

Output Format:
--------------
Print the mapping array.


Sample Input-1:
---------------
6
32 41 51 15 21 10
10 51 41 21 32 15

Sample Output-1:
----------------
4 2 1 5 3 0

Explanation:
------------
Indices ->  0  1  2  3  4  5
Titans ->   32 41 51 15 21 10
Warriors -> 10 51 41 21 32 15

So, the mapping of jersey numnbers is: 
M[0]=4, M[1]=2, M[2]=1, M[3]=5, M[4]=3, M[5]=0


Sample Input-2:
---------------
5
10 10 20 20 20
20 10 20 10 20

Sample Output-2:
----------------
1 3 0 2 4

 */

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MapTwoTeams {
    static ArrayList<Integer> getMap(int t1[], int t2[],int n){
        Map<Integer,Integer> hm = new LinkedHashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                
                if(t1[i] == t2[j]){
                if(hm.keySet().contains(i)) continue;
                if(!hm.containsValue(j)){
                        hm.put(i,j);
                    }
                }
            }
        }
        for(int i: hm.values()){
            ans.add(i);
        }
        
        return ans;
    }
    
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int T[] = new int[n];
        int W[] = new int[n];
        for(int i=0;i<n;i++) T[i] = sc.nextInt();
        for(int i=0;i<n;i++) W[i] = sc.nextInt();
        
        ArrayList<Integer> ans = getMap(T,W,n);
        
        for(Integer i:ans){
            System.out.print(i+" ");
        }
        sc.close();
    }
}
