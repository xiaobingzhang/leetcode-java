 

public class RotateImage {
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		rotate(matrix);
	}

	public static void rotate(int[][] matrix) {
		int len = matrix.length;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len / 2; j++) {
				int tmp = matrix[j][i];
				matrix[j][i] = matrix[len - 1 - j][i];
				matrix[len - 1 - j][i] = tmp;
			}
		}
		for (int i = 1; i < len; i++) {
			for (int j = 0; j < i; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = tmp;
			}
		}
	}
}
