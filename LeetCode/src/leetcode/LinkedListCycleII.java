package leetcode;

public class LinkedListCycleII {
	public static void main(String[] args) {
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(1);
		/*
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = two;
		*/
		LinkedListCycleII llc = new LinkedListCycleII();
		ListNode ret = llc.detectCycle(one);
		System.out.println(ret.val);
	}

	public ListNode detectCycle(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode fast = head;
		ListNode slow = head;
		while (fast!= null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (slow == fast) {
				break;
			}
		}
		if (fast == null || fast.next == null) {
			return null;
		}
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}
}
