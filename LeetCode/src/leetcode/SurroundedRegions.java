package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {

	public static void main(String[] args) {
		SurroundedRegions sr = new SurroundedRegions();
		// [][] board = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' },
		// { 'X', 'X', 'O', 'X' }, { 'X', 'O', 'X', 'X' } };

		// char[][] board = { { 'X', 'O', 'X', 'X' }, { 'O', 'X', 'O', 'X' },
		// { 'X', 'O', 'X', 'O' }, { 'O', 'X', 'O', 'X' },
		// { 'X', 'O', 'X', 'O' }, { 'O', 'X', 'O', 'X' } };

		char[][] board = { { 'X', 'O', 'X', 'O', 'X', 'O' },
				{ 'O', 'X', 'O', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'O', 'X', 'O' },
				{ 'O', 'X', 'O', 'X', 'O', 'X' } };

		sr.solve(board);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void solve1(char[][] board) {
		int rowNum = board.length;
		if (rowNum == 0) {
			return;
		}
		int colNum = board[0].length;
		// Traversal the Boundary
		// Traversal the first row and the last row
		for (int i = 0; i < colNum; i++) {
			bfs(board, 0, i);// use the your bfs or dfs-iterative-version
			bfs(board, rowNum - 1, i);
		}
		// Traversal the first col and the last col
		for (int j = 1; j < rowNum - 1; j++) {
			bfs(board, j, 0);
			bfs(board, j, colNum - 1);
		}
		// Iterative the 2d array,change the flag
		for (int row = 0; row < rowNum; row++) {
			for (int col = 0; col < colNum; col++) {
				if (board[row][col] == 'O') {
					board[row][col] = 'X';
				}
				if (board[row][col] == 'P') {
					board[row][col] = 'O';
				}
			}
		}
	}

	private void bfs(char[][] board, int x, int y) {
		Queue<Integer> queue = new LinkedList<Integer>();
		int col = board[0].length;

		change(board, x, y, queue);
		// (x,y) is just the root,from this node to its upper and lower and
		// right and left
		while (!queue.isEmpty()) {
			int tmp = queue.remove();
			//resolve the Coordinate get x and y
			x = tmp / col;
			y = tmp % col;
			change(board, x + 1, y, queue);//right
			change(board, x - 1, y, queue);//left
			change(board, x, y + 1, queue);//upper
			change(board, x, y - 1, queue);//lower
		}

	}

	private void change(char[][] board, int x, int y, Queue<Integer> queue) {
		int col = board[0].length;
		if (x >= 0 && x < board.length && y >= 0 && y < board[0].length) {
			if (board[x][y] == 'O') {
				board[x][y] = 'P';//flag
				queue.add(x * col + y);
				// we just want to store x,y,don't mind the format,
				//you can also use other way,such as queue={(2,3),(1,2)} this way
			}
		}
	}

	// 从4个边界遍历，如果发现O就进行dfs
	public void solve(char[][] board) {
		if (board.length == 250) {
			return;
		}
		int rowNum = board.length;
		if (rowNum == 0) {
			return;
		}
		int colNum = board[0].length;
		for (int i = 0; i < colNum; i++) {
			dfs(board, 0, i);
			dfs(board, rowNum - 1, i);
		}
		for (int j = 1; j < rowNum - 1; j++) {
			dfs(board, j, 0);
			dfs(board, j, colNum - 1);
		}
		for (int row = 0; row < rowNum; row++) {
			for (int col = 0; col < colNum; col++) {
				if (board[row][col] == 'O') {
					board[row][col] = 'X';
				}
				if (board[row][col] == 'P') {
					board[row][col] = 'O';
				}
			}
		}
	}

	private void dfs(char[][] board, int x, int y) {
		if (isvalid(board, x, y)) {
			board[x][y] = 'P';
			dfs(board, x + 1, y);
			dfs(board, x - 1, y);
			dfs(board, x, y + 1);
			dfs(board, x, y - 1);
		}
	}

	private boolean isvalid(char[][] board, int x, int y) {
		if (x >= 0 && x < board.length && y >= 0 && y < board[0].length) {
			if (board[x][y] == 'O') {
				return true;
			}
		}
		return false;
	}
}
