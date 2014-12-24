package leetcode;

public class ConvertSortedArraytoBinarySearchTree {
	public static void main(String[] args) {
		ConvertSortedArraytoBinarySearchTree c = new ConvertSortedArraytoBinarySearchTree();
		int[] num = { 1, 2, 3, 4, 5, 6, 7, 8 };
		TreeNode t = c.sortedArrayToBST(num);
		// System.out.println(t);
	}

	public TreeNode sortedArrayToBST(int[] num) {
		return addTreeNode(num, 0, num.length - 1);
	}

	public TreeNode addTreeNode(int[] num, int low, int high) {
		if (low > high) {
			return null;
		}
		int mid = low + (high - low) / 2;
		TreeNode root = new TreeNode(num[mid]);
		root.left = addTreeNode(num, low, mid - 1);
		root.right = addTreeNode(num, mid + 1, high);
		return root;
	}


}
