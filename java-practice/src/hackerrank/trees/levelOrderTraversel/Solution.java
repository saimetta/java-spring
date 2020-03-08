package hackerrank.trees.levelOrderTraversel;

import java.util.*;
import java.io.*;

class Solution {

	/* 
    
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static void levelOrder(Node root) {
        List<Node> queue  = new ArrayList<Node>();
        List<String> results = new ArrayList<String>();
		//Queue root data
        queue.add(root);
		//iterate while queue has something
        while(queue.size() > 0) {
        	Node popedNode = queue.remove(0);
        	results.add(Integer.toString(popedNode.data));
        	if (popedNode.left != null) {
        		queue.add(popedNode.left);
        	}
        	if (popedNode.right != null) {
        		queue.add(popedNode.right);
        	}
        }
        System.out.println(String.join(" ", results));
    }

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        levelOrder(root);
    }	
}