import java.util.*;
public class BinaryBitDifferenceCounter{
        static int diff(int n,int m){
        if(n>0 || m>0){
            if(n%2 != m%2){
                return 1+ diff(n/2,m/2);
            }
            else{
                return diff(n/2,m/2);
            }
        }
        return 0;
    }
    static int countDiff(int n,int m){
        if(n>0 || m>0){
            if((n&1) != (m&1)) return 1+countDiff(n>>1,m>>1);
            else return countDiff(n>>1,m>>1);
        }
        return 0;
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        // System.out.println(diff(n,m));
        System.out.println(countDiff(n,m));
        sc.close();
    }
}