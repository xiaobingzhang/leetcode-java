package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class SumRoottoLeafNumbers {
	public static void main(String[] args) {
		SumRoottoLeafNumbers srln = new SumRoottoLeafNumbers();
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
		three.left = six;
		three.right = seven;
		int ret = srln.sumNumbers(root);
		System.out.println(ret);
		ret = srln.sumNumbers2(root);
		System.out.println(ret);
	}

		
	// iterative --bfs
	public int sumNumbers3(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int ret = 0;
		LinkedList<TreeNode> q = new LinkedList<TreeNode>();
		LinkedList<Integer> sumRet = new LinkedList<Integer>();
		q.add(root);
		sumRet.add(root.val);
		while (!q.isEmpty()) {
			TreeNode node = q.remove();
			int parSum = sumRet.remove();
			if (node.left == null && node.right == null) {
				ret += parSum;
			} else {
				if (node.left != null) {
					q.add(node.left);
					sumRet.add(parSum * 10 + node.left.val);
				}
				if (node.right != null) {
					q.add(node.right);
					sumRet.add(parSum * 10 + node.right.val);
				}
			}
		}
		return ret;
	}

	public int sumNumbers2(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int sum = 0;
		Stack<Boolean> stack = new Stack<Boolean>();
		List<TreeNode> list = new ArrayList<TreeNode>();
		while (root != null || !stack.isEmpty()) {
			if (root != null) {
				list.add(root);
				stack.push(false);
				root = root.left;
			} else {
				TreeNode top = list.get(list.size() - 1);
				if (!stack.peek()) {// not the null node
					stack.pop();
					stack.push(true);
					root = top.right;
				} else {
					if (top.left == null && top.right == null) {
						int tmp = 0;
						for (TreeNode t : list) {
							tmp = 10 * tmp + t.val;
						}
						sum += tmp;
					}
					list.remove(list.size() - 1);
					stack.pop();
					root = null;
				}
			}
		}
		return sum;
	}

	public int sumNumbers(TreeNode root) {
		int ret = allSum(root, 0);
		return ret;
	}

	private int allSum(TreeNode root, int sum) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return sum * 10 + root.val;
		} else {
			return allSum(root.left, sum * 10 + root.val)
					+ allSum(root.right, sum * 10 + root.val);
		}
	}
}
