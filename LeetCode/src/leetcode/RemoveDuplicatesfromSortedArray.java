package leetcode;

public class RemoveDuplicatesfromSortedArray {
	public static void main(String[] args) {
		int[] A = { 1, 1, 2, 2, 2, 2, 4, 6, 7, 8, 8, 9 };
		removeDuplicates(A);
	}

	public static int removeDuplicates(int[] A) {
		if (A.length == 0) {
			return 0;
		}
		int index = 0;
		for (int i = 1; i < A.length; i++) {
			if (A[i] != A[index]) {
				index++;
				A[index] = A[i];
			}
		}
		return index + 1;
	}
}
