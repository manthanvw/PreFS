/*
 * Ram and Bheem, Playing a game.

Games rules are as followed:
    1- Ram picks a number P between 1 to N.
    2- Bheem has to guess a number K between 1 to N
    3- Ram has to say whether it is greaterthan OR lesserthan OR equal to P.
    4- Repeat the rules 2 and 3, till Bheem guess the correct number. 

Your task is to help Bheem to guess P correctly, 
by implementing the method below in class Solution:
    - int bheemsGuess(int N): return an integer, (P value)

NOTE: Can you get the solution (logN) time


INPUT FORMAT:
-------------
Two space separated integers, N and P

OUTPUT FORMAT:
--------------
Print the value of P.


SAMPLE INPUT-1:
---------------
21 18

SAMPLE OUTPUT-1:
----------------
18


SAMPLE INPUT-2:
---------------
21 3

SAMPLE OUTPUT-2:
----------------
3
 */
// import java.util.*;

public class GuessNumber {
    
}

class Game{
    int guess(int k){
        /*
        Game class contains a method guess(int K)-> K is the guess number.
        - guess(K) returns 1, if K is smaller than P, (K < P)
        - guess(K) returns -1, if K is greater than P, (K > P)
        - guess(K) returns 0, if K is equal to P, (K==P)
        */
        return 0;
    }
}
class Solution extends Game {
    public int bheemsGuess(int N) {
        //implemt your code here
        int l = 1,h=N;
        while(l<h){  
            int mid = (l+h)/2;
            int g = guess(mid);
            if(g == 0) return mid;
            else if(g==1) l = mid+1;
            else h = mid;
        }
        return -1;
    }
}
