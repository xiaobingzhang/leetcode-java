package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	public static void main(String[] args) {
		GenerateParentheses gp = new GenerateParentheses();
		int n = 3;
		List<String> ret = gp.generateParenthesis(n);
		for (String s : ret) {
			System.out.println(s);
		}
		System.out.println("ret count is " + ret.size());
		System.out.println("ret count is " + gp.countParenthesis(n));
	}
//卡特兰数的计算
	public int countParenthesis(int n) {
		double ret = 1;
		for (int i = 1; i <= n; i++) {
			ret *= (double)(n + i) / i;
		}
		ret = ret / (n + 1);
		return (int) ret;
	}

	public List<String> generateParenthesis(int n) {
		List<String> ret = new ArrayList<String>();
		if (n < 0) {
			return ret;
		}
		String item = "";
		helper(n, n, item, ret);
		return ret;
	}

	private void helper(int l, int r, String item, List<String> ret) {
		if (r < l) {
			return;
		}
		if (l == 0 && r == 0) {
			ret.add(item);
		}
		if (l > 0) {
			helper(l - 1, r, item + "(", ret);
		}
		if (r > 0) {
			helper(l, r - 1, item + ")", ret);
		}
	}
}
