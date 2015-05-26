 

public class PlusOne {
	public int[] plusOne(int[] digits) {
		int len = digits.length;
		int plusone = 1;
		for (int i = 0; i < len; i++) {
			if (digits[i] != 9) {
				plusone = 0;
				break;
			}
		}
		int[] ret = new int[len + plusone];
		int flag = 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			int sum = digits[i] + flag;
			if (sum > 9) {
				sum = sum - 10;
				flag = 1;
			} else {
				flag = 0;
			}
			ret[i + plusone] = sum;
		}
		if (plusone == 1) {
			ret[0] = 1;
		}
		return ret;
	}
}
