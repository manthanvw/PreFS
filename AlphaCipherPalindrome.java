import java.util.*;
public class AlphaCipherPalindrome{
    static boolean isPalindrome(String s){
        Set<Character> st = new HashSet<>();
        for(int i=0;i<s.length();i++){
            if(st.contains(s.charAt(i))){
                st.remove(s.charAt(i));
            }
            else{
                st.add(s.charAt(i));
            }
        }
        System.out.println(st);
        if((s.length()%2 ^ st.size())==0) return true;
        // if(s.length()%2 != 0 && st.size() ==1) return true;
        return false;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(isPalindrome(s));
        sc.close();
    }
}