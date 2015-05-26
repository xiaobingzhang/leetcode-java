 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
	public static void main(String[] args) {
		int[] num = { 1, 1, 1 };
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		ret = permute1(num);
		for (List<Integer> list : ret) {
			for (Integer i : list) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

	/** dfs 直接深搜搜到一个回退 */
	public static List<List<Integer>> permute1(int[] num) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		List<Integer> elem = new ArrayList<Integer>();
		Arrays.sort(num);
		boolean[] visited = new boolean[num.length];
		helper(num, ret, elem, visited);
		return ret;
	}

	private static void helper(int[] num, List<List<Integer>> ret,
			List<Integer> elem, boolean[] visited) {
		if (elem.size() == num.length) {
			ret.add(new ArrayList<>(elem));
			return;
		}
		for (int i = 0; i < num.length; i++) {
			if (!visited[i]) {
				if(i>0 && num[i] == num[i-1] && !visited[i-1]){
					continue;
				}
				visited[i] = true;
				elem.add(num[i]);
				helper(num, ret, elem, visited);
				elem.remove(elem.size() - 1);
				visited[i] = false;
			}
		}
	}

	
}
