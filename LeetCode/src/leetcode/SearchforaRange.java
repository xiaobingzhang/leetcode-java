package leetcode;

public class SearchforaRange {
	public static void main(String[] args) {
		int[] A = { 5, 7, 7, 7, 8, 8, 10 };
		int target = 7;
		searchRange(A, target);
		System.out.println(tradition_bs(A, target));
		System.out.println(first_pos_bs(A, target));
		System.out.println(last_pos_bs(A, target));
	}

	public static int[] searchRange(int[] A, int target) {
		int[] ret = new int[2];
		ret[0] = first_pos_bs(A, target);
		ret[1] = last_pos_bs(A, target);
		return ret;

	}

	// 找出来即可返回，对于无重复的有序数组最合适
	public static int tradition_bs(int[] A, int target) {
		int l = 0;
		int r = A.length - 1;
		int m;
		while (l <= r) {
			m = l + (r - l) / 2;
			if (A[m] == target) {
				return m;
			} else if (A[m] < target) {
				l = m + 1;
			} else {
				r = m - 1;
			}
		}
		return -1;
	}

	// 对于重复值返回第一次出现的下标
	public static int first_pos_bs(int[] A, int target) {
		int l = 0;
		int r = A.length - 1;
		int m;
		while (l < r) {// 注意此处条件
			m = l + (r - l) / 2;
			if (A[m] < target) {
				l = m + 1;
			} else {
				r = m;
			}
		}
		if (A[l] == target) {
			return l;
		}
		return -1;
	}

	// 对于重复值返回最后一次出现的下标
	public static int last_pos_bs(int[] A, int target) {
		int l = 0;
		int r = A.length - 1;
		int m;
		while (l + 1 < r) {// 注意此处条件
			m = l + (r - l) / 2;
			if (A[m] <= target) {
				l = m;
			} else {
				r = m - 1;
			}
		}
		if (A[r] == target) {
			return r;
		} else if (A[l] == target) {
			return l;
		}
		return -1;
	}
}
