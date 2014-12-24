package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
	public static void main(String[] args) {
		Triangle t = new Triangle();
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(2);
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(3);
		list2.add(4);
		List<Integer> list3 = new ArrayList<Integer>();
		list3.add(6);
		list3.add(5);
		list3.add(7);
		List<Integer> list4 = new ArrayList<Integer>();
		list4.add(4);
		list4.add(1);
		list4.add(8);
		list4.add(3);
		triangle.add(list1);
		triangle.add(list2);
		triangle.add(list3);
		triangle.add(list4);
		int ret = t.minimumTotal1(triangle);
		System.out.println(ret);
	}

	public int minimumTotal1(List<List<Integer>> triangle) {
		int rowNum = triangle.size();
		int[] dp = new int[rowNum];
		for (int i = 0; i < triangle.get(rowNum - 1).size(); i++) {
			dp[i] = triangle.get(rowNum - 1).get(i);
		}
		for (int row = rowNum - 2; row >= 0; row--) {// for each layer
			for (int col = 0; col <= row; col++) {
				dp[col] = Math.min(dp[col], dp[col + 1])
						+ triangle.get(row).get(col);
			}
		}
		return dp[0];
	}

	public int minimumTotal(List<List<Integer>> triangle) {
		int rowNum = triangle.get(triangle.size() - 1).size();
		int colNum = triangle.size();
		int[][] dp = new int[rowNum][colNum];
		int i = 0;
		for (Integer n : triangle.get(colNum - 1)) {
			dp[rowNum - 1][i++] = n;
		}
		for (int row = rowNum - 2, m = 0; row >= 0; row--, m++) {
			for (int col = 0; col <= colNum - 2 - m; col++) {
				dp[row][col] = Math.min(dp[row + 1][col], dp[row + 1][col + 1])
						+ triangle.get(row).get(col);
			}
		}
		return dp[0][0];
	}
}
