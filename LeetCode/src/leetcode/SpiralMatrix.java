package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	public static void main(String[] args) {
		// int[][] matrix = { { 1, 2, 3 ,4}, { 5,6,7,8 }, {
		// 9,10,11,12},{13,14,15,16} };
		// int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9
		// },{10,11,12},{13,14,15},{16,17,18},{19,20,21} };
		// int[][] matrix = { { 1 }, { 2 }, { 3 }, { 4 }, { 5 }, { 6 }, { 7 },{
		// 8 } };
		int[][] matrix = { { 1, 2, 3 } };
		List<Integer> ret = spiralOrder(matrix);
		System.out.println(ret);
	}

	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> ret = new ArrayList<>();
		if (matrix.length == 0) {
			return ret;
		}
		int height = matrix.length;
		int colum = matrix[0].length;
		int ct = 0;
		for (int i = 0; i < (height + 1) / 2 && ct < colum; i++) {
			ct += 2;
			for (int j = i; j < matrix[i].length - i; j++) {
				ret.add(matrix[i][j]);
			}

			for (int k = i + 1; k <= height - 1 - i - 1; k++) {
				ret.add(matrix[k][matrix[i].length - 1 - i]);
			}

			if (height % 2 != 1 || i != height / 2) {
				for (int j = matrix[height - 1 - i].length - 1 - i; j >= i; j--) {
					ret.add(matrix[height - 1 - i][j]);
				}
			}
			if (i != matrix[i].length - 1 - i) {
				for (int k = height - 1 - i - 1; k >= i + 1; k--) {
					ret.add(matrix[k][i]);
				}
			}
		}
		return ret;
	}
}
