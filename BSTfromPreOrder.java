/*
Given a preorder traversal of a tree as an array of integers arr[].
Construct a binary search tree for the above tree using arr[].

Note: 
    A binary search tree is a binary tree where for every node, any 
    descendant of Node.left has a value strictly less than Node.data, and 
    any descendant of Node.right has a value strictly greater than Node.data.
     
    A preorder traversal of a binary tree displays the value of the node first, 
    then traverses Node.left, then traverses Node.right.

Your task is to print the level order traversal of binary search tree that
has been constructed using the pre order values of a binary tree.

NOTE:
-----
In the output, all null nodes in the level order traversal have to be printed
as -1, if there are any non NULL Nodes existing to thier right side in that level.


Input Format:
-------------
Line-1: Size of array n
Line-2: Array elements of size n.

Output Format:
--------------
Print the level order traversal


Sample Input-1:
---------------
6
10 6 2 8 12 16

Sample Output-1:
----------------
10 6 12 2 8 -1 16


Sample Input-2:
---------------
2
3 5

Sample Output-2:
----------------
3 -1 5


Sample Input-3:
---------------
5
1 2 3 4 5

Sample Output-3:
----------------
1 -1 2 -1 3 -1 4 -1 5 
 */
import java.util.*;
public class BSTfromPreOrder {
    static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    Node root;

    public void insert(int data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data)
            root.left = insertRec(root.left, data);
        else if (data > root.data)
            root.right = insertRec(root.right, data);

        return root;
    }

    public void levelOrderTraversal() {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            if (tempNode.left != null)
                queue.add(tempNode.left);

            if (tempNode.right != null)
                queue.add(tempNode.right);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BSTfromPreOrder tree = new BSTfromPreOrder();
        int n =sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        for (int i = 0; i < n; i++)
            tree.insert(arr[i]);
        tree.levelOrderTraversal();
        sc.close();
    }
}


