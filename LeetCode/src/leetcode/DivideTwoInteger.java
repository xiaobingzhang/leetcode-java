package leetcode;

public class DivideTwoInteger {
	public static void main(String[] args) {
		int dividend = 2147483647;
		int divisor = 1;
		System.out.println(dividend / divisor);
		System.out.println(divide(dividend, divisor));
	}

	public static int divide(int dividend, int divisor) {
		int first = 1;
		int second = 1;
		long a = dividend;
		long b = divisor;
		if (dividend < 0) {
			a = -a;
			first = -1;
		}
		if (divisor < 0) {
			b = -b;
			second = -1;
		}
		int ret = 0;
		while (a >= b) {
			{
				int count = 0;
				while (a >= b << count) {
					ret += 1 << count;
					a -= b << count;
					count++;
				}
//				long t = b;
//				for (int i = 1; a >= t; t <<= 1) {
//					a -= t;
//					ret += i;
//					i <<= 1;
//				}
			}

		}
		if ((first == 1 && second == 1) || (first == -1 && second == -1)) {
			return ret;
		}
		return -ret;
	}
}
