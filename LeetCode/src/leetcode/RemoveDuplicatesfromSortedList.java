package leetcode;

public class RemoveDuplicatesfromSortedList {
	public static void main(String[] args) {
		RemoveDuplicatesfromSortedList r = new RemoveDuplicatesfromSortedList();
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
		//1->1->2->2->3->4->4->
		System.out.println(r.deleteDuplicates1(head));
	}

	public ListNode deleteDuplicates1(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode p = head;
		while (p != null && p.next != null) {
			if(p.val == p.next.val){
				p.next = p.next.next;
			}else{
				p = p.next;
			}
		}
		return head;
	}
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode begin = new ListNode(0);
		begin.next = head;
		ListNode cur = begin.next.next;
		ListNode pre = begin.next;
		while (cur!= null) {
			if (cur.val != pre.val) {
				pre = cur;
				cur = cur.next;
			} else {
				while (cur !=null &&cur.val == pre.val) {
					cur = cur.next;
				}
				pre.next = cur;
			}
		}
		return begin.next;
	}
}
