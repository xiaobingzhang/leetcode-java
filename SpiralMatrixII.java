 

import java.text.DecimalFormat;

public class SpiralMatrixII {
	public static void main(String[] args) {
		int[][] a = generateMatrix(1);
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(new DecimalFormat("00").format(a[i][j]) + " ");
			}
			System.out.println();
		}
		System.out.println("--------------------------");
		a = generateMatrix(2);
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(new DecimalFormat("00").format(a[i][j]) + " ");
			}
			System.out.println();
		}
		System.out.println("--------------------------");
		a = generateMatrix(3);
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(new DecimalFormat("00").format(a[i][j]) + " ");
			}
			System.out.println();
		}
		System.out.println("--------------------------");
		int[][] b = generateMatrix(4);
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length; j++) {
				System.out.print(new DecimalFormat("00").format(b[i][j]) + " ");
			}
			System.out.println();
		}
		System.out.println("--------------------------");
		int[][] c = generateMatrix(5);
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[i].length; j++) {
				System.out.print(new DecimalFormat("00").format(c[i][j]) + " ");
			}
			System.out.println();
		}
		System.out.println("--------------------------");
		int[][] d = generateMatrix(6);
		for (int i = 0; i < d.length; i++) {
			for (int j = 0; j < d[i].length; j++) {
				System.out.print(new DecimalFormat("00").format(d[i][j]) + " ");
			}
			System.out.println();
		}
		System.out.println("--------------------------");
	}

	public static int[][] generateMatrix(int n) {
		int[][] ret = new int[n][n];
		int index = 1;
		for (int i = 0; i < n / 2; i++) {
			for (int j = i; j < n - i; j++) {
				ret[i][j] = index++;
			}
			for (int j = i + 1; j <= n - 1 - i - 1; j++) {
				ret[j][n - i - 1] = index++;
			}
			for (int j = n - i - 1; j >= i; j--) {
				ret[n - i - 1][j] = index++;
			}
			for (int j = n - i - 1 - 1; j >= i + 1; j--) {
				ret[j][i] = index++;
			}
		}
		if (n % 2 == 1) {
			ret[n / 2][n / 2] = n * n;
		}
		return ret;

	}
}
