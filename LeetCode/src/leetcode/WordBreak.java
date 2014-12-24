package leetcode;

import java.util.Set;

public class WordBreak {
	public boolean wordBreak1(String s, Set<String> dict) {
		int len = s.length();
		int[][] f = new int[len][len];
		return wordBreakHelper(s, dict, 0, f, len - 1);
	}

	private boolean wordBreakHelper(String s, Set<String> dict, int i,
			int[][] f, int j) {
		if (f[i][j] == 1) {
			return true;
		}
		if (f[i][j] == -1) {
			return false;
		}
		String s1 = s.substring(i, j + 1);
		if (dict.contains(s1)) {
			f[i][j] = 1;
			return true;
		}
		for (int k = i + 1; k <= j; k++) {
			if (wordBreakHelper(s, dict, i, f, k - 1)
					&& wordBreakHelper(s, dict, k, f, j)) {
				f[i][j] = 1;
				return true;
			}
		}
		f[i][j] = -1;
		return false;
	}

	public boolean wordBreak(String s, Set<String> dict) {
		int len = s.length();
		boolean[] ret = new boolean[len + 1];
		ret[0] = true;
		for (int i = 1; i <= len; i++) {
			for (int j = 0; j < i; j++) {
				if (ret[j] && dict.contains(s.substring(j, i))) {
					ret[i] = true;
					break;
				}
			}
		}
		return ret[len];

	}
}
