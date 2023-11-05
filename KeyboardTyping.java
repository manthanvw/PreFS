/*Ram and Bheem are using a Desktop Computer.One day they found that keyboard 
is defective in which if you type backspace button,it will print '$', 
instead of removing one previous character.

Bheem and Ram have tried to type one word each on the same keyboard.
Return true, if both tried to type the same word. Otherwise return false.

Note:backspace for an empty text will continue empty.

Input Format:
-------------
Line-1:Two space seperated strings represents words w1,w2.

 
Output Format:
--------------
Print a boolean result.
 
Constraints:

    1 <= w1.length, w2.length <= 200
    w1 and w2 only contain lowercase letters and '$' characters.


 
Sample Input-1:
---------------
pq$r  pt$r

Sample Output-1:
----------------
true

Explanation:
------------
Both wants to type 'pr'

Sample Input-2:
---------------
se$$at cea$$t

Sample Output-2:
----------------
false

Sample Input-3:
---------------
s$$at ce$$at

Sample Output-2:
----------------
true

Explanation:
------------
Both wants to type 'at'.
 */
import java.util.*;

public class KeyboardTyping{
    static String getString(String w1){
        Stack<Character> st = new Stack<>();
        for(int i=0;i<w1.length();i++){
            if(st.isEmpty() && w1.charAt(i)=='$') continue;
            else if(w1.charAt(i)=='$') st.pop();
            else st.push(w1.charAt(i));
        }
        w1="";
        while(!st.isEmpty()){
            w1+=st.pop();
        }
        return w1;
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String w1 = sc.next();
        String w2 = sc.next();
        w1 = getString(w1);
        w2 = getString(w2);
        System.out.println(w1.equals(w2));
        sc.close();
    }
}