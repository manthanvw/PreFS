/*
 * There are two lines of electrical outlets, these outlets support different 
voltages range from -100v to 100v. The volatges of the outlets in each line
are arranged in the ascending order using arrays, list1[] and list2[]

Your task is to combine these two lists into one list of outlets, and the 
arrangement of outlets should be in the ascending order of their volatges.

INPUT FORMAT:
-------------
Line-1: Two space separated integers, M and N.
Line-2: M space separated integers, voltages of outlets in list-1
Line-3: N space separated integers, voltages of outlets in list-2

OUTPUT FORMAT:
--------------
Space separated integers, voltages of outlets in ascending order.


SAMPLE INPUT-1:
---------------
4 3
1 3 5 7
2 4 6

SAMPLE OUTPUT-1:
----------------
1 2 3 4 5 6 7


SAMPLE INPUT-2:
---------------
2 6
-10 -5
-6 -5 3 4 6 8

SAMPLE OUTPUT-2:
----------------
-10 -6 -5 -5 3 4 6 8

 */
import java.util.Scanner;
public class MergeTwoSortedArrays {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int arr1[] = new int[m];
        int arr2[] = new int[n];
        int ans[] = new int[m+n];
        for(int i=0;i<m;i++) arr1[i] = sc.nextInt();
        for(int i=0;i<n;i++) arr2[i] = sc.nextInt();
        
        int i=0,j=0,k=0;
        while(i<m && j<n){
            if(arr1[i]<=arr2[j]){
                ans[k] = arr1[i];
                i++;
            }
            else{
                ans[k] = arr2[j];
                j++;
            }
            k++;
        }

        if(i<m){
            for(int x=i;x<m;x++){
                ans[k] = arr1[x];
                k++;
            }
        }
        if(j<n){
            for(int x=j;x<n;x++){
                ans[k] = arr2[x];
                k++;
            }
        }
        for(int num:ans) System.out.print(num+" ");
        sc.close();
    }
}
