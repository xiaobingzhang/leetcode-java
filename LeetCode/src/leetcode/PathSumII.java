 

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PathSumII {
	public static void main(String[] args) {
		PathSumII ps = new PathSumII();
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

		List<List<Integer>> ret = ps.pathSum2(root, 10);
		System.out.println(ret);
	}

	public List<List<Integer>> pathSum2(TreeNode root, int sum) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if (root == null) {
			return ret;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		int cnt = 0;
		TreeNode pre = null;
		while (root != null || !stack.isEmpty()) {
			if (root != null) {
				stack.push(root);
				cnt += root.val;
				root = root.left;
			} else {
				root = stack.peek();
				// resolve the leaf node
				if (root.left == null && root.right == null && cnt == sum) {
					List<Integer> tmp = new ArrayList<Integer>();
					for (TreeNode tn : stack) {
						tmp.add(tn.val);
					}
					ret.add(tmp);
				}
				if (root.right != null && root.right != pre) {// pre is the
																// postOrder pre
																// node if is pre node pop
					root = root.right;
				} else {
					stack.pop();
					pre = root;
					cnt -= root.val;
					root = null;
				}
			}
		}
		return ret;
	}

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if (root == null) {
			return ret;
		}
		Stack<Boolean> stack = new Stack<Boolean>();
		List<TreeNode> nodeList = new ArrayList<TreeNode>();
		List<Integer> numList = new ArrayList<Integer>();
		while (root != null || !stack.isEmpty()) {
			if (root != null) {
				nodeList.add(root);
				numList.add(root.val);
				stack.push(false);
				root = root.left;
			} else {
				TreeNode top = nodeList.get(nodeList.size() - 1);
				if (!stack.peek()) {
					stack.pop();
					stack.push(true);
					root = top.right;
				} else {
					if (top.left == null && top.right == null) {
						int tmp = 0;
						for (Integer num : numList) {
							tmp += num;
						}
						if (tmp == sum) {
							ret.add(new ArrayList<>(numList));
						}
					}
					nodeList.remove(nodeList.size() - 1);
					numList.remove(numList.size() - 1);
					stack.pop();
					root = null;
				}

			}
		}
		return ret;
	}
}
