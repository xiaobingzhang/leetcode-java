package leetcode;

public class InsertionSortList {
	public static void main(String[] args) {
		InsertionSortList sl = new InsertionSortList();
		ListNode head = new ListNode(4);
		ListNode sec = new ListNode(2);
		ListNode thir = new ListNode(1);
		ListNode fou = new ListNode(3);
		ListNode fiv = new ListNode(7);
		ListNode six = new ListNode(8);
		ListNode end = new ListNode(9);
		head.next = sec;
		sec.next = thir;
		thir.next = fou;
		// fou.next = fiv;
		// fiv.next = six;
		// six.next = end;
		System.out.println(sl.insertionSortList2(head));
	}

	// MyOwnSolution
	public ListNode insertionSortList2(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode begin = new ListNode(0);
		begin.next = head;
		ListNode p = begin.next;
		ListNode pre = begin;
		while (p != null) {
			ListNode cur = p;
			while (cur.next != null) {
				if (cur.next.val < p.val) {
					ListNode tmp = cur.next;
					cur.next = cur.next.next;
					pre.next = tmp;
					tmp.next = p;
					p = pre.next;
				} else {
					cur = cur.next;
				}
			}
			pre = p;
			p = p.next;
		}
		return begin.next;
	}

	public ListNode insertionSortList1(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode begin = new ListNode(0);
		begin.next = head;
		ListNode p = head.next;
		ListNode pre = head;
		while (p != null) {
			ListNode cur = begin;
			while (cur.next != p) {
				if (cur.next.val > p.val) {
					pre.next = p.next;
					p.next = cur.next;
					cur.next = p;
					p = pre;
					break;
				}
				cur = cur.next;
			}
			pre = p;
			p = p.next;
		}
		return begin.next;

	}

	// change the val;
	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode cur = head;
		while (cur != null) {
			ListNode tmp = cur.next;
			while (tmp != null) {
				int aa = cur.val;
				if (tmp.val < cur.val) {
					int a = tmp.val;
					tmp.val = cur.val;
					cur.val = a;
				}
				tmp = tmp.next;
			}
			cur = cur.next;
		}
		return head;

	}
}
