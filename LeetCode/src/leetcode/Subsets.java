package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
	public static void main(String[] args) {
		Subsets s = new Subsets();
		// int[] S = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0 };
		int[] S = { 1, 2, 0 };
		List<List<Integer>> ret = s.subsetsBetter(S);
		for (List<Integer> list : ret) {
			for (Integer integer : list) {
				System.out.print(integer + "-");
			}
			System.out.println();
		}
	}

	public List<List<Integer>> subsetsBetter(int[] S) {
		Arrays.sort(S);
		int totalNum = 1 << S.length;
		List<List<Integer>> ret = new ArrayList<List<Integer>>(totalNum);
		for (int i = 0; i < totalNum; i++) {
			List<Integer> output = new ArrayList<Integer>();
			for (int j = 0; j < S.length; j++) {
				if ((i & (1 << j)) != 0) {
					output.add(S[j]);
				}
			}
			ret.add(output);
		}
		return ret;
	}

	public List<List<Integer>> subsetsIter(int[] S) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if (S.length == 0) {
			return ret;
		}
		List<Integer> output = new ArrayList<Integer>();
		ret.add(output);
		Arrays.sort(S);
		for (int i = 0; i < S.length; i++) {
			int size = ret.size();
			for (int j = 0; j < size; j++) {
				output = new ArrayList<Integer>(ret.get(j));
				output.add(S[i]);
				ret.add(output);
			}
		}
		return ret;
	}

	public List<List<Integer>> subsets(int[] S) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if (S.length == 0) {
			return ret;
		}
		List<Integer> output = new ArrayList<Integer>();
		ret.add(output);
		Arrays.sort(S);
		dfs(S, 0, ret, output);
		return ret;
	}

	/*
	 * 对于输入字符串s的每一位字符 选取该字符到子集合中，并输出 如果，当前字符不是最后一位字符 递归调用Generate,处理下一位字符
	 */
	private void dfs(int[] S, int step, List<List<Integer>> res,
			List<Integer> output) {
		for (int i = step; i <= S.length - 1; i++) {
			output.add(S[i]);
			res.add(new ArrayList<Integer>(output));
			// 注意！这里的index要填写i + 1，而不是step+1，开始老是会犯错
			dfs(S, i + 1, res, output);
			output.remove(output.size() - 1);

		}
	}
}
