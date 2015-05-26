 

import java.util.ArrayList;
import java.util.List;

public class NQueensII {
	public static void main(String[] args) {
		NQueensII n = new NQueensII();
		int num = 4;
		ArrayList<String[]> ret = n.solveNQueens(num);
		for (String[] strings : ret) {
			for (String string : strings) {
				System.out.println(string);
			}
			System.out.println();
		}
	}

	public ArrayList<String[]> solveNQueens(int n) {
		ArrayList<String[]> ret = new ArrayList<String[]>();
		dfs(n, 0, new int[n], ret);
		return ret;
	}

	private void dfs(int n, int row, int[] columnForRow, List<String[]> ret) {
		//组织结果
		if (row == n) {
			String[] item = new String[n];
			for (int i = 0; i < n; i++) {
				StringBuilder strRow = new StringBuilder();
				for (int j = 0; j < n; j++) {
					if (columnForRow[i] == j) {
						strRow.append("Q");
					} else {
						strRow.append(".");
					}

				}
				item[i] = strRow.toString();
			}
			ret.add(item);
			return;
		}
		for (int i = 0; i < n; i++) {
			columnForRow[row] = i;
			if (check(row, columnForRow)) {
				dfs(n, row + 1, columnForRow, ret);
			}
		}
	}

	private boolean check(int row, int[] columnForRow) {
		for (int i = 0; i < row; i++) {
			if (columnForRow[row] == columnForRow[i]
					|| Math.abs(columnForRow[row] - columnForRow[i]) == (row - i)) {
				return false;
			}
		}
		return true;
	}
}
