/* Suman is given two words W1 and W2. 
His task is to derive W2 from W1, withthe following operations:
	- Replace all the occurrences of a letter in W1 with any other letter.
	- Repeat the above step to derive  W2 from W1.
	
Your task is to check whether W2 can be derived from W1 or not.
If yes, print 'true', Otherwise print 'false'.

NOTE: 
-----
NO two letters in W1 should map to same character 
You may assume both W1 and W2 have the same length.

Input Format:
-------------
Line-1: A String,a word W1
Line-2: A String,a word W2

Output Format:
--------------
Print a boolean value


Sample Input-1:
-------------------
paper 
title

Sample Output-1:
---------------------
true

Explanation:
----------------
'p' is replaced with 't', 'a' is with 'i', 'e' is with 'l', and 'r' with 'e'.


Sample Input-2:
-------------------
memo 
demo

Sample Output-2:
---------------------
false

*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DeriveW2fromW1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String w1 = sc.next();
        String w2 = sc.next();
        HashMap<Character,Character> hm = new HashMap<>();
        ArrayList<Character> arr = new ArrayList<>();
        boolean flag = true;
        for(int i=0;i<w1.length();i++){
            if(hm.keySet().contains(w1.charAt(i))){
                if(hm.get(w1.charAt(i)) != w2.charAt(i)){
                    flag =false;
                    break;
                }
            }
            else{
                if(arr.contains(w2.charAt(i))){
                    flag =false;
                    break;
                }
            } 
            hm.put(w1.charAt(i),w2.charAt(i));
            arr.add(w2.charAt(i));
        }
        System.out.println(flag);
        sc.close();
    }
}