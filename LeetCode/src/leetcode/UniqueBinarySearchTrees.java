package leetcode;

public class UniqueBinarySearchTrees {
	public static void main(String[] args) {
		UniqueBinarySearchTrees ubs = new UniqueBinarySearchTrees();
		int ret = ubs.numTrees1(3);
		System.out.println(ret);
	}

	/*
	 * 简单的dp问题
	 * num[i] = ∑ num[0...k]*[k+1 ... i]
	 */
	public int numTrees1(int n) {
		int[] num = new int[n + 1];
		num[0] = num[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				num[i] += num[j] * num[i - j - 1];
			}
		}
		return num[n];
	}

	public int numTrees(int n) {
		if (n == 1 || n == 0) {
			return 1;
		} else {
			int num = 0;
			for (int i = 0; i < n; i++) {
				num += numTrees(i) * numTrees(n - i - 1);
			}
			return num;
		}
	}
}
