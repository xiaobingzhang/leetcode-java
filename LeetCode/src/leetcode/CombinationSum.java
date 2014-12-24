package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	public static void main(String[] args) {
		CombinationSum cs = new CombinationSum();
		int[] candidates = {1,2,3,4,5,6,7};
		cs.combinationSum(candidates , 13);
	}
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		List<Integer> combination = new ArrayList<Integer>();
		Arrays.sort(candidates);
		dfs(ret, target, candidates, combination, 0, 0);
		return ret;
	}

	private void dfs(List<List<Integer>> ret, int target, int[] candidates,
			List<Integer> combination, int sum, int index) {
		if (sum == target) {
			ret.add(new ArrayList<Integer>(combination));
		}
		if (sum < target) {
			for (int i = index; i < candidates.length; i++) {
				if (candidates[i] + sum <= target) {
					combination.add(candidates[i]);
					dfs(ret, target, candidates, combination, sum+ candidates[i], i);
					combination.remove(combination.size() - 1);
				}
			}
		}
	}
}
