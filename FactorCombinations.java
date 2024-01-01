/*Mr Mukund is working on numbers; He is fascinated by number factors.
He is given a number N, he wants to find out all possible ways of 
obtaining N as multiple of its factors.

For example given N =12
can be written as multiple of 2,3 and 4.
and the ways to obtains 12 from ots factors are: 2*2*3, 2*6, 3*4

Your task is to help Mr Mukund to find the all possible ways of obtaining N 
from its factors and return all the possible ways as shown in the samples.

NOTE: The result should be in the lexicographic order.

Input Format:
-------------
An integer N, value of N.

Output Format:
--------------
Print the list of possiblilties.


Sample Input-1:
---------------
12

Sample Output-1:
----------------
[[2, 2, 3], [2, 6], [3, 4]]


Sample Input-2:
---------------
16

Sample Output-2:
----------------
[[2, 2, 2, 2], [2, 2, 4], [2, 8], [4, 4]]


Sample Input-3:
---------------
32

Sample Output-3:
----------------
[[2, 2, 2, 2, 2], [2, 2, 2, 4], [2, 2, 8], [2, 4, 4], [2, 16], [4, 8]]
 */

import java.util.*;

public class FactorCombinations {
    public static List<List<Integer>> getFactors(int n) {
        List<List<Integer>> factors = new ArrayList<>();
        helper(n, factors, 2, new ArrayList<Integer>());
        factors.remove(factors.size() - 1);
        return factors;

    }

    public static void helper(int n, List<List<Integer>> factors, int num, List<Integer> res) {
        if (n == 1) {
            factors.add(new ArrayList<Integer>(res));
            return;
        }
        for (int i = num; i <= n; i++) {
            if ((n % i) == 0) {
                res.add(i);
                helper(n / i, factors, i, res);
                res.remove(res.size() - 1);
            }
        }
        return;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Integer>> arr = getFactors(n);
        System.out.print(arr.toString());
        sc.close();
    }
}