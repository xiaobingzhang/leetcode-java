 

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {

	public static void main(String[] args) {
		/*
		 * TreeNode root = new TreeNode(1); TreeNode two = new TreeNode(2);
		 * TreeNode three = new TreeNode(3); root.right = two; two.left = three;
		 */
		TreeNode root1 = new TreeNode(1);
		TreeNode root2 = new TreeNode(2);
		TreeNode root3 = new TreeNode(3);
		TreeNode root4 = new TreeNode(4);
		TreeNode root5 = new TreeNode(5);
		TreeNode root6 = new TreeNode(6);
		TreeNode root7 = new TreeNode(7);

		root1.left = root2;
		root1.right = root3;
		root2.left = root4;
		root2.right = root5;

		root3.left = root6;
		root3.right = root7;
		BinaryTreePreorderTraversal btpt = new BinaryTreePreorderTraversal();
		List<Integer> ret = btpt.preorderTraversal_Iteratively(root1);
		for (Integer i : ret) {
			System.out.print(i + " ");
		}
		System.out.println();
		ret = btpt.levelpreorderTraversal_Iteratively3(root1);
		for (Integer i : ret) {
			System.out.print(i + " ");
		}

	}

	public List<Integer> levelpreorderTraversal_Iteratively3(TreeNode root) {//bfs
		if (root == null) {
			return null;
		}
		List<Integer> ret = new ArrayList<Integer>();
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		ret.add(root.val);
		while (!queue.isEmpty()) {
			TreeNode cur = queue.remove();
			if (cur.left != null) {
				queue.add(cur.left);
				ret.add(cur.left.val);
			}
			if (cur.right != null) {
				queue.add(cur.right);
				ret.add(cur.right.val);
			}
		}
		return ret;
	}

	public List<Integer> preorderTraversal_Iteratively2(TreeNode root) {
		List<Integer> ret = new ArrayList<Integer>();
		if (root == null) {
			return ret;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (root != null || !stack.isEmpty()) {
			if (root != null) {
				ret.add(root.val);
				stack.push(root);
				root = root.left;
			} else {
				root = stack.pop();
				root = root.right;
			}
		}
		return ret;
	}

	public List<Integer> inorderTraversal_Iteratively2(TreeNode root) {
		List<Integer> ret = new ArrayList<Integer>();
		if (root == null) {
			return ret;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (root != null || !stack.isEmpty()) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			} else {
				root = stack.pop();
				ret.add(root.val);
				root = root.right;
			}
		}
		return ret;
	}

	public List<Integer> preorderTraversal_Iteratively(TreeNode root) {
		List<Integer> ret = new ArrayList<Integer>();
		if (root == null) {
			return ret;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.peek();
			ret.add(node.val);
			stack.pop();
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
		}
		return ret;
	}

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> ret = new ArrayList<Integer>();

		preorderTraversal_rec(root, ret);
		return ret;
	}

	private void preorderTraversal_rec(TreeNode root, List<Integer> ret) {
		if (root != null) {
			ret.add(root.val);
			preorderTraversal_rec(root.left, ret);
			preorderTraversal_rec(root.right, ret);
		}
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.valueOf(val);
	}
}