package leetcode;

import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {
		String s = "([{}]())";
		System.out.println(isValid2(s));
	}

	public static boolean isValid2(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '{' || c == '(' || c == '[') {
				stack.push(c);
			} else if (c == '}' || c == ']' || c == ')') {
				if (stack.isEmpty()) {
					return false;
				}
				char tmp = stack.pop();
				switch (c) {
				case ')':
					if (tmp != '(') {
						return false;
					}
					break;
				case '}':
					if (tmp != '{') {
						return false;
					}
					break;
				case ']':
					if (tmp != '[') {
						return false;
					}
					break;
				}
			} else {
				return false;
			}
		}
		if (stack.isEmpty()) {
			return true;
		}
		return false;
	}

	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '{' || c == '(' || c == '[') {
				stack.push(c);
			} else if (c == '}') {
				if (!stack.isEmpty() && stack.peek() == '{') {
					stack.pop();
				} else {
					return false;
				}
			} else if (c == ']') {
				if (!stack.isEmpty() && stack.peek() == '[') {
					stack.pop();
				} else {
					return false;
				}
			} else {// ')'
				if (!stack.isEmpty() && stack.peek() == '(') {
					stack.pop();
				} else {
					return false;
				}
			}
		}
		if (stack.isEmpty()) {
			return true;
		}
		return false;
	}
}
