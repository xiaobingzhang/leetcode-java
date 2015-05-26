 

import java.util.Stack;

public class MaximumDepthofBinaryTree {
	public static void main(String[] args) {
		MaximumDepthofBinaryTree mdb = new MaximumDepthofBinaryTree();
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
		System.out.println(mdb.maxDepthOneLine(root));

	}

	public int maxDepthIterative(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int ret = Integer.MIN_VALUE;
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode pre = null;
		int dep = 0;
		while (root != null || !s.isEmpty()) {
			if (root != null) {
				s.push(root);
				dep++;
				root = root.left;
			} else {
				root = s.peek();
				if (root.left == null && root.right == null) {
					ret = Math.max(ret, dep);
				}
				if (root.right != null && root.right != pre) {
					root=root.right;
				}else{
					s.pop();
					pre = root;
					dep--;
					root = null;
				}
			}
		}
		return ret;

	}

	public int maxDepthOneLine(TreeNode root) {
		return root==null?0:1+Math.max(maxDepthOneLine(root.left), maxDepthOneLine(root.right));
	}
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftDep = maxDepth(root.left);
		int rightDep = maxDepth(root.right);
		return leftDep > rightDep ? leftDep + 1 : rightDep + 1;
	}
}
