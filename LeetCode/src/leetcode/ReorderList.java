package leetcode;

public class ReorderList {
	public static void main(String[] args) {
		ReorderList rl = new ReorderList();
		ListNode head = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		ListNode five = new ListNode(5);
		ListNode six = new ListNode(6);
		ListNode seven = new ListNode(7);
		ListNode eight = new ListNode(8);
		head.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		five.next = six;
		six.next = seven;
		// seven.next = eight;

		rl.reorderList(head);
		System.out.println(head);

	}

	public void reorderList(ListNode head) {
		if (head == null || head.next == null) {
			return;
		}
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null && fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode tail = slow.next;
		slow.next = null;

		slow = reverseList(tail);
		
		//merger the linkedlist
		ListNode p1 = head;
		ListNode p2 = slow;
		while (p2 != null) {
			ListNode tmp1 = p1.next;
			ListNode tmp2 = p2.next;
			p1.next = p2;
			p2.next = tmp1;
			p1 = tmp1;
			p2 = tmp2;
		}
	}

	// reverse the linkedlist
	private ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode pre = head;
		ListNode p = head.next;
		while (p != null) {
			ListNode tmp = p.next;
			p.next = pre;
			pre = p;
			p = tmp;
		}
		head.next = null;
		return pre;
	}
}
