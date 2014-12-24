package leetcode;

public class RemoveDuplicatesfromSortedArrayII {
	public static void main(String[] args) {
		int[] A = { 1, 1, 2, 2, 2, 2, 4, 6, 7, 8, 8, 8, 9 };
		int ret = removeDuplicates1(A);
		for (int i = 0; i < ret; i++) {
			System.out.println(A[i]);
		}
	}

	public static int removeDuplicates(int[] A) {
		if (A.length == 0) {
			return 0;
		}
		int index = 0;
		int cnt = 1;
		for (int i = 1; i < A.length; i++) {
			if (cnt == 1) {
				if (A[i] == A[index]) {
					cnt = 2;
				}
				index++;
				A[index] = A[i];
			} else if (cnt == 2) {
				if (A[i] != A[index]) {
					index++;
					A[index] = A[i];
					cnt = 1;
				}
			}
		}
		return index + 1;
	}

	public static int removeDuplicates1(int[] A) {
		int n = A.length;
		if (n <= 2)
			return n; // no need to deal with n<=2 case.
		int len = 2, itor = 2;
		while (itor < n) {
			if (A[itor] != A[len - 2]){
				A[len++] = A[itor];
			}
			itor++;
		}
		return len;
	}
}
