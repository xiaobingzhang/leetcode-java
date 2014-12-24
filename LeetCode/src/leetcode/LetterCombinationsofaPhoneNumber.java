package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {
	public static void main(String[] args) {
		letterCombinations2("234");
	}

	// BFS
	public static List<String> letterCombinations(String digits) {
		String[] letters = { " ", "", "abc", "def", "ghi", "jkl", "mno",
				"pqrs", "tuv", "wxyz" };
		List<String> ret = new ArrayList<String>();
		ret.add("");
		for (int i = 0; i < digits.length(); i++) {
			String s = letters[digits.charAt(i) - '0'];
			List<String> tmp = new ArrayList<String>();
			for (int j = 0; j < s.length(); j++) {
				for (int k = 0; k < ret.size(); k++) {
					tmp.add(ret.get(k) + s.substring(j, j + 1));
				}
			}
			ret = tmp;
		}
		return ret;
	}

	public static List<String> letterCombinations2(String digits) {

		List<String> ret = new ArrayList<String>();
		char[] cs = new char[digits.length()];
		dfs(digits, 0, cs, ret);
		return ret;

	}

	private static void dfs(String digits, int i, char[] cs, List<String> ret) {
		String[] letters = { " ", "", "abc", "def", "ghi", "jkl", "mno",
				"pqrs", "tuv", "wxyz" };
		if (i == digits.length()) {
			ret.add(new String(cs));
			return;
		}
		String let = letters[digits.charAt(i) - '0'];
		for (int j = 0; j < let.length(); j++) {
			cs[i] = let.charAt(j);
			dfs(digits, i + 1, cs, ret);
		}

	}

}
