package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		List<Integer> com = new ArrayList<Integer>();

		dfs(ret, n, k, com, 1);
		return ret;
	}

	private static void dfs(List<List<Integer>> ret, int num, int k,
			List<Integer> com, int index) {
		if (com.size() == k) {
			ret.add(new ArrayList<Integer>(com));
		}
		for (int i = index; i <= num; i++) {
			if (com.size() + 1 <= k) {
				com.add(i);
				dfs(ret, num, k, com, i + 1);
				com.remove(com.size() - 1);
			}
		}
	}
}
