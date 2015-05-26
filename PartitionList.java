 

public class PartitionList {
	public static void main(String[] args) {
		PartitionList p =  new PartitionList();
		ListNode head1 =  new ListNode(1);
		ListNode head2 =  new ListNode(4);
		ListNode head3 =  new ListNode(3);
		ListNode head4 =  new ListNode(2);
		ListNode head5 =  new ListNode(5);
		ListNode head6 =  new ListNode(2);
		head1.next = head2;
		head2.next = head3;
		head3.next = head4;
		head4.next = head5;
		head5.next = head6;
		p.partition(head1 , 3);
	}
	public ListNode partition1(ListNode head, int x) {
		ListNode l = new ListNode(0);
		ListNode r = new ListNode(0);
		ListNode lhead,rhead;
		lhead = l;
		rhead = r;
		while(head != null){
			
			if(head.val < x){
				lhead.next = head;
				lhead = lhead.next;
			}else{
				rhead.next = head;
				rhead = rhead.next;
			}
			head = head.next;
		}
		rhead.next = null;
		lhead.next = r.next;
		return l.next;
	}
	public ListNode partition(ListNode head, int x) {
		ListNode l = new ListNode(0);
		ListNode r = new ListNode(0);
		ListNode lhead,rhead;
		lhead = l;
		rhead = r;
		while(head != null){
			
			if(head.val < x){
				lhead.next = head;
				head = head.next;
				lhead = lhead.next;
				lhead.next = null;
			}else{
				rhead.next = head;
				head = head.next;
				rhead = rhead.next;
				rhead.next = null;
			}
		}
		lhead.next = r.next;
		return l.next;
	}
}
