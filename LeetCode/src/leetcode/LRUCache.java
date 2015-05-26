 

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	public static void main(String[] args) {
		LRUCache lruCache = new LRUCache(1);
		lruCache.set(2, 1);
		System.out.println(lruCache.get(2));
		lruCache.set(3, 2);
		System.out.println(lruCache.get(2));
		System.out.println(lruCache.get(3));
	}

	class DoubleListNode {
		DoubleListNode pre;
		DoubleListNode next;
		int key;
		int value;

		public DoubleListNode(int key, int value) {
			this.key = key;
			this.value = value;
			this.pre = null;
			this.next = null;
		}
	}

	private Map<Integer, DoubleListNode> map;
	private DoubleListNode head;
	private DoubleListNode tail;
	private int capacity;
	private int currentSize;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.currentSize = 0;
		map = new HashMap<Integer, DoubleListNode>(capacity);
		this.head = null;
		this.tail = null;
	}

	public int get(int key) {
		DoubleListNode r = map.get(key);
		if (r != null) {
			moveNodeToHead(r);
			return r.value;
		} else {
			return -1;
		}
	}

	public void set(int key, int value) {
		DoubleListNode node = map.get(key);
		if (node == null) {
			node = new DoubleListNode(key, value);
			if (currentSize >= capacity) {
				map.remove(tail.key);
				removeNodeFromTail();
			} else {
				currentSize++;
			}
		} else {
			node.value = value;
		}
		if (currentSize == 1) {
			head = node;
			tail = node;
		}
		moveNodeToHead(node);
		map.put(key, node);
	}

	private void moveNodeToHead(DoubleListNode node) {
		if (node == head) {
			return;
		} else {
			node.pre.next = node.next;
		}

		if (node != tail) {
			node.next.pre = node.pre;
		} else {
			tail = node.pre;
		}
		
		if (head != null) {
			node.next = head;
			head.pre = node;
		}
		head = node;
		node.pre = null;
	}

	private void removeNodeFromTail() {
		if (tail != null) {
			if (tail.pre != null) {
				tail.pre.next = null;
			} else {
				head = null;
			}
			tail = tail.pre;
		}
	}
}

/*
 * private LinkedList<java.util.AbstractMap.SimpleEntry<Integer, Integer>> list
 * = new LinkedList<java.util.AbstractMap.SimpleEntry<Integer, Integer>>();
 * private HashMap<Integer, java.util.AbstractMap.SimpleEntry<Integer, Integer>>
 * map = new HashMap<Integer, java.util.AbstractMap.SimpleEntry<Integer,
 * Integer>>(); private int capacity = 0;
 * 
 * public LRUCache(int capacity) { this.capacity = capacity; }
 * 
 * public int get(int key) { if (map.containsKey(key)) {
 * java.util.AbstractMap.SimpleEntry<Integer, Integer> entry = map.get(key);
 * list.remove(entry); list.addFirst(entry); return entry.getValue(); } return
 * -1; }
 * 
 * public void set(int key, int value) { if (map.containsKey(key)) {
 * java.util.AbstractMap.SimpleEntry<Integer, Integer> entry = map.get(key);
 * entry.setValue(value); list.remove(entry); list.addFirst(entry); }else{
 * if(list.size() < capacity){ map.put(key, new
 * java.util.AbstractMap.SimpleEntry<Integer,Integer>(key,value));
 * list.add(map.get(key)); }else{ int lastKey = list.getLast().getKey();
 * map.remove(key); list.removeLast(); map.put(key, new
 * java.util.AbstractMap.SimpleEntry<Integer,Integer>(key,value));
 * list.addFirst(map.get(key)); } } }
 */
