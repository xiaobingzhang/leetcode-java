package leetcode;

public class JumpGameII {
	public static void main(String[] args) {
		int[] A = { 2, 3, 1, 1, 4 };
		System.out.println(jump2(A));
	}

	/*
	 * We use "last" to keep track of the maximum distance that has been reached
	 * by using the minimum steps "ret", whereas "curr" is the maximum distance
	 * that can be reached by using "ret+1" steps. Thus, curr = max(i+A[i])
	 * where 0 <= i <= last.
	 */
	public static int jump(int[] A) {
		int ret = 0;
		int cur = 0;
		int last = 0;
		for (int i = 0; i < A.length; i++) {
			if (i > last) {
				// can't reach
				if (cur == last && last < A.length - 1) {
					return -1;
				}
				last = cur;
				ret++;
			}
			cur = Math.max(A[i] + i, cur);
		}
		return ret;
	}

	public static int jump2(int[] A) {
		int max = 0;
		int tmp = 0;
		int ret = 0;
		int i = 0;
		while (i < A.length) {
			if (tmp >= A.length - 1) {
				break;
			}
			while (i <= tmp) {
				max = Math.max(max, i + A[i]);
				i++;
			}
			ret++;
			tmp = max;
		}
		return ret;
	}

}
