package leetcode;

public class MergeSortedArray {
	public static void main(String[] args) {
		int[] A = { 2, 4, 6, 8, 10, 0, 0, 0, 0, 0 };
		int[] B = { 1, 3, 5, 7, 9, 0 };
		int m = 5;
		int n = 5;
		merge(A, m, B, n);
	}

	public static void merge(int A[], int m, int B[], int n) {
		int i = 0;
		int j = 0;
		int index = 0;//
		int total = m;
		while (i < m && j < n) {
			if (A[index] < B[j]) {
				i++;
			} else {
				for (int k = total - 1; k >= index; k--) {
					A[k + 1] = A[k];
				}
				A[index] = B[j];
				j++;
				total++;//
			}
			index++;
		}

		while (j < n) {
			for (; j < n; j++) {
				A[m + j] = B[j];
			}
		}
	}

	public static void merge2(int A[], int m, int B[], int n) {
		int i = m - 1;
		int j = n - 1;
		int k = m + n - i;
		while (i >= 0 && j >= 0) {
			if (A[i] > B[j]) {
				A[k--] = A[i--];
			} else {
				A[k--] = B[j--];
			}
		}
		while (j >= 0) {
			A[k--] = B[j--];
		}
	}
}
