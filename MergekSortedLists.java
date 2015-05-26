 

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergekSortedLists {
	// ///////////////////1/////////////////////////
	public static ListNode mergeKLists(List<ListNode> lists) {
		if (lists == null || lists.size() == 0) {
			return null;
		}
		return rec(lists, 0, lists.size() - 1);
	}

	private static ListNode rec(List<ListNode> lists, int l, int r) {
		// k个list分成两份，继续划分，知道剩下的两个list合并
		if (l < r) {
			int m = (r - l) / 2 + l;
			return mergeTwoLists(rec(lists, l, m), rec(lists, m + 1, r));
		}
		return lists.get(l);
	}

	private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
			}
			nextNode = nextNode.next;
		}
		if (l2 != null) {
			nextNode.next = l2;
		}
		return ret.next;
	}

	// ///////////////////2/////////////////////////
	/*
	 * 维护一个大小为k的堆，每次取堆顶的最小元素放到结果中，然后读取该元素的下一个元素放入堆中，重新维护好。因为每个链表是有序的，每次又是去当前k个元素中最小的
	 * ，所以当所有链表都读完时结束，这个时候所有元素按从小到大放在结果链表中。这个算法每个元素要读取一次，即是k*n次，
	 * 然后每次读取元素要把新元素插入堆中要logk的复杂度，所以总时间复杂度是O(nklogk)。
	 */

	public static ListNode mergeKLists2(List<ListNode> lists) {
		PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(10,
				new Comparator<ListNode>() {
					@Override
					public int compare(ListNode o1, ListNode o2) {
						return o1.val - o2.val;
					}
				});
		for(int i=0;i<lists.size();i++){
			ListNode node = lists.get(i);
			if(node != null){
				heap.offer(node);
			}
		}
		ListNode head = null;
		ListNode pre = head;
		while(heap.size() >0){
			ListNode cur = heap.poll();
			if(head == null){
				head = cur;
				pre = head;
			}else{
				pre.next = cur;
			}
			
			pre = cur;//加入到结果链表上去
			if(cur.next!=null){
				heap.offer(cur.next);
			}
		}
		return head;
	}
}
