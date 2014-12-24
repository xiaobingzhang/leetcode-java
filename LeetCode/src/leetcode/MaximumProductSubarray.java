package leetcode;

/*
 * Besides keeping track of the largest product, we also need to keep track of the smallest product. Why? The smallest product, which is the largest in the negative sense could become the maximum when being multiplied by a negative number.

 Let us denote that:

 f(k) = Largest product subarray, from index 0 up to k.
 Similarly,

 g(k) = Smallest product subarray, from index 0 up to k.
 Then,

 f(k) = max( f(k-1) * A[k], A[k], g(k-1) * A[k] )
 g(k) = min( g(k-1) * A[k], A[k], f(k-1) * A[k] )
 */
public class MaximumProductSubarray {
	public static void main(String[] args) {
		MaximumProductSubarray m = new MaximumProductSubarray();
		int[] A = { -2, -3, 4, -1, -2, 1, 5, -3 };
		int ret = m.maxProduct(A);
		System.out.println(ret);
	}

	public int maxProduct(int[] A) {
		assert A.length > 0;

		int curr_max = A[0];
		int curr_min = A[0];
		int ret = A[0];
		for (int i = 1; i < A.length; i++) {
			int mx = curr_max,mn = curr_min;
			curr_max = max(A[i] * mn,max(A[i], A[i] * mx));
			curr_min = min(A[i] * mn, min(A[i], A[i] * mx));
			ret = max(ret, curr_max);
		}
		return ret;
	}

	public int maxProduct1(int[] A) {
		return 0;
	}

	// 最大连续数组和
	public int maxConsequenceSum(int[] A) {
		int max_so_far = A[0];
		int curr_max = A[0];

		for (int num : A) {
			curr_max = max(num, (curr_max + num));
			max_so_far = max(max_so_far, curr_max);
		}
		return max_so_far;
	}

	public int max(int x, int y) {
		return (x > y) ? x : y;
	}

	public int min(int x, int y) {
		return (x > y) ? y : x;
	}
}
