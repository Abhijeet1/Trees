package org.jeet.learn;

public class BSTToDLL {

	public static void main(String[] args) {
		Node n1 = new Node(10);
		Node n2 = new Node(6);
		Node n3 = new Node(8);
		Node n4 = new Node(4);
		Node n5 = new Node(15);
		n1.left = n2;
		n2.left = n4;
		n2.right = n3;
		n1.right = n5;
		inOrder(n1);
		Node head = treeToDLL(n1);
		printList(head);
	}

	
	private static void printList(Node head) {
		// TODO Auto-generated method stub
		if(head == null){
			return;
		}
		
		while(head != null){
			System.out.print(" " + head.data);
			head = head.right;
		}
	}


	private static Node treeToDLL(Node n1) {
		// TODO Auto-generated method stub
		if(n1 == null)
			return null;
		
		Node lTree = treeToDLL(n1.left);
		Node rTree = treeToDLL(n1.right);
		
		n1.left = null;
		n1.right = null;
		
		rTree = append(n1,rTree);
		lTree = append(lTree,n1);
		
		
		return lTree;
	}


	private static Node append(Node n1, Node n2) {
		// TODO Auto-generated method stub
		if(n1 == null && n2 == null)
			return null;
		
		if(n1 == null)
			return n2;
		
		if(n2 == null)
			return n1;
		
		Node p = n1.right;
		Node temp = n1;
		
		while(p!=null){
			temp = p;
			p = p.right;
		}
		temp.right = n2;
		
		return n1;
	}


	public static void inOrder(Node root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print("  " + root.data);
			inOrder(root.right);
		}
	}
	
	static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;			
		}
	}
}
