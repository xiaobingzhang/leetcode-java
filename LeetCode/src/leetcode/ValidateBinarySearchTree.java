package leetcode;

import java.util.Stack;

public class ValidateBinarySearchTree {
	public static void main(String[] args) {
		ValidateBinarySearchTree vbst = new ValidateBinarySearchTree();
		TreeNode root = new TreeNode(0);
		TreeNode root1 = new TreeNode(-1);
		root.left = root1;
		boolean ret = vbst.isValidBST(root);
		System.out.println(ret);
	}

	public boolean isValidBST(TreeNode root) {
		return isValidBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isValidBSTHelper(TreeNode root, int minValue, int maxValue) {
		if (root == null) {
			return true;
		}
		if (minValue < root.val && root.val < maxValue) {
			return isValidBSTHelper(root.left, minValue, root.val)
					&& isValidBSTHelper(root.right, root.val, maxValue);
		}
		return false;
	}

	public boolean isValidBST1(TreeNode root) {// 直接中序遍历即可
		Stack<TreeNode> s = new Stack<TreeNode>();
		int pre = Integer.MIN_VALUE;//
		int cur;
		while (!s.isEmpty() || root != null) {
			if (root != null) {
				s.push(root);
				root = root.left;
			} else {
				root = s.pop();
				cur = root.val;
				if (pre >= cur) {
					return false;
				}
				pre = cur;
				root = root.right;
			}
		}
		return true;
	}
}
