 

public class LongestPalindromicSubstring {
	public static void main(String[] args) {
		String s = "abab";
		System.out.println(longestPalindromeSimple(s));
	}

	public static String longestPalindromeSimple(String s) {
		int n = s.length();
		if (n == 0)
			return "";
		String longest = s.substring(0, 1);
		for (int i = 0; i < n - 1; i++) {
			String p1 = expandAroundCenter(s, i, i);
			if (p1.length() > longest.length()) {
				longest = p1;
			}

			String p2 = expandAroundCenter(s, i, i + 1);
			if (p2.length() > longest.length()) {
				longest = p2;
			}

		}
		return longest;

	}

	private static String expandAroundCenter(String s, int c1, int c2) {
		int l = c1, r = c2;
		int n = s.length();
		while (l >= 0 && r <= n - 1 && s.charAt(l) == s.charAt(r)) {
			l--;
			r++;
		}
		return s.substring(l + 1, r);
	}

	/*
	 * 
	 * Stated more formally below: Define P[ i, j ] ← true iff the substring Si
	 * … Sj is a palindrome, otherwise false.
	 * 
	 * Therefore,P[ i, j ] ← ( P[ i+1, j-1 ] and Si = Sj )
	 * 
	 * P[ i, i ] ← true P[ i, i+1 ] ← ( Si = Si+1 ) un time complexity of O(N2)
	 * and uses O(N2) space to store the table.
	 */
	public static String longestPalindromeDP(String s) {
		int n = s.length();
		int begin = 0;
		int maxLen = 1;
		boolean dp[][] = new boolean[1000][1000];
		// 对角线初始化
		for (int i = 0; i < n; i++) {
			dp[i][i] = true;
		}
		for (int i = 0; i < n - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				dp[i][i + 1] = true;
				begin = i;
				maxLen = 2;
			}
		}
		//
		for (int len = 3; len <= n; len++) {
			for (int i = 0; i < n - len + 1; i++) {// i --begin j---end index
				int j = i + len - 1;// ensure the total len of the substring is
									// len
				if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
					dp[i][j] = true;
					begin = i;
					maxLen = len;
				}
			}
		}

		return s.substring(begin, begin + maxLen);

	}

	public static String longestPalindrome(String s) {
		int fret = 0;
		int eret = 0;
		for (int i = 0; i < s.length() - 1; i++) {
			int f = i, e = i;
			for (int j = 0; j < i && f > 0 && e < s.length() - 1; j++) {
				if (s.charAt(i - j - 1) == s.charAt(i + j + 1)) {
					f = i - j - 1;
					e = i + j + 1;
				} else {
					if ((eret - fret) < (e - f)) {
						eret = e;
						fret = f;
					}
					break;
				}
			}
			if (f == 0 || e == s.length() - 1) {
				if ((eret - fret) < (e - f)) {
					fret = f;
					eret = e;
				}
			}
			f = i;
			e = i;
			// 两种情况上面是为了解决奇数问题，下面是为了解决偶数回文
			if (s.charAt(i) == s.charAt(i + 1)) {
				if ((eret - fret) <= 1) {
					fret = i;
					eret = i + 1;
				}
				int j = 0;
				f = i - j - 1;
				e = i + (j + 1) + 1;
				for (; j < i && f >= 0 && e <= s.length() - 1; j++) {
					if (s.charAt(f) != s.charAt(e)) {
						if ((eret - fret) < (e - f - 2)) {
							fret = f + 1;
							eret = e - 1;
						}
						break;
					}
					f--;
					e++;
				}
			}
			e--;
			f++;
			if ((f == 0 || e == s.length() - 1) && f >= 0
					&& e <= s.length() - 1 && (eret - fret) < (e - f)) {
				fret = f;
				eret = e;
			}
		}
		return s.substring(fret, eret + 1);
	}
}
