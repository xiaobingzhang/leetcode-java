package leetcode;

public class RotateList {
	public static void main(String[] args) {
		RotateList rl = new RotateList();
		ListNode head = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		ListNode five = new ListNode(5);
		head.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		rl.rotateRight(head, 2);
	}

	public ListNode rotateRight(ListNode head, int n) {
		if (head == null) {
			return head;
		}
		ListNode begin = new ListNode(0);
		begin.next = head;
		ListNode resolve = begin;
		int cnt = 0;
		while (resolve.next != null) {
			resolve = resolve.next;
			cnt++;
		}

		n = n % cnt;
		resolve.next = head;
		int step = cnt - n;
		ListNode ret = begin;

		while (step > 0) {
			ret = ret.next;
			step--;
		}

		begin.next = ret.next;
		ret.next = null;

		return begin.next;

	}
}
