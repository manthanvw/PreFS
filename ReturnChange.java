/*For a Movie Premiere in US, advance booking is opened,
At Quad Cinema theater, each ticket costs $25.
And issue only one ticket per head. 

People are standing in a queue to buy from Quad Cinema counter, 
and order one at a time. And they are paying with either a $25, $50, or $100 notes.

You will be given, an array of notes[], the people are carrying with them.
Your task is to issue ticket and settle the balance to each person, 
If a person given a $50 note, Issue the ticket worth $25 and settle the balance $25.

Print true, if and only if you can provide tickets and settle the balance 
for all the people in the queue. Otherwise, false.

Note: Initially you don't have any amount in hand.

Input Format:
-------------
Line-1: An integer N, number of persons
Line-2: N space separated integers, notes with the persons.

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
5
25 25 25 50 100

Sample Output-1:
----------------
true

Explanation:
-----------
- From the first three persons in queue, we take three $25 notes.
- For the fourth person in queue, we take a $50 note and give back a $25 note.
- For the last person, we take a $100 note and give back a $50 note and a $25 note.
- Since every person in the queue received the ticket and balance, the answer is true.

Sample Input-2:
---------------
5
25 25 50 50 100

Sample Output-2:
----------------
false

Explanation:
-----------
- From the first two persons in queue, we take two $25 notes.
- For the next two persons in queue, we take a $50 note and give back a $25 note.
- For the last customer, we take $100, but can't give balance of $75 back 
  because we only have two $50 notes.
- Since not every person in the queue received the ticket and balance, the answer is false.
 */
import java.util.*;

public class ReturnChange {
    public static boolean isPossible(int[] arr, int n) {
        int count25 = 0;
        int count50 = 0;
        
        for (int i = 0; i < n; i++) {
            if (arr[i] == 25) {
                count25++;
            } else if (arr[i] == 50) {
                count25--;
                count50++;
            } else {
                if (count50 > 0) {
                    count50--;
                    count25--;
                } else {
                    count25 -= 3;
                }
            }

            if (count25 < 0 || count50 < 0) {
                return false;
            }
        }
        
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(isPossible(arr, n) ? "YES" : "NO");
        sc.close();
    }
}

/*import java.util.*;
public class ReturnChange {
    // Sir hm.getOrDefault is working fine, I didn't write it properly sorry to waste you time. Thank you.
    static boolean isPossible(int arr[],int n){
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(25,0);
        hm.put(50,0);
        for(int i=0;i<n;i++){
      System.out.println(hm);
            if(arr[i]==25) {
                hm.put(25,hm.getOrDefault(25,0)+1);
            }
            else if(arr[i]==50){
                if(hm.get(25)>0){
                    int a = hm.get(25);
                    hm.put(25,a-1);
                    hm.put(50,hm.getOrDefault(50,0)+1);
                }
                else return false;
            }
            else{
               if(hm.get(25)>0 && hm.get(50)>0){
                    int a = hm.get(25);
                    hm.put(25,a-1);
                    a=hm.get(50);
                    hm.put(50,a-1);
                }
                else if(hm.get(25)>=3){
                    int a = hm.get(25);
                    hm.put(25,a-3);    
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for (int i=0; i<n; i++) arr[i] = sc.nextInt();
        System.out.println(isPossible(arr,n));
        sc.close();
    }
}*/
