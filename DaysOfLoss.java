import java.util.*;
public class DaysOfLoss{
    static int getLossCount(int arr[][],int r,int c){
        int count=0;
        int high = c;
        for(int i[]:arr){
            // System.out.println(Arrays.toString(i));
            if(i[0]<0) count+=c;
            else if(i[c-1]>=0) continue;
            else{
                int l=0,h=high;
                int mid=(l+h)/2;
                int ans = c;
                while(l<=h){
                    // System.out.println(mid+" "+i[mid]);
                    mid=(l+h)/2;
                    if(i[mid]<0){
                        ans = Math.min(ans,mid);
                        h=mid-1;
                    } 
                    else l=mid+1;
                    
                }
                // System.out.println(mid+" "+i[mid]);
                high = ans;
                count+=c-ans;
            }
            // System.out.println("count = "+count);
        }
        return count;
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int arr[][]=new int[r][c];
        for (int i=0; i<r; i++)
            for (int j=0; j<c; j++)
                arr[i][j] = sc.nextInt();
        System.out.println(getLossCount(arr,r,c));
        sc.close();
    }
}