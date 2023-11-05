import java.util.*;

public class MaximumLaddusEaten {
        static int Count(int nums[]){
            Set<Integer> arr = new HashSet<>();
            
            for(int i:nums){
                 arr.add(i);
            }
            
            return Math.min(nums.length/2, arr.size());
        }
        public static void main(String args[]){
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int nums[] = new int[n];
            for(int i=0;i<n;i++) nums[i] = sc.nextInt();
            System.out.println(Count(nums));
            sc.close();
        
        }
}

