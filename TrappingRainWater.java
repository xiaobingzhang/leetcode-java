 

public class TrappingRainWater {
	public static void main(String[] args) {
		TrappingRainWater t = new TrappingRainWater();
		int[] A = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int ret = t.trap1(A);
		System.out.println(ret);
	}

	public int trap(int[] A) {
		int l = 0, r = A.length - 1;
		int all = 0, block = 0, curLevel = 0;
		while (l <= r) {
			if (Math.min(A[l], A[r]) > curLevel) {
				all += (Math.min(A[l], A[r]) - curLevel) * (r - l + 1);
				curLevel = Math.min(A[l], A[r]);
			}
			if (A[l] < A[r]) {
				block += A[l++];
			} else {
				block += A[r--];
			}

		}
		return all - block;

	}

	public int trap1(int[] A) {
		int l = 0, r = A.length - 1;
		int ret = 0;
		int leftMax = 0, rightMax = 0;
		while (l <= r) {
			leftMax = Math.max(A[l], leftMax);
			rightMax = Math.max(A[r], rightMax);
			if (leftMax < rightMax) {
				ret += (leftMax - A[l]);
				l++;
			} else {
				ret += (rightMax - A[r]);
				r--;
			}
		}
		return ret;
	}
}
