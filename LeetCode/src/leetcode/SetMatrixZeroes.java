 

public class SetMatrixZeroes {
	public static void main(String[] args) {
		SetMatrixZeroes s = new SetMatrixZeroes();
		// int[][] matrix={{1,0,1},{0,1,1},{1,1,1}};
		int[][] matrix = { { 0 } };

		int m = matrix.length;
		int n = matrix[0].length;
		s.setZeroes(matrix);
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + "  ");
			}
			System.out.println();
		}
	}

	public void setZeroes1(int[][] matrix) {
		int row = matrix.length;
		if (row == 0) {
			return;
		}
		int colnum = matrix[0].length;
		if (colnum == 0) {
			return;
		}
		boolean hasZeroFirstRow = false, hasZeroFirstColumn = false;
		for (int j = 0; j < colnum; j++) {
			if (matrix[0][j] == 0) {
				hasZeroFirstRow = true;
				break;
			}
		}
		for (int i = 0; i < row; ++i) {
			if (matrix[i][0] == 0) {
				hasZeroFirstColumn = true;
				break;
			}
		}
		for (int i = 1; i < matrix.length; ++i) {
	        for (int j = 1; j < matrix[0].length; ++j) {
	            if (matrix[i][j] == 0) {
	                matrix[i][0] = 0;
	                matrix[0][j] = 0;
	            }
	        }
	    }
		for (int i = 1; i < matrix.length; ++i) {
	        for (int j = 1; j < matrix[0].length; ++j) {
	            if (matrix[i][0] == 0 ||matrix[0][j] ==0) {
	                matrix[i][j] = 0;
	            }
	        }
	    }
		if (hasZeroFirstRow) {
	        for (int j = 0; j < colnum; ++j) {
	            matrix[0][j] = 0;
	        }
	    }
	    if (hasZeroFirstColumn) {
	        for (int i = 0; i < row; ++i) {
	            matrix[i][0] = 0;
	        }
	    }
	}

	public void setZeroes(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		int a[] = new int[m];
		int b[] = new int[n];
		for (int i = 0; i < m; i++) {
			a[i] = 0;
		}
		for (int i = 0; i < n; i++) {
			b[i] = 0;
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					a[i] = 1;
					b[j] = 1;
				}
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i] == 1) {
					matrix[i][j] = 0;
				} else if (b[j] == 1) {
					matrix[i][j] = 0;
				}
			}
		}
	}
}
