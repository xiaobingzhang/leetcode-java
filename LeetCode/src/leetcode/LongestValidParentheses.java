package leetcode;

import java.util.Stack;

public class LongestValidParentheses {
	public static void main(String[] args) {
		String s = "())()";
		int ret = longestValidParentheses(s);
		System.out.println(ret);
	}

	// “所有无法匹配的')'”的index其实都是各个group的分界点
	public static int longestValidParentheses(String s) {
		Stack<Integer> stack = new Stack<Integer>();
		int ret = 0;
		int last = -1;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {// match
				stack.push(i);
			} else {// ')'
				if (stack.isEmpty()) {
					last = i;
				} else {
					stack.pop();
					if (stack.isEmpty()) {
						ret = Math.max(ret, i - last);
					} else {
						ret = Math.max(ret, i - stack.peek());
					}
				}
			}
		}
		return ret;

	}
}
