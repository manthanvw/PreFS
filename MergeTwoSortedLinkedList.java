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

class Node{    
	int data;    
	Node next;    
	public Node(int data) {    
		this.data = data;    
		this.next = null;    
	}    
}  
public class MergeTwoSortedLinkedList {
    public Node mergeTwoLists(Node l1, Node l2){
        Node temp1 = l1; 
        Node temp2 = l2;
        Node head;
        Node temp;
        if(l1.data<=l2.data){
            head = l1;
            temp1 = temp1.next;
        } 
        else{
            head = l2;
            temp2 = temp2.next;
        }
        temp = head;
        while(temp1!=null && temp2!=null){
            if(temp1.data<=temp2.data){
                temp.next = temp1;
                temp = temp.next;
                temp1 = temp1.next;
            }
            else if(temp1.data>temp2.data){
                temp.next = temp2;
                temp = temp.next;
                temp2 = temp2.next;
            }
        }
        while(temp1!=null){
            temp.next = temp1;
            temp = temp.next;
            temp1 = temp1.next;
        }
        while(temp2!=null){
            temp.next = temp2;
            temp = temp.next;
            temp2 = temp2.next;
        }
        return head;
	}
}
