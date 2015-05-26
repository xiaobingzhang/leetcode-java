 

public class StringToInteger {
	public static void main(String[] args) {
		String str = " -0012a42";
		System.out.println(atoi(str));
	}

	public static int atoi(String str) {
		int len = str.length();
		double ret = 0;
		if (len == 0) {
			return 0;
		}
		boolean flag = false;// 判断是否开始读取数字
		int neg = 1;
		int noNeg = str.indexOf("+");
		int isNeg = str.indexOf("-");
		int begin = 0;
		if (noNeg != -1 && isNeg != -1) {
			begin = Math.min(isNeg, noNeg);
			flag = true;
		}
		if (noNeg * isNeg < 0) {
			begin = Math.max(isNeg, noNeg);
			flag = true;
		}
		if (noNeg == -1 && isNeg == -1) {
			begin = -1;
		}
		for (int i = begin + 1; i < len; i++) {
			char c = str.charAt(i);
			if (c >= '0' && c <= '9') {
				ret = ret * 10 + (c - '0');
				flag = true;
			} else if (!flag && c == ' ') {
				continue;
			} else {
				break;
			}

		}
		if (begin != -1 && str.charAt(begin) == '-') {
			neg = -1;
		}
		if (ret * neg > Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		}
		if (ret * neg < Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}
		return (int) (ret * neg);
	}
}
