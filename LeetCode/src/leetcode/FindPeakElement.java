package leetcode;

public class FindPeakElement {
	public static void main(String[] args) {
		FindPeakElement f = new FindPeakElement();
		int[] num = { 1,7 };
		 int ret = f.findPeakElement(num);
		 //int ret = f.findPeak(num);
		System.out.println(ret);
	}

	public int findPeak(int[] num) {
		return findPeakUtil(num, 0, num.length - 1, num.length);
	}

	private int findPeakUtil(int[] num, int low, int high, int length) {
		int mid = low + (high - low) / 2;
		if ((mid == 0 || num[mid - 1] <= num[mid])
				&& (mid == length - 1 || num[mid + 1] <= num[mid])) {
			return mid;
		} else if (mid > 0 && num[mid - 1] > num[mid]) {
			return findPeakUtil(num, low, mid - 1, length);
		} else {
			return findPeakUtil(num, mid + 1, high, length);
		}
	}

	public int findPeakElement(int[] num) {
		int len = num.length;
		int l = 0, r = num.length - 1;
		while (l <= r) {
			int m = l + (r - l) / 2;
			if ((m == 0 || (num[m - 1] <= num[m]))
					&& (m == len - 1 || (num[m + 1] <= num[m]))) {
				return m;
			}
			if (m > 0 && num[m - 1] > num[m]) {
				r = m - 1;
			} else {
				l = m + 1;
			}
		}
		return 0;
	}
}
