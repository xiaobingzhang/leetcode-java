 

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class MedianofTwoSortedArrays {

	public static void main(String[] args) {

		int A[] = { 2, 3, 4, 5 };
		int B[] = {};
		List<Integer> ret = new ArrayList<Integer>();
		for (int i = 0; i < A.length; i++) {
			ret.add(A[i]);
		}
		for (int i = 0; i < B.length; i++) {
			ret.add(B[i]);
		}
		Collections.sort(ret);
		System.out.println(ret.get(ret.size() / 2));
		int index = 0;
		for (Integer rr : ret) {
			System.out.print(rr + "_" + index + " ");
			index++;
		}
		double result = new Solution2().findMedianSortedArrays(A, B);
		System.out.println(result);
		System.out.println("----------------------------");
		// System.err.println(new Solution2().findKthSmallest(A, B, 2));
	}
}

class Solution2 {
	//i+j  = k-1
	private int findKthSmallest(int A[], int B[], int k) {
		int m = A.length;
		int n = B.length;
		int l = k - 1 - Math.min(k - 1, n);
		int r = Math.min(k, m);
		while (l <= r) {
			int i = l + ((r - l) / 2);
			int j = k - 1 - i;
			if (i >= 0 && i < m && (j >= n || A[i] <= B[j])
					&& (j == 0 || B[j - 1] <= A[i]))
				return A[i];
			else if (j >= 0 && j < n && (i >= m || B[j] <= A[i])
					&& (i == 0 || A[i - 1] <= B[j]))
				return B[j];
			if (j >= n || A[i] < B[j])
				l = i + 1;
			else
				r = i - 1;

		}
		return 0;

	}

	/*
	int findKthSmallest(int A[], int m, int B[], int n, int k) {
	  assert(m >= 0); assert(n >= 0); assert(k > 0); assert(k <= m+n);
	  
	  int i = (int)((double)m / (m+n) * (k-1));
	  int j = (k-1) - i;
	 
	  assert(i >= 0); assert(j >= 0); assert(i <= m); assert(j <= n);
	  // invariant: i + j = k-1
	  // Note: A[-1] = -INF and A[m] = +INF to maintain invariant
	  int Ai_1 = ((i == 0) ? INT_MIN : A[i-1]);
	  int Bj_1 = ((j == 0) ? INT_MIN : B[j-1]);
	  int Ai   = ((i == m) ? INT_MAX : A[i]);
	  int Bj   = ((j == n) ? INT_MAX : B[j]);
	 
	  if (Bj_1 < Ai && Ai < Bj)
	    return Ai;
	  else if (Ai_1 < Bj && Bj < Ai)
	    return Bj;
	 
	  assert((Ai > Bj && Ai_1 > Bj) || 
	         (Ai < Bj && Ai < Bj_1));
	 
	  // if none of the cases above, then it is either:
	  if (Ai < Bj)
	    // exclude Ai and below portion
	    // exclude Bj and above portion
	    return findKthSmallest(A+i+1, m-i-1, B, j, k-i-1);
	  else 
	    // exclude Ai and above portion
	    // exclude Bj and below portion
	    return findKthSmallest(A, i, B+j+1, n-j-1, k-j-1);
	}

	 */
	
	public double findMedianSortedArrays(int A[], int B[]) {
		if ((A.length + B.length) % 2 == 1)
			return findKthSmallest(A, B, ((A.length + B.length) / 2) + 1);
		else
			return (findKthSmallest(A, B, (A.length + B.length) / 2) + findKthSmallest(
					A, B, ((A.length + B.length) / 2) + 1)) * 0.5;

	}

	// 这个竟然通过了。。。。。好吧事件复杂度O((m+n)/2)空间复杂度O(m+n)/2
	public double findMedianSortedArrays1(int A[], int B[]) {
		int pa = 0;
		int pb = 0;
		int[] ret = new int[A.length + B.length];
		int k = 0;
		while (pa < A.length && pb < B.length) {
			if ((pa + pb) >= ((A.length + B.length) / 2 + 1)) {
				break;
			}
			if (A[pa] < B[pb]) {
				ret[k++] = A[pa++];
			} else {
				ret[k++] = B[pb++];
			}
		}
		while (pa < A.length) {
			if ((pa + pb) >= ((A.length + B.length) / 2 + 1)) {
				break;
			}
			ret[k++] = A[pa++];
		}
		while (pb < B.length) {
			if ((pa + pb) >= ((A.length + B.length) / 2 + 1)) {
				break;
			}
			ret[k++] = B[pb++];
		}
		if ((A.length + B.length) % 2 != 0) {
			return ret[(A.length + B.length) / 2];
		}
		return (double) (ret[(A.length + B.length) / 2] + ret[(A.length + B.length) / 2 - 1]) / 2;
	}

	//数组交集
	public Vector<Integer> findIntersection(int A[], int B[]) {
		Vector<Integer> intersection = new Vector<Integer>();
		int lena = A.length;
		int lenb = B.length;
		int indexa = 0, indexb = 0;
		while (indexa < lena && indexb < lenb) {
			if (A[indexa] > B[indexb]) {
				indexb++;
			} else if (A[indexa] < B[indexb]) {
				indexa++;
			} else {
				intersection.add(A[indexa]);
				indexa++;
				indexb++;
			}
		}
		return intersection;
	}
	// 失败的方法
	// public double findMedianSortedArrays1(int A[], int B[]) {
	//
	// if (A.length == 0) {
	// if (B.length % 2 != 0) {
	// return B[(B.length - 1) / 2];
	// } else {
	// return (double) (B[B.length / 2] + B[B.length / 2 - 1]) / 2;
	// }
	// }
	// if (B.length == 0) {
	// if (A.length % 2 != 0) {
	// return A[(A.length - 1) / 2];
	// } else {
	// return (double) (A[A.length / 2] + A[A.length / 2 - 1]) / 2;
	// }
	// }
	// int s1 = 0;
	// int d1 = A.length - 1;
	// int m1;
	// int s2 = 0;
	// int d2 = B.length - 1;
	// int m2;
	// while (s1 != d1 || s2 != d2) {
	// m1 = (s1 + d1) / 2;
	// m2 = (s2 + d2) / 2;
	// if (A[m1] == B[m2] && (A.length + B.length) % 2 != 0) {
	// return A[m1];
	// }
	// int lena = d1 - s1 + 1;
	// int lenb = d2 - s2 + 1;
	// if (A[m1] < B[m2]) { // 舍弃A之前半部分，B的后半部分，舍弃的长度有长度短的部分决定 s1 = s1 +
	// // lena / 2;
	// d2 = d2 - lenb / 2;
	// } else {
	// d1 = d1 - lena / 2;
	// s2 = s2 + lenb / 2;
	// }
	// }
	// if ((A.length + B.length) % 2 == 0) {
	// return (double) (A[s1] + B[s2]) / 2;
	// }
	//
	// return A[s1] < B[s2] ? A[s1] : B[s2];
	// }

}