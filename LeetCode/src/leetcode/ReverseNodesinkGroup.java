package leetcode;

public class ReverseNodesinkGroup {
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
		reverseKGroup(head, 2);
	}

	public static ListNode reverseKGroup(ListNode head, int k) {
		if (head == null) {
			return null;
		}
		ListNode begin = new ListNode(0);
		ListNode cntList = begin;
		begin.next = head;
		int total = 0;
		while (cntList.next != null) {
			total++;
			cntList = cntList.next;
		}
		System.out.println(total);
		ListNode current;
		ListNode p;
		current = begin.next;
		int cnt = 1;
		int realReverse = k > total ? k - total : k;
		while ((current.next != null && cnt < realReverse)) {
			p = current.next;
			current.next = p.next;
			p.next = begin.next;
			begin.next = p;
			cnt++;
		}
		return begin.next;
	}
}
