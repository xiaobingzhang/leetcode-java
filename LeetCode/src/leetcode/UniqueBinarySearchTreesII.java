 

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {
	public static void main(String[] args) {

	}

	public List<TreeNode> generateTrees(int n) {
		return genTrees(1, n);
	}

	private List<TreeNode> genTrees(int start, int end) {
		List<TreeNode> ret = new ArrayList<TreeNode>();
		if (start > end) {
			ret.add(null);
			return ret;
		}

		if (start == end) {
			ret.add(new TreeNode(start));
			return ret;
		}
		for (int i = start; i <= end; i++) {

			List<TreeNode> left = genTrees(start, i - 1);
			List<TreeNode> right = genTrees(i + 1, end);
			for (TreeNode lnode : left) {
				for (TreeNode rnode : right) {
					TreeNode root = new TreeNode(i);
					root.left = lnode;
					root.right = rnode;
					ret.add(root);
				}
			}
		}

		return ret;
	}

}
