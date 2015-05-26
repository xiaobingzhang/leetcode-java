 

public class MergeTwoSortedLists {
	public static void main(String[] args) {
		ListNode h1 = new ListNode(1);
		ListNode three = new ListNode(3);
		ListNode five = new ListNode(5);
		ListNode seven = new ListNode(7);
		h1.next = three;
		three.next = five;
		five.next = seven;
		ListNode h2 = new ListNode(2);
		ListNode four = new ListNode(4);
		ListNode six = new ListNode(6);
		ListNode eight = new ListNode(8);
		h2.next = four;
		four.next = six;
		six.next = eight;
		mergeTwoLists2(h1, h2);
	}

	public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		ListNode ret = new ListNode(0);
		ListNode nextNode = ret;
		ret.next = l1;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				l1 = l1.next;
			} else {
				ListNode tmp = new ListNode(l2.val);
				ListNode tmp2 = nextNode.next;
				
				nextNode.next = tmp;
				tmp.next = tmp2;
				
				l2 = l2.next;
				
				// ListNode tmp = l2.next;
				// l2.next = nextNode.next;
				// nextNode.next = l2;
				// l2 = tmp;
				 
			}
			nextNode = nextNode.next;
		}
		if (l2 != null) {
			nextNode.next = l2;
		}
		return ret.next;
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode ret = new ListNode(0);
		ListNode h1 = new ListNode(0);
		ListNode h2 = new ListNode(0);
		h1.next = l1;
		h2.next = l2;
		ListNode nextNode = ret;
		while (h1.next != null && h2.next != null) {
			if (h1.next.val < h2.next.val) {
				nextNode.next = new ListNode(h1.next.val);
				h1 = h1.next;
			} else {
				nextNode.next = new ListNode(h2.next.val);
				h2 = h2.next;
			}
			nextNode = nextNode.next;
		}
		while (h1.next != null) {
			nextNode.next = new ListNode(h1.next.val);
			h1 = h1.next;
			nextNode = nextNode.next;

		}
		while (h2.next != null) {
			nextNode.next = new ListNode(h2.next.val);
			h2 = h2.next;
			nextNode = nextNode.next;

		}
		return ret.next;
	}
}
