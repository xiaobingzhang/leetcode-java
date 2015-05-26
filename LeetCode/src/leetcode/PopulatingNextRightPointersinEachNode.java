 

import java.util.LinkedList;

public class PopulatingNextRightPointersinEachNode {
	public static void main(String[] args) {
		PopulatingNextRightPointersinEachNode pnrpen = new PopulatingNextRightPointersinEachNode();
		TreeLinkNode root1 = new TreeLinkNode(1);
		TreeLinkNode root2 = new TreeLinkNode(2);
		TreeLinkNode root3 = new TreeLinkNode(3);
		TreeLinkNode root4 = new TreeLinkNode(4);
		TreeLinkNode root5 = new TreeLinkNode(5);
		TreeLinkNode root6 = new TreeLinkNode(6);
		TreeLinkNode root7 = new TreeLinkNode(7);

		root1.left = root2;
		root1.right = root3;

		root2.left = root4;
		root2.right = root5;
		root3.left = root6;
		root3.right = root7;
		pnrpen.connect2(root1);
		System.out.println(root1);
	}

	public void connect2(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		connect2(root.left);
		connect2(root.right);
		TreeLinkNode left = root.left;
		TreeLinkNode right = root.right;
		while (left != null) {
			left.next = right;
			left = left.right;
			right = right.left;
		}
	}

	public void connect1(TreeLinkNode root) {
		TreeLinkNode leftWall = root;
		while (leftWall != null) {
			TreeLinkNode across = leftWall;
			while (across != null) {
				if (across.left != null) {
					across.left.next = across.right;
				}
				if (across.right != null && across.next != null) {
					across.right.next = across.next.left;
				}
				across = across.next;
			}
			leftWall = leftWall.left;
		}
	}

	public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		LinkedList<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		queue.add(root);
		root.next = null;
		while (!queue.isEmpty()) {
			LinkedList<TreeLinkNode> pre = queue;
			queue = new LinkedList<TreeLinkNode>();
			for (TreeLinkNode node : pre) {
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
			if (!queue.isEmpty()) {
				for (int i = 0; i < queue.size() - 1; i++) {
					queue.get(i).next = queue.get(i + 1);
				}
				queue.get(queue.size() - 1).next = null;
			}
		}

	}
}

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
}