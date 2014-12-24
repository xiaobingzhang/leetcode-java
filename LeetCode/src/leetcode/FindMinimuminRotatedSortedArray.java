package leetcode;

public class FindMinimuminRotatedSortedArray {
	public static void main(String[] args) {
		FindMinimuminRotatedSortedArray a = new FindMinimuminRotatedSortedArray();
		int[] num = { 1 ,1};
		System.out.println(a.findMin2(num));
	}

	public int findMin(int[] num) {
		if (num == null || num.length == 0) {
			return 0;
		}
		int l = 0;
		int r = num.length - 1;
		while (l < r ) {
			int m = l + (r - l) / 2;
			if(num[l] < num[r]){
				return num[l];
			}
			if (num[l] <= num[m]) {
				l = m + 1;//l到m之间的区间为递增区间
			} else if (num[l] > num[m]) {
				r = m; //  后半部分为递增所以m这个点留下
			} 
		}
		return num[l];
	}
///////////////////////////////////////////////////////////////////
	public int findMin2(int[] num) {
		if (num == null || num.length == 0) {
			return 0;
		}
		int l = 0;
		int r = num.length - 1;
		while (l < r && num[l] >= num[r] ) {
			int m = l + (r - l) / 2;
			if (num[r] <num[m]) {
				l = m + 1;//
			} else if (num[l] > num[m]) {
				r = m; //  后半部分为递增所以m这个点留下
			} else{// A[L] == A[M] == A[R]
				l++;
			}
		}
		return num[l];
	}

}
