package leetcode;


public class NQueens {
	public static void main(String[] args) {
		NQueens n = new NQueens();
		int num = 8;
		int ret = n.totalNQueens(num);
		System.out.println(ret);
	}

	private int count;
	public int totalNQueens(int n) {

		dfs(n, 0, new int[n]);
		return count;
	}
	private void dfs(int n, int row, int[] columnForRow) {
		if (n == row) {
			count++;
			return;
		}
		for (int i = 0; i < n; i++) {
			columnForRow[row] = i;
			if (check(row, columnForRow)) {
				dfs(n, row + 1, columnForRow);
			}
		}

	}
	private boolean check(int row, int[] columnForRow) {
		for (int i = 0; i < row; i++) {
			if (columnForRow[i] == columnForRow[row]
					|| Math.abs(columnForRow[row] - columnForRow[i]) == (row - i)) {
				return false;
			}
		}
		return true;
	}
}
