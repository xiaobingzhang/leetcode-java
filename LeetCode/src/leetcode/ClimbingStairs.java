package leetcode;

public class ClimbingStairs {

	public static void main(String[] args) {
		ClimbingStairs cs = new ClimbingStairs();
		int ret = 0;
		int n = 3;

		System.out.println(cs.climbStairs(n) == cs.climbStairs2(n));
	}

	public int climbStairs(int n) {
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		return climbStairs(n - 1) + climbStairs(n - 2);
	}

	public int climbStairs2(int n) {
		int[] ret = new int[n + 1];
		ret[0] = 1;
		ret[1] = 1;
		for (int i = 2; i <= n; i++) {
			ret[i] = ret[i - 1] + ret[i - 2];
		}
		return ret[n];
	}
}
