package leetcode;

public class ValidSudoku {
	public static void main(String[] args) {
	}

	public static boolean isValidSudoku(char[][] board) {
		int[] rowValid;
		int[] columnValid;
		int[] subBoardValid;
		for (int i = 0; i < 9; i++) {
			rowValid = new int[10];
			columnValid = new int[10];
			subBoardValid = new int[10];
			
			for (int j = 0; j < 9; j++) {
				if (!checkValid(rowValid, board[i][j])
						|| !checkValid(columnValid, board[j][i])
						|| !checkValid(subBoardValid,
								board[3 * (i / 3) + j / 3][3 * (i % 3) + j % 3])) {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean checkValid(int[] val, char ch) {
		if (ch == '.') {
			return true;
		}
		if (val[ch - '0'] == 1) {
			return false;
		}
		val[ch - '0'] = 1;
		return true;
	}
}
