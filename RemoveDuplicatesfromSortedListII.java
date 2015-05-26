 

public class RemoveDuplicatesfromSortedListII {
	public static void main(String[] args) {
		RemoveDuplicatesfromSortedListII r = new RemoveDuplicatesfromSortedListII();
		ListNode head = new ListNode(1);
		ListNode head1 = new ListNode(1);
		ListNode head2 = new ListNode(2);
		ListNode head3 = new ListNode(2);
		ListNode head4 = new ListNode(3);
		ListNode head5 = new ListNode(4);
		ListNode head6 = new ListNode(4);
		head.next = head1;
		head1.next = head2;

		head2.next = head3;
		head3.next = head4;
		head4.next = head5;
		head5.next = head6;

		// 1->1->2->2->3->4->4->
		System.out.println(r.deleteDuplicates1(head));
	}

	public ListNode deleteDuplicates1(ListNode head) {
		ListNode dumpNode = new ListNode(0);
		ListNode cur = dumpNode;
		ListNode suc = head.next;
		while (head != null) {
			while (suc != null && suc.val == head.val) {
				suc = suc.next;
			}
			if (head.next == null || head.next == suc) {
				cur.next = head;
				cur = cur.next;
				cur.next = null;
			}
			head = suc;
		}
		return dumpNode.next;
	}

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode ptr = head;
		head = null;
		ListNode prev = null;
		while (ptr != null) {
			int cnt = 0;
			while (ptr.next != null && ptr.val == ptr.next.val) {
				ptr = ptr.next;
				cnt++;
			}
			if (cnt == 0) {
				if (prev == null) {
					head = ptr;
					prev = ptr;
				} else {
					prev.next = ptr;
					prev = ptr;
				}
			}
			ptr = ptr.next;
		}
		if (prev != null) {
			prev.next = null;
		}
		return head;
	}
}
