package leetcode;

public class MaximumSubarray {
	public static void main(String[] args) {
		// int[] A = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int[] A = { -2, -3, -4, -5 };
		int ret = maxSubArray3(A);
		System.out.println(ret);
	}

	// divide and conquer
	public static int maxSubArray3(int[] A) {
		return helper(A, 0, A.length - 1);
	}

	private static int helper(int[] A, int l, int u) {
		if (l > u) {
			return 0;
		}
		if (l == u) {
			return A[l]; // =0
		}
		int sum = 0;
		int m = (l + u) / 2;
		int lmax = A[m];// = 0
		for (int i = m; i >= l; i--) {
			sum += A[i];
			lmax = Math.max(lmax, sum);
		}
		int rmax = A[m + 1];// =0
		sum = 0;
		for (int i = m + 1; i <= u; i++) {
			sum += A[i];
			rmax = Math.max(rmax, sum);
		}
		return Math.max(Math.max(lmax + rmax, helper(A, l, m)),
				helper(A, m + 1, u));
	}

	public static int maxSubArray(int[] A) {
		int maxsofar = A[0];
		int maxendinghere = A[0];
		for (int i = 1; i < A.length; i++) {
			maxendinghere = Math.max(maxendinghere + A[i], A[i]);
			maxsofar = Math.max(maxendinghere, maxsofar);
		}
		return maxsofar;
	}

	public static int maxSubArray2(int[] A) {
		int maxsofar = A[0];
		for (int i = 0; i < A.length; i++) {
			int sum = 0;
			for (int j = i; j < A.length; j++) {
				sum += A[j];
				maxsofar = Math.max(sum, maxsofar);
			}
		}
		return maxsofar;
	}
}
