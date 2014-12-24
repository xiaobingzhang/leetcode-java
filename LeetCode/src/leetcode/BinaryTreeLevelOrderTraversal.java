package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
	public static void main(String[] args) {
		BinaryTreeLevelOrderTraversal btot = new BinaryTreeLevelOrderTraversal();
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
		System.out.println("--");
		List<List<Integer>> ret = btot.levelOrder(root);
		for (List<Integer> list : ret) {
			for (Integer i : list) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

	// 使用List记录下一层的node信息，然后依次遍历
	public List<List<Integer>> levelOrder1(TreeNode root) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if (root == null) {
			return ret;
		}
		List<TreeNode> cur = new ArrayList<TreeNode>();
		cur.add(root);
		while (cur.size() > 0) {
			List<TreeNode> next = new ArrayList<TreeNode>();
			List<Integer> numList = new ArrayList<Integer>();
			for (TreeNode node : cur) {
				numList.add(node.val);
				if (node.left != null) {
					next.add(node.left);
				}
				if (node.right != null) {
					next.add(node.right);
				}
				cur = next;
			}
			ret.add(numList);
		}
		return ret;
	}
//use a dump node as the seprate
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if (root == null) {
			return ret;
		}
		LinkedList<TreeNode> q = new LinkedList<TreeNode>();
		List<Integer> tmpList = new ArrayList<Integer>();
		TreeNode dump = new TreeNode(0);
		q.add(root);
		q.add(dump);
		while (q.size()>1) {
			TreeNode node = q.pop();
			if (node == dump) {
				q.add(dump);
				ret.add(tmpList);
				tmpList = new ArrayList<Integer>();
			} else {
				if (node.left != null) {
					q.add(node.left);
				}
				if (node.right != null) {
					q.add(node.right);
				}
				tmpList.add(node.val);
			}
		}
		//last level data
		ret.add(tmpList);
		return ret;
	}
}
