/*There is a switch-board made by an electrician,
If you turn on any two adjacent switches, it will cause short-circuit
and damage the switch-board.

You are given N integers(only 0's and 1's), Indiactes current status of 
the switch board with N switches, where 1 indiactes switch is ON and 
0 indiactes switch is OFF. And an integer K, more number of switches 
to be turned ON.

Return true if and only if you can turn ON all the K switches, without 
causing any damage to switch-board. Otherwise return fasle.

Input Format:
-------------
Line-1: Two integers N and K, number of switches, and more number of switches to be ON
Line-2: N space separated integers, only 0's and 1's.

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
5 1
1 0 0 0 1

Sample Output-1:
----------------
true

Sample Input-2:
---------------
5 2	
1 0 0 0 1

Sample Output-2:
----------------
flase
 */
import java.util.*;
public class ShortCircuit {
    static boolean isPossible(int n,int k,int arr[]){
        if(arr[0]==0 && arr[1]==0){
            k--;
            arr[0]=1;
        }
        for(int i=1;i<n-1;i++){
            if(arr[i-1]==0 && arr[i+1]==0 &&arr[i]!=1){
                arr[i]=1;
                k--;
            }
            // System.out.println(arr[i-1]+" "+arr[i+1]+" "+count);
        }
        if(arr[n-1]==0 && arr[n-2]==0){
            k--;
            arr[n-1]=1;
        }
        return k<=0;
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int K = sc.nextInt();
        int arr[] = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }
        System.out.print(isPossible(N,K,arr));
        sc.close();
    }
}    