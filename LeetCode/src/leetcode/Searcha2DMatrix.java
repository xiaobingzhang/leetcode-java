package leetcode;

public class Searcha2DMatrix {
	public static void main(String[] args) {
		Searcha2DMatrix s = new Searcha2DMatrix();
		int target = -4;

		int[][] matrix = { { -9, -7, -7, -5, -3 }, { -1, 0, 1, 3, 3 },
				{ 5, 7, 9, 11, 12 }, { 13, 14, 15, 16, 18 },
				{ 19, 21, 22, 22, 22 } };
		boolean ret = s.searchMatrix(matrix, target);
		System.out.println(ret);
	}

	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0) {
			return false;
		}
		int row = matrix.length;
		int col = matrix[0].length;
		int i;
		for (i = 0; i < row; i++) {
			if (target >= matrix[i][0] && target <= matrix[i][col - 1]) {
				break;
			}
		}
		if (i == row) {
			return false;
		}
		int l = 0;
		int r = col - 1;
		while (l <= r) {
			int m = (r - l) / 2 + l;
			if (target > matrix[i][m]) {
				l = m + 1;
			} else if (target < matrix[i][m]) {
				r = m - 1;
			} else {
				return true;
			}
		}
		return false;
	}
}
