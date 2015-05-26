 

public class SearchinRotatedSortedArray {
	public static void main(String[] args) {
		int target = 1;
		int[] A = { 4, 5, 6, 7, 0, 1, 2 };
		search(A, target);
	}

	public static int search(int[] A, int target) {
		int l = 0;
		int r = A.length - 1;
		int mid;
		while (l <= r) {
			mid = l + (r - l) / 2;
			if (A[mid] == target) {
				return mid;
			}
			if (A[l] <= A[mid]) {
				if (A[l] <= target && target < A[mid]) {
					r = mid - 1;
				} else {
					l = mid + 1;
				}
			} else {
				if(A[mid] < target && target <= A[r]){
					l = mid+1;
				}else{
					r = mid -1;
				}
			}
		}
		return -1;
	}

}
