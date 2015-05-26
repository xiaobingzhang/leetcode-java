 

import java.util.Scanner;

public class ReverseInteger {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int x = sc.nextInt();
			System.out.println(new Solution3().reverse(x));
		}
	}
}

class Solution3 {
	public int reverse(int x) {
		boolean isNeg = false;
		if (x < 0) {
			isNeg = true;
			x = -x;
		}
		double ret = 0;
		while (x / 10 != 0) {
			ret = ret * 10 + x % 10;
			x = x / 10;
		}

		ret = ret * 10 + x;
		if (ret > Integer.MAX_VALUE)
			return 0;
		if (isNeg) {
			return 0 - (int) ret;
		}
		return (int) ret;
	}
}