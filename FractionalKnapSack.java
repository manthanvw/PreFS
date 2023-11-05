import java.util.*;
public class FractionalKnapSack{
    static double getCost(double arr[][],int n,double cap){
        double cost = 0;
        // System.out.println(cost+" "+cap);
        for (int i=0; i<n;i++ ){
            if(cap - arr[i][1]>=0){
                cost+= arr[i][0];
                cap = cap-arr[i][1];
            }
            else{
                double left = (double)(cap/arr[i][1]);
                // System.out.println(left+" "+left*arr[i][0]);
                cost+= left*arr[i][0];
                break;
            }
            // System.out.println(cost+" "+cap);
        }
        return cost;
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double arr[][] = new double[n][2];
        for (int i=0; i<n; i++){
            arr[i][0] = sc.nextDouble();
            arr[i][1] = sc.nextDouble();
        } 
        double cap = sc.nextDouble();
        Arrays.sort(arr,(a,b)->{
            if((double)(a[0]/a[1]) < (double)(b[0]/b[1])) return 1;
            else return -1;
        });
        // System.out.println(Arrays.deepToString(arr));
        System.out.println(getCost(arr,n,cap));
        sc.close();
    }
}