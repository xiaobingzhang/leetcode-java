package leetcode;

public class LengthofLastWord {
	public static void main(String[] args) {
		String s = "Hello World";
		int ret = lengthOfLastWord(s);
		System.out.println(ret);
	}

	public static int lengthOfLastWord(String s) {
		int i = s.length() - 1;
		int lastLen = 0;
		while (i >= 0 && s.charAt(i) == ' ') {
			--i;
		}
		while (i >= 0 && s.charAt(i) != ' ') {
			++lastLen;
			--i;
		}
		return lastLen;
	}

	public static int lengthOfLastWord2(String s) {
		String[] ret = s.split(" ");
		if (ret == null || ret.length == 0) {
			return 0;
		}
		return ret[ret.length - 1].length();
	}
}
