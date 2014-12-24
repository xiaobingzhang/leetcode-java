package leetcode;

import java.util.Arrays;

public class ThreeSumClosest {
	public static void main(String[] args) {
		int[] num = { 1, 1, -1, -1, 3 };
		int target = -1;
		int ret = threeSum(num, target);
		System.out.print(ret + " ");
	}

	/* http://blog.csdn.net/li4951/article/details/8693212 */
	public static int threeSum(int[] num, int target) {
		int ret = 0;
		int len = num.length;
		Arrays.sort(num);
		boolean flag = true;
		for (int i = 0; i <= len - 3; i++) {
			if (i != 0 && num[i] == num[i - 1]) {
				continue;
			}
			int j = i + 1;
			int k = len - 1;
			int sum = 0;
			while (j < k) {
				sum = num[j] + num[k] + num[i];
				if (flag || Math.abs(sum - target) < Math.abs(ret - target)) {
					ret = sum;
				}
				flag = false;
				if (sum <= target) {
					j++;
					while (j < k && num[j] == num[j - 1]) {
						j++;
					}
				} else {
					k--;
					while (j < k && num[k] == num[k + 1]) {
						k--;
					}
				}
			}
		}
		return ret;
	}
}
