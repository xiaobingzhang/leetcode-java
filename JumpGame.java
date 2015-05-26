 

public class JumpGame {
	public static void main(String[] args) {
		int[] A = { 3,2,1,0,4};
		System.out.println(canJumpDP(A));
	}

	public static boolean canJump(int[] A) {
		int cur = 0;
		int last = 0;
		for (int i = 0; i < A.length; i++) {
			if (i > last) {
				if (cur == last && last < A.length - 1) {
					return false;
				}
				last = cur;
			}
			cur = Math.max(A[i] + i, cur);
		}
		return true;
	}

	// dp
	public static boolean canJumpDP(int[] A) {
		int[] ret = new int[A.length + 1];
		ret[0] = A[0];
		if (ret[0] == 0) {
			return false;
		}
		for (int i = 1; i < A.length; i++) {
			ret[i] = Math.max(ret[i - 1], i + A[i]);
			if (ret[i] <= i && i < A.length - 1) {
				return false;
			}
		}
		return true;
	}
}
