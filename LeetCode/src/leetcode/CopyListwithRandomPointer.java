 

import java.util.HashMap;
import java.util.Map;

public class CopyListwithRandomPointer {
	public static void main(String[] args) {
		CopyListwithRandomPointer crp = new CopyListwithRandomPointer();
		RandomListNode head1 = new RandomListNode(1);
		RandomListNode head2 = new RandomListNode(2);
		RandomListNode head3 = new RandomListNode(3);
		RandomListNode head4 = new RandomListNode(4);
		head1.next = head2;
		head2.next = head3;
		head3.next = head4;

		RandomListNode head = new RandomListNode(-1);
		head.random = head;
		crp.copyRandomList(head);

	}

	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) {
			return head;
		}
		Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		RandomListNode ret = new RandomListNode(head.label);
		map.put(head, ret);
		RandomListNode p = head.next;
		RandomListNode cur = ret;
		while (p != null) {
			cur.next = new RandomListNode(p.label);
			cur = cur.next;
			map.put(p, cur);
			p = p.next;
		}
		p = head;
		cur = ret;
		while (p != null) {
			if (p.random != null) {
				cur.random = map.get(p.random);// make the random point the new
												// copy not the orign node
			}
			p = p.next;
			cur = cur.next;
		}
		return ret;
	}
}

class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}

	@Override
	public String toString() {
		String ret = this.label + "->";
		RandomListNode tmp = this;
		while (tmp.next != null) {
			tmp = tmp.next;
			ret = ret + tmp.label + "->";
		}
		return ret;
	}
};