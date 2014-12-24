package leetcode;

public class LongestCommonPrefix {
	public static void main(String[] args) {
		String[] strs = { "aca", "cba" };
		longestCommonPrefix(strs);
	}

	public static String longestCommonPrefix(String[] strs) {
		// find the longest string
		int shortestLen = Integer.MAX_VALUE;
		String ret = "";
		if (strs.length == 0) {
			return ret;
		}
		for (String s : strs) {
			shortestLen = (s.length() < shortestLen) ? s.length() : shortestLen;
		}
		for (int i = 0; i < shortestLen; i++) {
			char c = strs[0].charAt(i);
			boolean flag = true;
			for (String s : strs) {
				if (s.charAt(i) != c) {
					flag = false;
					break;
				}
			}
			if (flag) {
				ret = ret + strs[0].substring(i, i + 1);
			}else{
				break;
			}
		}
		return ret;

	}
}
