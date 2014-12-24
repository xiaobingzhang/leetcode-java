package leetcode;

public class SwapNodesinPairs {
	public static void main(String[] args) {
		ListNode h1 = new ListNode(1);
		ListNode three = new ListNode(3);
		ListNode five = new ListNode(5);
		ListNode seven = new ListNode(7);
		h1.next = three;
		three.next = five;
		five.next = seven;
		swapPairs(h1);
	}

	/*
	 * As you can see, the addition of an empty node at the start removes the
	 * problem of "head" being a special case, as the start of the list is now
	 * defined as "what follows start," and the middle of the list is easy to
	 * swap. As we also know that start is not null, cur is not null at the
	 * beginning, and checking cur.next.next during the while loop means it
	 * cannot be null in following loops. If cur.next is null, then the
	 * condition short circuits to false before needing to evaluate to a
	 * nullpointerexception. Therefore, the conditions at the start are
	 * unneeded.
	 */

	public static ListNode swapPairs(ListNode head) {
		ListNode start = new ListNode(0);
		start.next = head;
		for (ListNode cur = start; cur.next != null && cur.next.next != null; cur = cur.next.next) {
			cur.next = swap(cur.next, cur.next.next);
		}
		return start.next;

	}

	private static ListNode swap(ListNode next1, ListNode next2) {
		next1.next = next2.next;
		next2.next = next1;
		return next2;
	}

	public static ListNode swapPairs2(ListNode head) {
		ListNode start = new ListNode(0);
		start.next = head;
		ListNode cur = start;
		int cnt = 0;
		while (cnt <12 && cur.next != null && cur.next.next != null) {
			ListNode tmp1 = cur.next;
			ListNode tmp2 = cur.next.next;
			
			tmp1.next = tmp2.next;
			tmp2.next = tmp1;
			
			cur.next = tmp2;
			cur = cur.next.next;
			cnt++;
		}
		return start.next;
	}
}
