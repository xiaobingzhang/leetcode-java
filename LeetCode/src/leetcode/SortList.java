package leetcode;

public class SortList {
	public static void main(String[] args) {
		SortList sl = new SortList();
		ListNode head = new ListNode(4);
		ListNode sec = new ListNode(3);
		ListNode thir = new ListNode(6);
		ListNode fou = new ListNode(7);
		ListNode fiv = new ListNode(2);
		ListNode six = new ListNode(1);
		ListNode end = new ListNode(9);
		head.next = sec;
		sec.next = thir;
		thir.next = fou;
		fou.next = fiv;
		fiv.next = six;
		six.next = end;
		System.out.println(sl.sortList(head));
	}
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		} else {
			ListNode slow = head;
			ListNode fast = head;
			// find the mid
			while (fast.next != null && fast.next.next != null) {
				slow = slow.next;
				fast = fast.next.next;
			}

			fast = slow;
			slow = slow.next;
			fast.next = null;
			// break up
			fast = sortList(slow);
			slow = sortList(head);

			return merge(slow, fast);
		}

	}

	private ListNode merge(ListNode l, ListNode r) {
		if (r == null) {
			return l;
		}
		if (l == null) {
			return r;
		}
		ListNode ret;
		ListNode p;
		if(l.val<r.val){
			ret = l ;
			l = l.next;
		}else{
			ret = r;
			r = r.next;
		}
		p = ret;
		while(l!=null&&r!=null){
			if(l.val<r.val){
				p.next = l ;
				l = l.next;
			}else{
				p.next = r;
				r = r.next;
			}
			p = p.next;
		}
		if (l != null) {
			p.next = l;
		}
		if (r != null) {
			p.next = r;
		}
		return ret;
	}
}
