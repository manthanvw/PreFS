/*Cliff Shaw is working on the singly linked list.
He is given a list of boxes arranged as singly linked list,
where each box is printed a positive number on it.

Your task is to help Mr Cliff to find the given list is equivalent to 
the reverse of it or not. If yes, print "true", otherwise print "false"

Sample Node:
============
class Node{    
	int data;    
	Node next;    
	public Node(int data) {    
		this.data = data;    
		this.next = null;    
	}    
}    

Input Format:
-------------
Line-1: space separated integers, boxes as list.

Output Format:
--------------
Print a boolean a value.


Sample Input-1:
---------------
3 6 2 6 3

Sample Output-1:
----------------
true


Sample Input-2:
---------------
3 6 2 3 6

Sample Output-2:
----------------
false
 */
import java.util.Stack;

class Node{
    Node next;
    int data;
    Node(int data,Node next){
        this.data = data;
        this.next = next;
    }
}
public class  LinkedListPalindrome{
    public static void main(String[] args) {
        
    }
    boolean isPalindromeExtraSpace(Node head){
        //Implement your logic here.
        Node temp = head;
        Stack<Integer> st = new Stack<>();
        int len = 0;
        while(temp!=null){
            len++;
            temp = temp.next;
        }
        int count = 0;
        temp = head;
        while(count < len/2){
            st.push(temp.data);
            temp = temp.next;
            count++;
        }
        if(len%2!=0) temp = temp.next;
        while(temp!=null){
            if(st.peek() == temp.data) st.pop();
            else return false;
            temp = temp.next;
        }
        if(st.isEmpty()) return true;
        return false;
    }
    boolean isPalindrome(Node head) 
    {
        //Implement your logic here.
        Node temp = head;
        Node prev = null, curr = null,next = null;
        int len = 0;
        while(temp!=null){
            len++;
            temp=temp.next;
        }
        int count=0;
        temp = head;
        while(count<len/2){
            temp=temp.next;
            count++;
        }
        if(len%2 != 0) temp = temp.next;
        curr = temp;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        temp = prev;
        Node temp1 = head;
        while(temp!=null){
            if(temp1.data != temp.data) return false;
            temp = temp.next;
            temp1 = temp1.next;
        }
        return true;
        
    }    
}