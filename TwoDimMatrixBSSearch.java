/*
There is a board with M*N size. 
The board contains M*N blocks of 1*1 size.
Each block is printed a number on it.

You will be given a number, your task is to find whether the number is printed on 
any of the blocks or not. If found print true, otherwise print false.

NOTE: 
- The numbers printed on the board in each row and each column are
  in increasing order. And all the numbers are unique.

Input Format:
-------------
Line-1 -> Two integers M and N, board size.
Next M lines -> N space separated integers.
Last Line -> An integer T, number to search.

Output Format:
--------------
Print a boolean value, 'true' if number found.
otherwise, 'false'.


Sample Input-1:
---------------
4 4
1 3 6 10
2 5 9 13
4 8 12 16
7 11 14 17
5

Sample Output-1:
----------------
true


Sample Input-2:
---------------
4 4
1 3 6 10
2 5 9 13
4 8 12 16
7 11 14 17
15

Sample Output-2:
----------------
false

 */
import java.util.*;
public class TwoDimMatrixBSSearch {
    public static void main (String[] args) {
       Scanner sc = new Scanner(System.in);
      int r = sc.nextInt();
      int c = sc.nextInt();
      int arr[][] = new int[r][c];
      for(int i=0;i<r;i++)
        for(int j=0;j<c;j++)
            arr[i][j] = sc.nextInt();
        int num = sc.nextInt();
        int flag =0;
        int index;
        for(int i[]:arr){
            // i = ArrayUtils.subarray(i,0,index);
            index = Arrays.binarySearch(i,num);
            if(index >=0){
                flag = 1;
                break;
            }
        }
        System.out.println((flag==1));
        sc.close();
    }
}
/*
 import java.util.*;
public class Test{
    static boolean BS(int arr[][],int r,int c,int n){
        int l=0,h=r;
        if(n<arr[0][0]) return false;
        if(n>arr[r-1][c-1]) return false;
        while(l<=h){
            int mid = (l+h)/2;
            if(arr[mid][0]<=n && arr[mid][c-1]>=n){
                int index = Arrays.binarySearch(arr[mid],n);
                System.out.println(index);
                if(index >=0) return true;
                else return false;
            }
            else if(arr[mid][0]>n) h = mid-1;
            else l = mid+1;
        }
        return false;
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int arr[][] = new int[m][n];
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++) 
                arr[i][j] = sc.nextInt();
        int num = sc.nextInt();
        System.out.println(BS(arr,m,n,num));

    }
}
 */