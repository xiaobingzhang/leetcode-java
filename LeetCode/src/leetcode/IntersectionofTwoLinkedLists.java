package leetcode;

public class IntersectionofTwoLinkedLists {
	public static void main(String[] args) {
		IntersectionofTwoLinkedLists iot = new IntersectionofTwoLinkedLists();
		ListNode headA = new ListNode(0);
		ListNode headA1 = new ListNode(1);
		ListNode headB = new ListNode(2);
		ListNode headB1 = new ListNode(3);
		ListNode headB2 = new ListNode(4);
		ListNode head1 = new ListNode(5);
		ListNode head2 = new ListNode(6);
		ListNode head3 = new ListNode(7);
		headA.next = headA1;
		headA1.next = head1;
		head1.next = head2;
		head2.next = head3;
		headB.next = headB1;
		headB1.next = headB2;
		headB2.next = head1;
		ListNode ret = iot.getIntersectionNode(headA, headB);
		System.out.println(ret);
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		ListNode pa = headA;
		ListNode pb = headB;
		ListNode tailA = null;
		ListNode tailB = null;
		while (true) {
			if (pa == null) {
				pa = headB;
			}
			if (pb == null) {
				pb = headA;
			}
			if (pa.next == null) {
				tailA = pa;
			}
			if (pb.next == null) {
				tailB = pb;
			}
			if (tailA != null && tailB != null && tailA != tailB) {
				return null;
			}
			if (pa == pb) {
				return pa;
			}
			pa = pa.next;
			pb = pb.next;
		}
	}

	
	public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
		int lenA = 0;
		int lenB = 0;

		ListNode tmpA = headA;
		while (tmpA != null) {
			tmpA = tmpA.next;
			lenA++;
		}
		ListNode tmpB = headB;
		while (tmpB != null) {
			tmpB = tmpB.next;
			lenB++;
		}
		ListNode tmpLong;
		ListNode tmpShort;
		int dis;
		if (lenA > lenB) {
			tmpLong = headA;
			tmpShort = headB;
			dis = lenA - lenB;
		} else {
			tmpLong = headB;
			tmpShort = headA;
			dis = lenB - lenA;
		}
		for (int i = 0; i < dis; i++) {
			tmpLong = tmpLong.next;
		}
		while (tmpLong != null) {
			if (tmpLong.val == tmpShort.val) {
				return tmpLong;
			}
			tmpLong = tmpLong.next;
			tmpShort = tmpShort.next;
		}
		return null;

	}
}
