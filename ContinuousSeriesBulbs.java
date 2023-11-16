/*There is a series of bulbs in which some bulbs are turned on(indicated by 1) 
and others are off(indicated by 0). 

A contiguous sub-series of bulbs CSB with following rules.
    1. Number of bulbs with status as 'on' and 'off' are same.
    2. Bulbs which are 'on' and 'off' are grouped together.

You will be given the series as a string of 1's and 0's.
Your task is to find the count of all the CSBs  exist in the given series.

Input Format:
-------------
A string, indicates bulbs series.

Output Format:
--------------
Print an integer result.

Sample Input-1:
---------------
010011000110

Sample Output-1:
----------------
9

Explanation:
------------
01-3, 10-3, 0011-2, 1100-1 


Sample Input-2:
---------------
0101010

Sample Output-2:
----------------
6

Explanation:
------------
01-3, 10-3
 */

import java.util.Scanner;
public class ContinuousSeriesBulbs {
    public static int pairs(String s){
        // ArrayList<Integer> arr = new ArrayList();
        // int count =0;
        // char curr = '0';
        // for (int i=0; i<s.length(); i++){
        //     if(s.charAt(i) == curr){
        //         count++;
        //     }
        // } 
        // 010011000110
        // 1122321
        // 1(min(1,1))+1(min(1,2))+2(min(2,2))+2(min(2,3))+2min(3,2)+1(min(2,1))
        return 0;
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String s1 = "01";
        String s2 = "10";
        int count =0;
        int flag = 0;
        while(flag ==0){
            int match = 0;
            for (int i=0; i<=s.length()-s1.length(); i++){
                if(s.substring(i,i+s1.length()).equals(s1)){
                    match++;
                }
            }
            for (int i=0; i<=s.length()-s2.length(); i++){
                if(s.substring(i,i+s2.length()).equals(s2)){
                    match++;
                }
            }
            count+=match;
            s1 = "0"+s1+"1";
            s2 = "1"+s2+"0";
            if(match==0) break;
        }        
        System.out.print(count);
        sc.close();
    }
}