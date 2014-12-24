package leetcode;

public class LinkedListCycle {
	public static void main(String[] args) {
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(1);
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = two;
		LinkedListCycle llc = new LinkedListCycle();
		boolean ret = llc.hasCycle(one);
		System.out.println(ret);
	}
	public boolean hasCycle(ListNode head) {
		if(head == null){
			return true;
		}
		ListNode fast = head;
		ListNode slow = head;
		while(fast.next!=null  && fast.next.next!=null){
			fast = fast.next.next;
			slow = slow.next;
			if(slow == fast){
				return true;
			}
		}
		return false;
	}
}
