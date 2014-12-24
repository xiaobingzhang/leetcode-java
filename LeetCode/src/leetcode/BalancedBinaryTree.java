package leetcode;

import java.util.Stack;

public class BalancedBinaryTree {
	public static void main(String[] args) {
		BalancedBinaryTree bbt = new BalancedBinaryTree();
		TreeNode root = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode six = new TreeNode(6);
		TreeNode seven = new TreeNode(7);
		// root.right = two;
		// two.right = three;

		root.left = two;
		root.right = three;
		two.left = four;
		two.right = five;

		five.left = six;
		six.right = seven;
		int ret = bbt.maxDepthItera(root);
		System.out.println();
		System.out.println(ret);
		bbt.postorderTraversal_rec(root);
		System.out.println();
		System.out.println(bbt.isBalanced(root));
		System.out.println(bbt.isBalanced2(root));
	}

	/****************************/
	// answer
	boolean ret = true;
	public boolean isBalanced2(TreeNode root) {
		isBalanced_helper(root);
		return ret;
	}

	public int isBalanced_helper(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftDep = isBalanced_helper(root.left);
		int rightDep = isBalanced_helper(root.right);
		int diff = leftDep - rightDep;
		if (diff < -1 || diff > 1) {
			ret = false;
		}
		return Math.max(leftDep, rightDep) + 1;
	}
	/****************************/
	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		int dif = left - right;
		if (dif > 1 || dif < -1) {
			return false;
		}
		return isBalanced(root.left) && isBalanced(root.right);
	}

	// 求树的深度，递归版本
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftDep = maxDepth(root.left);
		int rightDep = maxDepth(root.right);
		return (leftDep > rightDep) ? (leftDep + 1) : (rightDep + 1);
	}

	public void postorderTraversal_rec(TreeNode root) {
		if (root != null) {
			postorderTraversal_rec(root.left);
			postorderTraversal_rec(root.right);
			System.out.print(root.val);
		}
	}

	public int maxDepthItera(TreeNode root) {

		if (root == null) {
			return 0;
		}
		int ret = Integer.MIN_VALUE;
		Stack<TreeNode> s = new Stack<TreeNode>();
		int dep = 0;
		TreeNode pre = null;
		while (root != null || !s.isEmpty()) {
			if (root != null) {
				// pre order
				// System.out.print(root.val);
				s.push(root);
				dep++;
				root = root.left;
			} else {
				root = s.peek();
				if (root.left == null && root.right == null) {
					ret = Math.max(ret, dep);
				}
				if (root.right != null && root.right != pre) {
					root = root.right;
				} else {
					s.pop();
					// post order
					System.out.print(root.val);
					pre = root;
					dep--;
					root = null;
				}
			}
		}
		return ret;
	}

}
