package leetcode;

public class FlattenBinaryTreetoLinkedList {
	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(1);
		TreeNode root2 = new TreeNode(2);
		TreeNode root3 = new TreeNode(3);
		TreeNode root4 = new TreeNode(4);
		TreeNode root5 = new TreeNode(5);
		TreeNode root6 = new TreeNode(6);

		root1.left = root2;
		root1.right = root5;
		root2.left = root3;
		root2.right = root4;

		root5.right = root6;

		FlattenBinaryTreetoLinkedList fbtll = new FlattenBinaryTreetoLinkedList();
		fbtll.flatten2(root1);
		while (root1 != null) {
			System.out.print(root1.val);
			root1 = root1.right;
		}

	}

/*
 * 只要树中有多出来的分叉（左子树），就嫁接到根节点和右子树之间
 */
	public void flatten2(TreeNode root) {
		while (root != null) {
			if (root.left != null) {
				TreeNode p = root.left;
				while (p.right != null) {
					p = p.right;
				}
				
				p.right = root.right;
				root.right = root.left;
				root.left = null;
				////
			}
			root = root.right;
		}
	}

	TreeNode lastVisit = null;
	public void flatten(TreeNode root) {
		if (root == null) {
			return;
		}
		TreeNode saveRight = root.right;
		if (lastVisit != null) {
			lastVisit.left = null;
			lastVisit.right = root;
		}
		lastVisit = root;
		flatten(root.left);
		flatten(saveRight);
	}

}
