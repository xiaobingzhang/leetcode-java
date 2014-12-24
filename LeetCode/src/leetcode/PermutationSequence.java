package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

	public static void main(String[] args) {
		PermutationSequence p = new PermutationSequence();
		// String ret = p.getPermutation(3, 6);
		int n = 1;
		int k = 1;
		System.out.println(p.getPermutation(n, k) +"    "+p.getPermutation1(n, k));
	}

	public String getPermutation(int n, int k) {
		int[] ret = new int[n];
		boolean[] output = new boolean[n];
		StringBuilder buf = new StringBuilder("");
		ret[0] = 1;
		for (int i = 1; i < n; i++) {
			ret[i] = ret[i - 1] * i;
		}
		for (int i = n - 1; i >= 0; i--) {
			int s = 1;
			while (k > ret[i]) {
				s++;
				k -= ret[i];
			}
			for (int j = 0; j < n; j++) {
				if (j + 1 <= s && output[j]) {
					s++;
				}
			}
			output[s - 1] = true;
			buf.append(Integer.toString(s));
		}
		return buf.toString();
	}

	public String getPermutation1(int n, int k) {
		List<Integer> numList = new ArrayList<Integer>();
		int mod = 1;
		for (int i = 1; i <= n; i++) {
			numList.add(i);
			mod = mod * i;
		}
		k--;
		String ret = "";
		for (int i = 0; i < n; i++) {
			mod = mod / (n - i);
			int curIndex = k / mod;
			k = k % mod;
			ret += numList.get(curIndex);
			numList.remove(curIndex);
		}
		return ret;
	}
}
