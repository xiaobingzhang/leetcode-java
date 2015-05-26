 

public class Sqrtx {
	public static void main(String[] args) {
		Sqrtx sx = new Sqrtx();
		for (int i = 2; i <= 16; i++) {
			System.out.println(i + "----" + sx.sqrt1(i));
		}
	}

	public int sqrt1(int x) {// Newtown iterative
		if (x == 0) {
			return 0;
		}
		double pre = 0;
		double cur = x;
		while (Math.abs(cur - pre) > 0.00001) {
			pre = cur;
			cur = (x / pre + pre) / 2;
		}
		return (int) cur;
	}

	public int sqrt(int x) {// bs
		long mid;
		long l = 0, r = x;

		while (l <= r) {
			mid = l + (r - l) / 2;
			if (mid * mid == x) {
				return (int) mid;
			} else if (mid * mid > x) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return (int) r;
	}
}
