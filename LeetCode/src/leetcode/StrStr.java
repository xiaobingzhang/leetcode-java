package leetcode;

public class StrStr {
	public static void main(String[] args) {
		String haystack = "mississippi";
		String needle = "issip";
		String ret = strStr(haystack, needle);
		System.out.println(ret);
	}

	public static String strStr(String haystack, String needle) {
		if (haystack.equals(needle) || needle.length() == 0) {
			return haystack;
		}
		for (int i = 0; i < haystack.length() - needle.length(); i++) {
			int j = 0;
			int index = i;
			while (j < needle.length()
					&& haystack.charAt(index) == needle.charAt(j)) {
				index++;
				j++;
			}
			if (j == needle.length()) {
				return haystack.substring(i);
			}
		}
		return null;
	}
}
