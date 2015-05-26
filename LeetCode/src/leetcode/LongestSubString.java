 


public class LongestSubString {
	public static void main(String[] args) {
		String s = "abcabcdaebcjdhb";
		int maxLen = lengthOfLongestSubstring(s);
		System.out.println(maxLen);
	}
	
	public static int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
		int index = 0;
		while (index + maxLen + 1 <= s.length()) {
			int[] m = new int[256];
			int tmp = 0;
			int i = index;
			for (; i < s.length(); i++) {
				char ts = s.charAt(i);
				if (m[ts] == 0) {
					tmp++;
					m[ts] = i + 1;
				} else {
					maxLen = Math.max(maxLen, tmp);
					index = m[ts];
					break;
				}
			}
			if (i == (s.length())) {
				maxLen = Math.max(maxLen, tmp);
				break;
			}
		}
		return maxLen;
    }
}
