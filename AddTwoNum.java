 

public class AddTwoNum {
	public static void main(String[] args) {

		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		ListNode ret = addTwoNumbers(l1, l2);
		System.out.println(ret.val + "->"+ret.next.val+"->"+ret.next.next.val );
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode ret = new ListNode(0);
		ListNode d = ret;
		int sum = 0;
		while (l1 != null || l2 != null) {
			sum /= 10;
			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}
			d.next = new ListNode(sum % 10);
			d = d.next;
		}
		if (sum / 10 == 1) {
			d.next = new ListNode(1);
		}
		return ret.next;

	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		this.val = x;
		next = null;
	}
	@Override
	public String toString() {
		String ret = this.val+"->";
		ListNode tmp = this;
		while(tmp.next!=null){
			tmp = tmp.next;
			ret = ret+tmp.val+"->";
		}
		return ret;
	}
}