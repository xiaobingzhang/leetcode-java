 

import java.util.LinkedList;

public class PopulatingNextRightPointersinEachNodeII {
	public void connect1(TreeLinkNode root) {
		TreeLinkNode head = null;// head of next level
		TreeLinkNode pre = null;// the leading node on the next level
		TreeLinkNode cur = root;// current node of current level

		while (cur != null) {
			while (cur != null) {// iterate on the current level
				// left child
				if (cur.left != null) {
					if (pre != null) {
						pre.next = cur.left;
					} else {
						head = cur.left;
					}
					pre = cur.left;
				}
				// right child
				if (cur.right != null) {
					if (pre != null) {
						pre.next = cur.right;
					} else {
						head = cur.right;
					}
					pre = cur.right;
				}
				// move to next node
				cur = cur.next;
			}
			// move to next level
			cur = head;
			pre = null;
			head = null;
		}
	}
	
	public void connect2(TreeLinkNode root) {
		TreeLinkNode head = new TreeLinkNode(0);
		head.next = root;
		while(head.next !=null){
			
			TreeLinkNode tail = head;
			TreeLinkNode n = head.next;
			head.next = null;
			while(n!=null){
				if(n.left != null){
					tail.next = n.left;
					tail =tail.next;
				}
				if(n.right != null){
					tail.next = n.right;
					tail =tail.next;
				}
				n = n.next;
			}
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
