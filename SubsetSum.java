/*Given a sorted set of positive integers numset[], and a target T.

Your task is to print all subsets of numset with sum equal to given target.
If no subset found, print -1.

Note: Subsets should be distinct and lexicographiclly ascending order..

Input Format:
-------------
Line-1 -> An integer N, number of elements.
Line-2 -> N space separated integers, numset[].
Line 3 -> An integer T, target.

Output Format:
--------------
Print all the subsets.


Sample Input-1:
---------------
7
1 2 3 5 6 8 10
10

Sample Output-1:
----------------
1 3 6
2 3 5
2 8
10 */

import java.util.*;
public class SubsetSum {
    public static void getSum(int arr[],int n,int i,int sum,int target,String s){
        if(i>=n) return;
        // if(arr[i] == target) System.out.println(arr[i]);
        if(sum == target){
            if(s!="") System.out.println(s);
            s="";
            sum = 0;
        }
        else if(sum+arr[i]<=target){
            getSum(arr,n,i+1,sum+arr[i],target,s+arr[i]+" ");
        }
        getSum(arr,n,i+1,sum,target,s);
    }
    public static void main (String[] args) {
        int n = 7;
        int arr[] = {1,2,3,5,6,8,10};
        int target = 10;
        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // int arr[] = new int[n];
        // for (int i=0; i<n; i++) arr[i] = sc.nextInt();
        // int target = sc.nextInt();
        getSum(arr,n,0,0,target,"");
    }
}