package leetcode;

public class FirstMissingPositive {
	public static void main(String[] args) {
		int[] A = { 2, 2 };
		int ret = firstMissingPositive(A);
		System.out.println(ret);
	}

	public static int firstMissingPositive(int[] A) {
		for (int i = 0; i < A.length; i++) {
			int tmp;
			//exclude 2,3  &&  1,1
			while (A[i] <= A.length && A[A[i] - 1] != A[i] && A[i] > 0 && A[i] != i + 1) {
				tmp = A[A[i] - 1];
				A[A[i] - 1] = A[i];
				A[i] = tmp;
			}
		}
		for (int i = 0; i < A.length; i++) {
			if (A[i] != i + 1) {
				return i + 1;
			}
		}
		return A.length + 1;
	}
}
