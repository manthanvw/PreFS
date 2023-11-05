/*
 You are provided with a string composed of binary digits, and 
your task is to write a method that calculates the count of set bits within it. 

Constraint:
-----------
String length is <=150.


Input Format:
-------------
A string, consists of 0's and 1's.

Output Format:
-------------------
Print an integer result.


Sample Input:
--------------
01001100001111101101010101111000

Sample Output:
---------------
17


Sample Input:
--------------
11110010111011011011011111100110

Sample Output:
--------------
22

 */
import java.util.*;
public class SetBitCount{
    static int getSB(String s){
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1') count++;
        }
        return count;
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(getSB(s));
        sc.close();
    }
}