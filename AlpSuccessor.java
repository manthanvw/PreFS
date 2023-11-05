/*
 '''
In a mango farm, you have two rows of mango trees. Each row represents 
an integer array, namely "fruitcount1" and "fruitcount2," 
sorted in ascending order to indicate the number of mangoes on each tree.

Your task is to find the trees having same count of trees in fruitcount1[],
 fruitcount2[] and the fruits count is least.
If there are no such common trees, return -1.

Input Format:
-------------------
Line-1: Two space separated integers, M and N
Line-2: M space separated integers, fruitcount1[]
Line-3: N space separated integers, fruitcount2[]

Output Format:
-------------------
Print an integer result.


Sample Input:
--------------
5 4
2 4 5 8 12
3 4 6 8

Sample Output:
---------------
4


Sample Input:
--------------
5 6
2 4 5 8 12
1 3 6 8 10 12

Sample Output:
--------------
8


Write your python code below.
'''
def common(l1,l2):
    i=0
    j=0
    while(i<len(l1) and j<len(l2)):
        if(l1[i]==l2[j]): return l1[i]
        elif(l1[i]<l2[j]):
            i+=1
        else: j+=1
    return -1

m,n=map(int,input().split())
l1 = list(map(int,input().split()))
l2 = list(map(int,input().split()))
print(common(l1,l2),end="")

 */
import java.util.*;
public class AlpSuccessor {
    static char BS(String s,char ch){
        if(s.charAt(s.length()-1) < ch) return s.charAt(0);
        int l = 0,h = s.length();
        while(l<h){
            int mid = (l+h)/2;
            if(s.charAt(mid)>ch  && (s.charAt(mid-1))<=ch){
                return s.charAt(mid);
            }
            else if(s.charAt(mid)<=ch) l = mid+1;
            else h = mid;
        }
        return s.charAt(0);
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char ch = sc.next().charAt(0);
        System.out.println(BS(s,ch));
        sc.close();
    }
}
