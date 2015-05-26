 

public class RegularExpressionMatching {

	public static void main(String[] args) {
		boolean[] ret = new boolean[1];
		System.out.println("______________" + ret[0] + "______________");
		isMatch("aab", "c*a*b");
		System.out.println(isMatch("aa", "a*")); // true
		System.out.println(isMatch("aa", "a")); // false
		System.out.println(isMatch("aa", "aa")); // true
		System.out.println(isMatch("aaa", "aa")); // false
		System.out.println(isMatch("aa", "a*")); // true
		System.out.println(isMatch("aa", ".*")); // true
		System.out.println(isMatch("ab", ".*")); // true
		System.out.println(isMatch("aab", "c*a*b"));// true
		System.out.println("-------------------------------");
		System.out.println(isMatch("", "bab")); // false
		System.out.println(isMatch("ab", ".*c")); // false
		System.out.println(isMatch("aaa", "a.a")); // true
		System.out.println(isMatch("a", ".")); // true
		System.out.println(isMatch("a", "ab*")); // true
		System.out.println(isMatch("bb", ".bab")); // false
		System.out.println(isMatch("bb", "*")); // false
	}

	public static boolean isMatch2(String s, String p) {
		return reslove(s, p, 0, 0);
	}

	private static boolean reslove(String s, String p, int i, int j) {
		if (j >= p.length()) {// pattern已经用光
			return i >= s.length(); // 如果s已经走完则匹配，否则不匹配
		}
		if (j == p.length() - 1) {
			return (i == s.length() - 1)
					&& (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
		}
		// 如果pattern的下一个字符(j+1)不是*
		if (j < p.length() - 1 && p.charAt(j + 1) != '*') {
			if (i == s.length()) {// 如果s已经走完，则说明不匹配
				return false;
			}
			if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {// 如果当前字符匹配
				return reslove(s, p, i + 1, j + 1);
			} else {
				return false;
			}
		}
		// 如果下一个字符(j+1)是* 且 当前字符匹配，则进行搜索：isMatch("aab", "c*a*b")
		while (i < s.length() && j < p.length()
				&& (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.')) {
			// 因为*可以取0,1,2,...所以i=i,i+1,i+2,...对所有可能进行测试
			// 最后能否匹配取决于剩下的匹配是否成功
			if (reslove(s, p, i, j + 2)) {
				return true;
			}
			i++;
		}
		// 如果下一个字符(j+1)是* 且 当前字符不匹配，则pattern跳过两个，继续比较
		// 还有一种情况到这里是上面的最后一次尝试（i==s.length()）
		return reslove(s, p, i, j + 2);
	}

	// dp
	/*
	 * ret[i][j] :s 的前i个字符和p的前j个字符匹配
	 * (1)p[j+1]不是'*'。情况比较简单，只要判断如果当前s的i和p的j上的字符一样（
	 * 如果有p在j上的字符是'.',也是相同），并且res[i][
	 * j]==true，则res[i+1][j+1]也为true，res[i+1][j+1]=false;
	 * (2)p[j+1]是'*'，但是p[j]!='.'。那么只要以下条件有一个满足即可对res[i+1][j+1]赋值为true：
	 * 1)res[i+1][j]为真（'*'只取前面字符一次）; 2)res[i+1][j-1]为真（'*'前面字符一次都不取，也就是忽略这两个字符）;
	 * 3)res[i][j+1]; s[i]==s[i-1]
	 * s[i-1]==p[j-1](这种情况是相当于i从0到s.length()扫过来，如果p[j
	 * +1]对应的字符是‘*’那就意味着接下来的串就可以依次匹配下来， 如果下面的字符一直重复，并且就是‘*’前面的那个字符）。
	 * (3)p[j+1]是'*'
	 * ，并且p[j]=='.'。因为".*"可以匹配任意字符串，所以在前面的res[i+1][j-1]或者res[i+1][j]
	 * 中只要有i+1是true，那么剩下的res[i+1][j+1],...,res[s.length()][j+1]就都是true了。
	 */
	public static boolean isMatch(String s, String p) {
		if (p.length() == 0) {
			return s.length() == 0;
		}
		boolean[][] ret = new boolean[s.length() + 1][p.length() + 1];
		ret[0][0] = true;
		for (int j = 0; j < p.length(); j++) {
			if (p.charAt(j) == '*') {
				if (j > 0) {
					ret[0][j + 1] = ret[0][j - 1];// 对于这种情况处理 s = "" p="X*X*"
				}
				if (j == 0) {
					continue;
				}
				if (p.charAt(j - 1) != '.') {// X*
					for (int i = 0; i < s.length(); i++) {
						// 1次 0次 n次
						if (ret[i + 1][j]
								|| (j > 0 && ret[i + 1][j - 1])
								|| (i > 0 && j > 0 && ret[i][j + 1]
										&& s.charAt(i-1) == s.charAt(i) && s
										.charAt(i - 1) == p.charAt(j - 1))) {
							ret[i + 1][j + 1] = true;
						}
					}
				} else {
					int i = 0;
					while (j > 0 && i < s.length() && !ret[i + 1][j - 1]
							&& !ret[i + 1][j]) {
						i++;
					}
					for (; i < s.length(); i++) {
						ret[i + 1][j + 1] = true;
					}
				}
			} else {
				for (int i = 0; i < s.length(); i++) {
					if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
						ret[i + 1][j + 1] = ret[i][j];
					}
				}
			}
		}
		return ret[s.length()][p.length()];
	}

	public static boolean isMatch3(String s, String p) {
		if (s.length() == 0 && p.length() == 0) {
			return true;
		}
		if (p.length() == 0) {
			return false;
		}
		boolean[][] ret = new boolean[s.length() + 1][p.length() + 1];
		ret[0][0] = true;
		for (int j = 0; j < p.length(); j++) {
			if (p.charAt(j) == '*') {
				if (j > 0 && ret[0][j - 1]) {
					ret[0][j + 1] = true;
				}
				if (j == 0) {
					continue;
				}
				if (p.charAt(j - 1) != '.') { // X*
					for (int i = 0; i < s.length(); i++) {
						if ((ret[i + 1][j])
								|| (j > 0 && ret[i + 1][j - 1])
								|| (i > 0 && j > 0 && ret[i][j + 1]
										&& s.charAt(i) == s.charAt(i - 1) && s
										.charAt(i - 1) == p.charAt(j - 1))) {
							ret[i + 1][j + 1] = true;
						}
					}
				} else {// .*
					int i = 0;
					while (j > 0 && i < s.length() && !ret[i + 1][j - 1]
							&& !ret[i + 1][j]) {
						i++;
					}
					for (; i < s.length(); i++) {
						ret[i + 1][j + 1] = true;
					}
				}
			} else {
				for (int i = 0; i < s.length(); i++) {
					if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
						ret[i + 1][j + 1] = ret[i][j];
					}
				}
			}
		}
		return ret[s.length()][p.length()];
	}
}
