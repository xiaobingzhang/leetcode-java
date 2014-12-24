package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
	public static void main(String[] args) {
		int[] num = { 1, 2, 3 };
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		ret = permute1(num);
		for (List<Integer> list : ret) {
			for (Integer i : list) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

	public static List<List<Integer>> permute1(int[] num) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		List<Integer> elem = new ArrayList<Integer>();
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
				visited[i] = true;
				elem.add(num[i]);
				helper(num, ret, elem, visited);
				elem.remove(elem.size() - 1);
				visited[i] = false;
			}
		}
	}

	/** dfs */

	// ///
	/*
	 1234
	 	|
	 1234 2134 3214 4231 swap(1,1) swap(1,2) swap(1,3) swap(1,4)
	 	|
	 234 324  432 swap(2,2) swap(2,3) swap(2,4)
	 */
	public static List<List<Integer>> permute2(int[] num) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		perm(ret, num, 0);
		return ret;

	}

	private static void perm(List<List<Integer>> ret, int[] num, int i) {
		List<Integer> elem ;
		if (i == num.length) {
			elem = new ArrayList<Integer>();
			for (int l = 0; l < num.length; l++) {
				elem.add(num[l]);
			}
			ret.add(elem);
		}
		for (int j = i; j < num.length; j++) {
			int tmp = num[i];
			num[i] = num[j];
			num[j] = tmp;
			perm(ret, num, i + 1);
			tmp = num[i];
			num[i] = num[j];
			num[j] = tmp;
		}
	}
	// ///
	
	////nextPermutation///
	public static List<List<Integer>> permute(int[] num) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		List<Integer> elem = new ArrayList<Integer>();
		for (int l = 0; l < num.length; l++) {
			elem.add(num[l]);
		}
		ret.add(elem);
		for(int i = 1;i<factorial(num.length);i++){
			nextPermutation(num);
			elem = new ArrayList<Integer>();
			for (int l = 0; l < num.length; l++) {
				elem.add(num[l]);
			}
			ret.add(elem);
		}
		return ret;
	}
	public static int factorial(int n){
        return (n == 1 || n == 0) ? 1 : factorial(n - 1) * n;
    }
	public static void nextPermutation(int[] num) {
		int l = 0;
		int r = num.length - 1;
		for (int i = num.length - 1; i > 0; i--) {
			if (num[i - 1] < num[i]) {
				l = i - 1;
				break;
			}
		}
		boolean flag = true;
		for (; r > l; r--) {
			if (num[r] > num[l]) {
				int t = num[r];
				num[r] = num[l];
				num[l] = t;
				flag = false;
				break;
			}
		}
		if(flag){
			l--;
		}
		Arrays.sort(num, l + 1, num.length);
	}

}
