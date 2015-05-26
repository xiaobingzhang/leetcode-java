 

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeLevelOrderTraversalII {
	public static void main(String[] args) {
		BinaryTreeLevelOrderTraversalII btot = new BinaryTreeLevelOrderTraversalII();
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
		List<List<Integer>> ret = btot.levelOrderBottom(root);
		for (List<Integer> list : ret) {
			for (Integer i : list) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

	// 使用List记录下一层的node信息，然后依次遍历
	public List<List<Integer>> levelOrderBottom2(TreeNode root) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		Stack<List<Integer>> stack = new Stack<List<Integer>>();
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
			stack.add(numList);
		}
		while(stack.size()>0){
			List<Integer> tmp1= stack.pop();
			ret.add(tmp1);
		}
		return ret;
	}
//use a dump node as the seprate
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if (root == null) {
			return ret;
		}
		Stack<List<Integer>> stack = new Stack<List<Integer>>();
		LinkedList<TreeNode> q = new LinkedList<TreeNode>();
		List<Integer> tmpList = new ArrayList<Integer>();
		TreeNode dump = new TreeNode(0);
		q.add(root);
		q.add(dump);
		while (q.size()>1) {
			TreeNode node = q.pop();
			if (node == dump) {
				q.add(dump);
				stack.add(tmpList);
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
		stack.add(tmpList);
		while(stack.size()>0){
			List<Integer> tmp1= stack.pop();
			ret.add(tmp1);
		}
		return ret;
	}
}
