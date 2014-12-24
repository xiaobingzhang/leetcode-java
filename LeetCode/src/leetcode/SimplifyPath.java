package leetcode;

import java.util.Stack;

public class SimplifyPath {
	public static void main(String[] args) {
		String path = "/..hiden";
		String ret = simplifyPath(path);
		System.out.println(ret);
	}

	public static String simplifyPath(String path) {
		int len = path.length();
		String ret = "";
		Stack<String> retVec = new Stack<String>();
		for (int i = 0; i < len;) {
			while (i < len && path.charAt(i) == '/') {
				i++;
			}
			if (i == len) {
				break;
			}
			int start = i;
			while (i < len && path.charAt(i) != '/') {
				i++;
			}
			int end = i;
			String elem = path.substring(start, end);
			if (elem.equals("..")) {
				if (!retVec.isEmpty()) {
					retVec.pop();
				}
			} else if (!elem.equals(".")) {
				retVec.push(elem);
			}
		}
		if (retVec.isEmpty()) {
			return "/";
		}
		while (!retVec.isEmpty()) {
			ret = "/" + retVec.pop() + ret;
		}
		return ret;

	}

}
