package leetcode;

public class ConvertSortedListtoBinarySearchTree {
	public static void main(String[] args) {
		ConvertSortedListtoBinarySearchTree c = new ConvertSortedListtoBinarySearchTree();
		ListNode head1 = new ListNode(1);
		ListNode head2 = new ListNode(2);
		ListNode head3 = new ListNode(3);
		ListNode head4 = new ListNode(4);
		ListNode head5 = new ListNode(5);
		ListNode head6 = new ListNode(6);
		ListNode head7 = new ListNode(7);
		head1.next = head2;
		head2.next = head3;
		head3.next = head4;
		head4.next = head5;
		head5.next = head6;
		head6.next = head7;
		TreeNode t= c.sortedListToBST1(head1);
		System.out.println(t);
	}

	/*
	 *  O(nlgn)
	 */
	public TreeNode sortedListToBST1(ListNode head) {
		int len = countLength(head);
		return addTreeNodeFromTheaList(head, len);
	}

	private int countLength(ListNode head) {
		ListNode temp = head;
		int count = 0;
		while (temp != null) {
			temp = temp.next;
			count++;
		}
		return count;
	}

	private TreeNode addTreeNodeFromTheaList(ListNode head,int len) {
		if(len<=0){
			return null;
		}
		int mid = (1+len)/2;
		ListNode p = head;
		int temp = mid-1;
		while(temp>0){
			p = p.next;
			temp--;
		}
		
		TreeNode root = new TreeNode(p.val);
		root.left = addTreeNodeFromTheaList(head,mid-1);
		root.right = addTreeNodeFromTheaList(p.next,len-mid);
		return root;
	}
	
	//这是最巧妙的一种解决方案，本题还可以把linked 转换成为array
	/*
	 * http://www.geeksforgeeks.org/sorted-linked-list-to-balanced-bst/
	 * Time Complexity: O(n)
	 */
	
	static ListNode staticHead;
	
	public TreeNode sortedListToBST(ListNode head) {
		/* Count the number of nodes in Linked List */
		int n = countLNodes(head);
		staticHead = head;
		/* Construct BST */
		return sortedListToBSTRecur(n);
	}

	/*
	 * The main function that constructs balanced BST and returns root of it.
	 * head_ref --> Pointer to pointer to head node of linked list n --> No. of
	 * nodes in Linked List
	 */
	private TreeNode sortedListToBSTRecur(int n) {
		/* Base Case */
		if (n <= 0) {
			return null;
		}
		/* Recursively construct the left subtree */
		TreeNode left = sortedListToBSTRecur(n / 2);
		/*
		 * Allocate memory for root, and link the above constructed left subtree
		 * with root
		 */
		TreeNode root = new TreeNode(staticHead.val);
		/* Change head pointer of Linked List for parent recursive calls */
		root.left = left;

		staticHead = staticHead.next;
		/*
		 * Recursively construct the right subtree and link it with root The
		 * number of nodes in right subtree is total nodes - nodes in left
		 * subtree - 1 (for root) which is n-n/2-1
		 */
		root.right = sortedListToBSTRecur(n - n / 2 - 1);

		return root;
	}

	private int countLNodes(ListNode head) {
		int count = 0;
		ListNode tmp = head;
		while (tmp != null) {
			tmp = tmp.next;
			count++;
		}
		return count;
	}
}
