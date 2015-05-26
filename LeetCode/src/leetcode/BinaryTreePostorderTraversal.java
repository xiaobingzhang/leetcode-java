 

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
	public static void main(String[] args) {
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
		BinaryTreePostorderTraversal btpt = new BinaryTreePostorderTraversal();
		List<Integer> ret = btpt.postorderTraversal_Iteratively(root1);
		for (Integer i : ret) {
			System.out.println(i + " ");
		}
	}

	public List<Integer> postorderTraversal_Iteratively(TreeNode root) {
		List<Integer> ret = new ArrayList<Integer>();
		if (root == null) {
			return ret;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Stack<TreeNode> output = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			output.push(node);

			if (node.left != null) {
				stack.push(node.left);
			}
			if (node.right != null) {
				stack.push(node.right);
			}
		}
		while (!output.isEmpty()) {
			ret.add(output.pop().val);
		}
		return ret;
	}

	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> ret = new ArrayList<Integer>();

		postorderTraversal_rec(root, ret);
		return ret;
	}

	private void postorderTraversal_rec(TreeNode root, List<Integer> ret) {
		if (root != null) {
			postorderTraversal_rec(root.left, ret);
			postorderTraversal_rec(root.right, ret);
			ret.add(root.val);
		}
	}
}
