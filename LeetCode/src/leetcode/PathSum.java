 

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PathSum {
	public static void main(String[] args) {
		PathSum ps = new PathSum();
		TreeNode root = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode six = new TreeNode(6);
		TreeNode seven = new TreeNode(7);
		// root.left = two;

		root.right = three;
		/*
		 * two.left = four; two.right = five; three.left = six; three.right =
		 * seven;
		 */
		boolean ret = ps.hasPathSum3(root, 4);
		System.out.println(ret);
	}

	public boolean hasPathSum2(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		Stack<Boolean> stack = new Stack<Boolean>();
		List<TreeNode> list = new ArrayList<TreeNode>();
		while (root != null || !stack.isEmpty()) {
			if (root != null) {
				list.add(root);
				stack.push(false);
				root = root.left;
			} else {
				TreeNode top = list.get(list.size() - 1);
				if (!stack.peek()) {
					stack.pop();
					stack.push(true);
					root = top.right;
				} else {
					if (top.left == null && top.right == null) {
						int tmp = 0;
						for (TreeNode treeNode : list) {
							tmp += treeNode.val;
						}
						if (tmp == sum) {
							return true;
						}
					}
					list.remove(list.size() - 1);
					stack.pop();
					root = null;
				}

			}
		}
		return false;
	}
	//change the node
	public boolean hasPathSum3(TreeNode root, int sum) {
		if(root == null){
			return false;
		}
		if(root.left == null && root.right == null){
			return root.val == sum;
		}
		return hasPathSum3(root.left, sum-root.val) || hasPathSum3(root.right, sum-root.val);
	}

	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		LinkedList<TreeNode> q = new LinkedList<TreeNode>();
		LinkedList<Integer> sumRet = new LinkedList<Integer>();
		q.add(root);
		sumRet.add(root.val);
		while (!q.isEmpty()) {
			TreeNode node = q.remove();
			int partSum = sumRet.remove();
			if (node.left == null && node.right == null) {
				if (partSum == sum) {
					return true;
				}
			}
			if (node.left != null) {
				q.add(node.left);
				sumRet.add(partSum + node.left.val);
			}
			if (node.right != null) {
				q.add(node.right);
				sumRet.add(partSum + node.right.val);
			}
		}
		return false;
	}
}
