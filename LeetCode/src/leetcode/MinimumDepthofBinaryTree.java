 

import java.util.Stack;

public class MinimumDepthofBinaryTree {
	public static void main(String[] args) {
		MinimumDepthofBinaryTree mdobt = new MinimumDepthofBinaryTree();

		TreeNode root = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode six = new TreeNode(6);
		TreeNode seven = new TreeNode(7);

		root.left = two;
		root.right = three;
		two.left = four;
		two.right = five;
		five.left = six;
		six.right = seven;

		int ret = mdobt.minDepth3(root);
		System.out.println(ret);
	}

	public int minDepth3(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftDep = minDepth3(root.left);
		int rightDep = minDepth3(root.right);
		return (leftDep > rightDep) ? (rightDep + 1) : (leftDep + 1);
	}

	public int minDepth2(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int ret = 0;
		if (root.left != null && root.right != null) {
			ret = 1 + Math.min(minDepth2(root.left), minDepth2(root.right));
		} else {
			ret = 1 + minDepth2(root.left) + minDepth2(root.right);
		}
		return ret;
	}

	public int minDepth(TreeNode root) {
		int ret = Integer.MAX_VALUE;
		if (root == null) {
			return 0;
		}
		Stack<TreeNode> s = new Stack<TreeNode>();
		int cnt = 0;
		TreeNode pre = null;
		while (root != null || !s.isEmpty()) {
			if (root != null) {
				s.push(root);
				cnt++;
				root = root.left;
			} else {
				root = s.peek();
				if (root.left == null && root.right == null) {
					ret = Math.min(ret, cnt);
				}
				if (root.right != null && root.right != pre) {
					root = root.right;
				} else {
					s.pop();
					pre = root;
					cnt--;
					root = null;
				}
			}
		}
		return ret;
	}
}
