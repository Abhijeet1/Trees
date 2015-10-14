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

