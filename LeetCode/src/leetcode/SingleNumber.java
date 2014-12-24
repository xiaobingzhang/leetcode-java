package leetcode;

public class SingleNumber {
	public static void main(String[] args) {
		SingleNumber sn = new SingleNumber();
		int[] A = {1,2,3,4,5,6,7,8,9,10,10,9,8,6,5,4,2,1,3};
		int ret = sn.singleNumber(A );
		System.out.println(ret);
	}
	public int singleNumber(int[] A) {
		int ret = A[0];
		for (int i = 1; i < A.length; i++) {
			ret = ret^A[i];
		}
		return ret;
	}
}
