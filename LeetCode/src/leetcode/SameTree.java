package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class SameTree {
	public static void main(String[] args) {
		SameTree st = new SameTree();
		TreeNode p1 = new TreeNode(1);
		TreeNode p2 = new TreeNode(2);
		TreeNode p3 = new TreeNode(3);
		TreeNode p4 = new TreeNode(4);
		TreeNode p5 = new TreeNode(5);
		TreeNode p6 = new TreeNode(6);
		TreeNode p7 = new TreeNode(7);
		p1.left = p2;
		p1.right = p3;
		p2.left = p4;
		p2.right = p5;
		p3.left = p6;
		p3.right = p7;

		TreeNode q1 = new TreeNode(1);
		TreeNode q2 = new TreeNode(2);
		TreeNode q3 = new TreeNode(3);
		TreeNode q4 = new TreeNode(4);
		TreeNode q5 = new TreeNode(5);
		TreeNode q6 = new TreeNode(6);
		TreeNode q7 = new TreeNode(7);
		TreeNode q8 = new TreeNode(7);
		q1.left = q2;
		q1.right = q3;
		q2.left = q4;
		q2.right = q5;
		q3.left = q6;
		q3.right = q7;
		q4.left = q8;

		System.out.println(st.isSameTree(p1, q1));
	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null || q == null) {
			return p == q;
		} else {
			return (p.val == q.val) && isSameTree(p.left, q.left)
					&& isSameTree(p.right, q.right);
		}
	}

	public boolean isSameTree1(TreeNode p, TreeNode q) {
		if (q == null && p == null) {
			return true;
		}
		if ((q == null && p != null) || (p == null && q != null)) {
			return false;
		}

		Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
		queue1.add(p);
		Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
		queue2.add(q);
		while (!queue1.isEmpty() && !queue2.isEmpty()) {
			TreeNode t1 = queue1.remove();
			TreeNode t2 = queue2.remove();
			if (t1.val != t2.val) {
				return false;
			}
			if (t1.left != null && t2.left != null) {
				queue1.add(t1.left);
				queue2.add(t2.left);
			} else if (t1.left == null && t2.left == null) {

			} else {
				return false;
			}
			if (t1.right != null && t2.right != null) {
				queue1.add(t1.right);
				queue2.add(t2.right);
			} else if (t1.right == null && t2.right == null) {

			} else {
				return false;
			}
		}
		if (queue1.isEmpty() && queue2.isEmpty()) {
			return true;
		}
		return false;
	}
}
