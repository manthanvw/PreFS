/*Given a classic mobile phone, and the key pad of the phone looks like below.
	1		2		3
           abc	   def
		 
	4		5		6
    ghi    jkl     mno
  
	7		8		9
    pqrs    tuv     wxyz
	
	*		0		#


You are given a string S contains digits between [2-9] only, 
For example: S = "2", then the possible words are "a", "b", "c".

Now your task is to find all possible words that the string S could represent.
and print them in a lexicographical order. 

Input Format:
-------------
A string S, consist of digits [2-9]

Output Format:
--------------
Print the list of words in lexicographical order.


Sample Input-1:
---------------
2

Sample Output-1:
----------------
[a, b, c]


Sample Input-2:
---------------
24

Sample Output-2:
----------------
[ag, ah, ai, bg, bh, bi, cg, ch, ci]
 */

import java.util.*;
public class NumberPad {
    public static ArrayList<String> getStrings(int n){
        String hm[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        if(n%10 == n) {
            return new ArrayList<String>(Arrays.asList(hm[n].split("")));
        }
        else{
            ArrayList<String> start = getStrings(n/10);
            ArrayList<String> res = new ArrayList<>();
            String s = hm[n%10];
            for(String i:start){
                for(int j=0;j<s.length();j++){
                    res.add(i+s.charAt(j));
                }
            }
            return res;
        }
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(getStrings(n).toString());
        sc.close();
    }
}
