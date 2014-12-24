package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CloneGraph {
	public static void main(String[] args) {
		CloneGraph cg = new CloneGraph();
		UndirectedGraphNode node = new UndirectedGraphNode(0);
		UndirectedGraphNode node1 = new UndirectedGraphNode(0);
		UndirectedGraphNode node2 = new UndirectedGraphNode(0);
		node.neighbors.add(node1);
		node.neighbors.add(node2);
		node1.neighbors.add(node2);
		node2.neighbors.add(node2);

		cg.cloneGraph(node);
		
	}
	
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		UndirectedGraphNode newHead = new UndirectedGraphNode(node.label);
		queue.add(node);
		map.put(node, newHead);
		while (!queue.isEmpty()) {
			UndirectedGraphNode cur = queue.pop();
			List<UndirectedGraphNode> neighbors = cur.neighbors;
			for (UndirectedGraphNode neighborNode : neighbors) {
				if (!map.containsKey(neighborNode)) {
					UndirectedGraphNode copy = new UndirectedGraphNode(
							neighborNode.label);
					map.put(neighborNode, copy);
					map.get(cur).neighbors.add(copy);
					queue.add(neighborNode);
				} else {
					map.get(cur).neighbors.add(map.get(neighborNode));
				}
			}
		}
		return newHead;
	}
	
	
}

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
}