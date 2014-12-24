package leetcode;

public class WildcardMatching {

	public static void main(String[] args) {
		System.out.println(isMatch("aa", "a")); // false
		System.out.println(isMatch("aa", "aa")); // true
		System.out.println(isMatch("aaa", "aa")); // false
		System.out.println(isMatch("aa", "*")); // true
		System.out.println(isMatch("aa", "a*")); // true
		System.out.println(isMatch("ab", "?*")); // true
		System.out.println(isMatch("aab", "c*a*b")); // false
	}

	/*
	 * ret[i],代表s的前i个字符和p的前j个字符是否匹配(这里因为每次i的结果只依赖于j-1的结果，所以不需要二维数组，
	 * 只需要一个一维数组来保存上一行结果即可），递推公式分两种情况： (1)p[j]不是'*'。情况比较简单，只要判断如果当前s的i和p的j上的字符一样
	 * （如果有p在j上的字符是'?'，也是相同），并且res[i]==true，则更新res[i+1]为true，否则res[i+1]=false;
	 * (2)p[j]是'*'。因为'*'可以匹配任意字符串，所以在前面的res[i]只要有true，那么剩下的 res[i+1],
	 * res[i+2],...,res[s.length()]就都是true了。
	 */
	public static boolean isMatch2(String s, String p) {
		if (p.length() == 0) {
			return s.length() == 0;
		}
		boolean[] ret = new boolean[s.length() + 1];
		ret[0] = true;
		for (int j = 0; j < p.length(); j++) {
			if (p.charAt(j) != '*') {
				for (int i = s.length() - 1; i >= 0; i--) {
					ret[i + 1] = ret[i]
							&& (p.charAt(j) == '?' || s.charAt(i) == p
									.charAt(j));
				}
			} else {
				int i = 0;
				while (i <= s.length() && !ret[i]) {
					i++;
				}
				for (; i <= s.length(); i++) {
					ret[i] = true;
				}
			}
			ret[0] = ret[0] && p.charAt(j) == '*';
		}
		return ret[s.length()];
	}

	public static boolean isMatch(String s, String p) {
		if (p.length() == 0) {
			return s.length() == 0;
		}
		boolean[] ret = new boolean[s.length() + 1];
		ret[0] = true;
		for (int j = 0; j < p.length(); j++) {
			if (p.charAt(j) != '*') {
				for (int i = s.length() - 1; i >= 0; i--) {
					ret[i + 1] = ret[i]
							&& (p.charAt(j) == '?' || p.charAt(j) == s
									.charAt(i));
				}
			} else {
				int i = 0;
				while (i <= s.length() && !ret[i]) {
					i++;
				}
				for(;i<=s.length();i++){
					ret[i] = true;
				}
			}
			ret[0] = ret[0]&&p.charAt(j)=='*';
		}
		return ret[s.length()];
	}

}
