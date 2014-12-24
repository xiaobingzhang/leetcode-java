package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SymmetricTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode two1 = new TreeNode(2);
		TreeNode two2 = new TreeNode(2);
		TreeNode three1 = new TreeNode(3);
		TreeNode three2 = new TreeNode(3);
		TreeNode four1 = new TreeNode(4);
		TreeNode four2 = new TreeNode(4);
		root.left = two1;

		root.right = two2;

		two1.left = three1;
		two1.right = four1;
		two2.left = four2;
		two2.right = three2;

		SymmetricTree st = new SymmetricTree();
		boolean ret = st.isSymmetric1(root);
		System.out.println(ret);
	}

	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isSymmetricHelper(root.left, root.right);

	}

	private boolean isSymmetricHelper(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		}
		if ((left == null || right == null) || (left.val != right.val)) {
			return false;
		}

		return isSymmetricHelper(left.left, right.right)
				&& isSymmetricHelper(left.right, right.left);
	}

	// use two stack to record
	public boolean isSymmetric2(TreeNode root) {
		if (root == null) {
			return true;
		}
		Stack<TreeNode> s1 = new Stack<TreeNode>();
		Stack<TreeNode> s2 = new Stack<TreeNode>();
		s1.push(root.left);
		s2.push(root.right);
		while (!s1.isEmpty() && !s2.isEmpty()) {
			TreeNode node1 = s1.pop();
			TreeNode node2 = s2.pop();
			if (node1 == null && node2 == null) {
				continue;
			}
			if (node1 == null || node2 == null) {
				return false;
			}
			if ((node1.val != node2.val)) {
				return false;
			}
			s1.push(node1.left);
			s1.push(node1.right);
			s2.push(node2.right);
			s2.push(node2.left);
		}
		return true;
	}

	// my ac code
	public boolean isSymmetric1(TreeNode root) {
		if (root == null) {
			return true;
		}
		TreeNode dump = null;//
		List<TreeNode> cur = new ArrayList<TreeNode>();
		cur.add(root);
		while (!cur.isEmpty()) {
			List<TreeNode> next = new ArrayList<TreeNode>();
			boolean flag = false;
			for (TreeNode node : cur) {
				if (node != null) {
					if (node.left != null) {
						next.add(node.left);
						flag = true;
					} else {
						next.add(dump);
					}
					if (node.right != null) {
						flag = true;
						next.add(node.right);
					} else {
						next.add(dump);
					}
				}
			}
			for (int i = 0, j = cur.size() - 1; i < j; i++, j--) {
				TreeNode node1 = cur.get(i);
				TreeNode node2 = cur.get(j);
				if (node1 == null && node2 == null) {
					continue;
				}
				if (node1 == null || node2 == null) {
					return false;
				}
				if ((node1.val != node2.val)) {
					return false;
				}
			}
			if (flag == true) {
				cur = next;
			} else {
				cur = new ArrayList<TreeNode>();
			}
		}
		return true;
	}

}
