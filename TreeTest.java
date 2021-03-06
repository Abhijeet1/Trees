package org.jeet.learn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testInOrderRecursive();
		testpreOrderRecursive();
		testpostOrderRecursive();
		testInOrderIterative();
		testpreOrderIterative();
		testpostOrderIterative();
		levelOrderIterative();
		testSize();
		testHeight();
		testInOrderSuccessor();
	}

	private static void testInOrderSuccessor() {
		// TODO Auto-generated method stub
		newLine();
		Tree tree = createTree();
		tree.inOrderSuccessor(new TreeNode(8));
	}

	private static void testHeight() {
		// TODO Auto-generated method stub
		newLine();
		Tree tree = createTree();
		int i = tree.height(tree.root);
		System.out.println("Height-->" + i);
	}

	private static void testSize() {
		// TODO Auto-generated method stub
		newLine();
		Tree tree = createTree();
		int i = tree.size(tree.root);
		System.out.println("Size-->" + i);
	}

	private static void levelOrderIterative() {
		// TODO Auto-generated method stub
		newLine();
		Tree tree = createTree();
		tree.levelOrder();
	}
	
	private static void testpostOrderIterative() {
		// TODO Auto-generated method stub
		newLine();
		Tree tree = createTree();
		tree.postOrderIterative();
	}

	private static void testpreOrderIterative() {
		// TODO Auto-generated method stub
		newLine();
		Tree tree = createTree();
		tree.preOrderIterative();
	}

	private static void testInOrderIterative() {
		// TODO Auto-generated method stub
		newLine();
		Tree tree = createTree();
		tree.iterativeInOrder();
	}

	public static Tree createTree() {
		TreeNode node = new TreeNode(10);
		Tree tree = new Tree(node);
		TreeNode eight = new TreeNode(8);
		TreeNode nine = new TreeNode(9);
		TreeNode six = new TreeNode(6);
		TreeNode fifteen = new TreeNode(15);
		TreeNode eleven = new TreeNode(11);
		TreeNode sixteen = new TreeNode(16);
		node.left = eight;
		node.right = fifteen;
		fifteen.left = eleven;
		fifteen.right = sixteen;
		eight.left = six;
		eight.right = nine;
		return tree;
	}

	public static void newLine() {
		System.out.println();
	}

	public static void testInOrderRecursive() {
		newLine();
		System.out.println("In Order-->");
		Tree tree = createTree();
		tree.inOrder(tree.root);
	}

	public static void testpreOrderRecursive() {
		newLine();
		System.out.println("Pre Order-->");
		Tree tree = createTree();
		tree.preOrder(tree.root);
	}

	public static void testpostOrderRecursive() {
		newLine();
		System.out.println("Post Order-->");
		Tree tree = createTree();
		tree.postOrder(tree.root);
	}
}

class TreeNode {
	public TreeNode left;
	public TreeNode right;
	public int value;

	public TreeNode(int value) {
		this.value = value;
	}
}

class Tree {
	public TreeNode root;

	public Tree(TreeNode root) {
		this.root = root;
	}

	public void inOrderSuccessor(TreeNode node) {
		// TODO Auto-generated method stub
		TreeNode temp = node;
		Stack<TreeNode> st = new Stack<TreeNode>();
		boolean done = false;
		
		while(!done){
			
			while(node != null)
			{
		
				node = node.left;
			}
			
			if(st.empty()){
				done = true;
				continue;
			}else{
				node = st.pop();
				if(node.value == temp.value){
					System.out.println("XXXXXXXXXX");
					TreeNode parent = st.pop();
					if(parent.right == null)
					{
						System.out.println("Successor is-->" + parent.value);
					}
					else
					{
						TreeNode child = parent.right;
						while(child.left != null)
							child = child.left;
						System.out.println("Successor is-->" + child.value);
					}
					done = true;
					continue;
				}
				//System.out.print(" " + node.value);
			}
			
			
			if(node.right != null)
				node = node.right;
			else
				node = null;
			
			
		}
		
		System.out.println("InOrder Successor for a Node-->" + temp.value );
		
	}

	public int height(TreeNode node) {
		// TODO Auto-generated method stub
		if(node == null)
			return 0;
		
		int hl = height(node.left);
		int hr = height(node.right);
		
		return 1 + max(hl,hr);
	}

	private int max(int a, int b) {
		// TODO Auto-generated method stub
		if(a>b)
			return a;
		else
			return b;
	}

	public int size(TreeNode node) {
		// TODO Auto-generated method stub
		if(node == null)
			return 0;
		
		return 1 + size(node.left) + size(node.right);
	}

	public void iterativeInOrder() {
		// TODO Auto-generated method stub
		System.out.println("Iterative In Order-->");
		TreeNode node = this.root;
		Stack<TreeNode> st = new Stack<TreeNode>();
		//st.push(node);
		boolean done = false;
		
		while (!done) {

			

			while (node != null) {
				st.push(node);
				node = node.left;
			}

			if(st.empty()){
				done = true;
				continue;
			}else{
				node = st.pop();
				System.out.print(" " + node.value);
			}
			
			
			if(node.right != null)
				node = node.right;
			else
				node = null;
			
		}
	}

	public void preOrderIterative() {
		// TODO Auto-generated method stub

		System.out.println("Pre Order Iterative-->");
		TreeNode node = this.root;
		Stack<TreeNode> st = new Stack<TreeNode>();
		st.push(node);

		while (!st.empty()) {
			node = st.pop();
			
			System.out.print(" " + node.value);	
			
			if(node.right != null)
				st.push(node.right);
			
			if(node.left != null)
				st.push(node.left);
		}

	}

	public void postOrderIterative() {
		// TODO Auto-generated method stub
		System.out.println("Iterative Post Order-->");
		TreeNode node = this.root;
		Stack<TreeNode> st = new Stack<TreeNode>();
		Stack<TreeNode> otp = new Stack<TreeNode>();
		st.push(node);

		while (!st.empty()) {
			node = st.pop();
			
			
			if(node.left != null)
				st.push(node.left);
			
			if(node.right != null)
				st.push(node.right);
			
			otp.push(node);
			//System.out.print(" " + node.value);	
		}
		
		while(!otp.empty())
		{
			System.out.print(" " + otp.pop().value);
		}
		
	}

	public void preOrder(TreeNode root) {
		if (root == null)
			return;
		System.out.print(" " + root.value);
		preOrder(root.left);
		preOrder(root.right);

	}

	public void inOrder(TreeNode root) {
		if (root == null)
			return;
		inOrder(root.left);
		System.out.print(" " + root.value);
		inOrder(root.right);
	}

	public void postOrder(TreeNode root) {
		if (root == null)
			return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(" " + root.value);
	}
	
	public void levelOrder(){
		System.out.println("Level Order traversal-->");
		TreeNode node = this.root;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(node);
		while(!q.isEmpty()){
			node = q.poll();
			System.out.print(" " + node.value);
			if(node.left != null)
				q.add(node.left);
			if(node.right != null)
				q.add(node.right);
		}
	}
}
