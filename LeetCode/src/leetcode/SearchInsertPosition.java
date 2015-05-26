 

public class SearchInsertPosition {

	public static void main(String[] args) {
		int[] A = { 1 };
		int target = 0;
		int ret = bs_searchInsert(A, target);
		System.out.println(ret);
	}

	public static int searchInsert(int[] A, int target) {
		int i = 0;
		int j = A.length - 1;
		if (A[i] > target) {
			return 0;
		}
		if (A[j] < target) {
			return A.length;
		}
		while (i < j) {
			if (A[i] < target && A[i + 1] > target) {
				return i + 1;
			}
			if (A[i] == target) {
				return i;
			}
			if (A[i + 1] == target) {
				return i + 1;
			}
			i++;
		}
		return 0;
	}

	public static int bs_searchInsert(int[] A, int target) {
		int l = 0;
		int r = A.length - 1;
		int m;
		while (l <= r) {
			m = l + (r - l) / 2;
			if (A[m] == target) {
				return m;
			}
			if (m > l && A[m] > target && A[m - 1] < target) {
				return m;
			}
			if (A[m] > target) {
				r = m - 1;
			} else {
				l = m + 1;
			}
		}
		return l;
	}

}
