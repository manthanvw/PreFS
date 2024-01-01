import java.util.Scanner;
public class CountContiguousSubSeriesofBulbs {
    public static void pairs(String s){
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