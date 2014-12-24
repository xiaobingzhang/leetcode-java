package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
	public static void main(String[] args) {
		int target = 8;
		int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
		List<List<Integer>> ret = combinationSum2(candidates, target);
		for (List<Integer> list : ret) {
			for (Integer i : list) {
				System.out.print(i + " ");
			}
			System.out.println("--");
		}
	}

	public static List<List<Integer>> combinationSum2(int[] num, int target) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		List<Integer> combination = new ArrayList<Integer>();
		Arrays.sort(num);
		dfs(ret, num, target, combination, 0, 0);
		return ret;

	}

	private static void dfs(List<List<Integer>> ret, int[] num, int target,
			List<Integer> combination, int sum, int index) {
		if (sum == target) {
			ret.add(new ArrayList<>(combination));
			return;
		} else if (sum < target) {
			for (int i = index; i < num.length; i++) {
				if (i != index && num[i] == num[i - 1]) {
					continue;
				}
				if (num[i] + sum <= target) {
					combination.add(num[i]);
					dfs(ret, num, target, combination, sum + num[i], i + 1);
					combination.remove(combination.size() - 1);
				}
			}
		}
	}
}
