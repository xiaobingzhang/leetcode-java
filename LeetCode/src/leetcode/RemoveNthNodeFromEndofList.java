package leetcode;

public class RemoveNthNodeFromEndofList {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		ListNode five = new ListNode(5);
		head.next = two;
		 two.next = three;
		 three.next = four;
		four.next = five;
		reverse(head);
		removeNthFromEnd(head, 1);
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null) {
			return null;
		}
		ListNode begin = new ListNode(0);
		begin.next = head;
		ListNode node1 = begin;
		ListNode node2 = begin;
		for (int i = 1; i <= n; i++) {
			node1 = node1.next;
		}
		while (node1 != null && node1.next != null) {
			node1 = node1.next;
			node2 = node2.next;
		}
		node2.next = node2.next.next;
		return begin.next;

	}

	public static ListNode reverse(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode begin = new ListNode(0);
		begin.next = head;

		ListNode current;
		ListNode p;
		current = begin.next;
		while (current.next != null) {
			p = current.next;
			current.next = p.next;
			p.next = begin.next;
			begin.next = p;
		}
		return begin.next;
	}
}
