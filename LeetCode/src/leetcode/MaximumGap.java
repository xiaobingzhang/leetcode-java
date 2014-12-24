package leetcode;

import java.util.Arrays;

public class MaximumGap {
	public static void main(String[] args) {
		MaximumGap m = new MaximumGap();
		int[] num = { 1, 1,1,1,2,2,2,2,5,5,5,5 };
		int ret = m.maximumGap(num);
		int ret1 = m.maximumGap1(num);
		System.out.println(ret);
		System.out.println(ret1);
	}

	public int maximumGap(int[] num) {
		Arrays.sort(num);
		int ret = 0;
		for (int i = 1; i < num.length; i++) {
			int gap = num[i] - num[i - 1];
			ret = Math.max(gap, ret);
		}
		return ret;
	}

	public int maximumGap1(int[] num) {
		if (num.length < 2) {
			return 0;
		}
		int A = num[0];
		int B = num[0];
		for (int i : num) {
			A = Math.min(A, i);
			B = Math.max(B, i);
		}
		int N = num.length;
		
		int len = (int) Math.ceil((double)(B-A)/(N-1));
		//int len = (B - A) / N + 1;
		//以上两句都可以使用
		int size = (B - A) / len + 1;
		int[] minBucket = new int[size];
		int[] maxBucket = new int[size];

		for (int k : num) {
			int loc = (k - A) / len;
			if (minBucket[loc] == 0) {
				minBucket[loc] = k;
				maxBucket[loc] = k;
			} else {
				minBucket[loc] = Math.min(minBucket[loc], k);
				maxBucket[loc] = Math.max(maxBucket[loc], k);
			}
		}
		int gap = 0;
		int pre = maxBucket[0];
		for (int i = 0; i < size; i++) {
			if (maxBucket[i] == 0) {
				continue;
			}
			gap = Math.max(gap, minBucket[i] - pre);
			pre = maxBucket[i];
		}
		return gap;
	}
}