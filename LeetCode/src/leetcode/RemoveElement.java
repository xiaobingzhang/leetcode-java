package leetcode;

public class RemoveElement {

	public static void main(String[] args) {
		int[] A = { 0,2,3,2,5 };
		int i = removeElement(A, 2);
		for(int j=0;j<i;j++){
			System.out.println(A[j]);
		}
	}

	public static int removeElement(int[] A, int elem) {
		int i = 0;
		int j = A.length - 1;
		while (i <= j) {
			if (A[i] != elem) {
				i++;
			} else {
				A[i] = A[j];
				A[j] = elem;
				j--;
			}
		}
		return i ;
//		 int cnt = 0;
//			for (int i = 0; i < A.length; i++) {
//				if(A[i] != elem){
//					cnt++;
//				}
//			}
//			return cnt;
	}
}
