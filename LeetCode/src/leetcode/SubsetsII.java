 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
	public static void main(String[] args) {
		SubsetsII s = new SubsetsII();
		int[] S = {1,2,2 };
		List<List<Integer>> ret = s.subsetsWithDup(S);
		for (List<Integer> list : ret) {
			for (Integer integer : list) {
				System.out.print(integer + "-");
			}
			System.out.println();
		}
	}


	public List<List<Integer>> subsetsWithDup(int[] S) {
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
	 * 对于输入字符串s的每一位字符
	        选取该字符到子集合中，并输出
	        如果，当前字符不是最后一位字符
	                 递归调用Generate,处理下一位字符
	 */
	private void dfs(int[] S, int step, List<List<Integer>> res,List<Integer> output) {
		for (int i = step; i <= S.length-1; i++) {
			output.add(S[i]);
			res.add(new ArrayList<Integer>(output));
			dfs(S, i + 1, res, output);
			output.remove(output.size() - 1);
			while(i<S.length-1 && S[i] == S[i+1]){
				i++;
			}
		}
	}
}
