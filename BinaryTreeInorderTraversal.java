 

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> ret = new ArrayList<Integer>();
		inorderTraversal_rec(root, ret);
		return ret;
	}

	private void inorderTraversal_rec(TreeNode root, List<Integer> ret) {
		if (root != null) {
			inorderTraversal_rec(root.left, ret);
			ret.add(root.val);
			inorderTraversal_rec(root.right, ret);
		}
	}

	public List<Integer> inorderTraversal_Iteratively(TreeNode root) {
		List<Integer> ret = new ArrayList<Integer>();
		if (root == null) {
			return ret;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (!stack.isEmpty() || root != null) {
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
}
