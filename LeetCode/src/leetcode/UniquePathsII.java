 

public class UniquePathsII {
	public static void main(String[] args) {
		UniquePathsII up = new UniquePathsII();
		int[][] obstacleGrid = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		int ret = up.uniquePathsWithObstacles(obstacleGrid);
		System.out.println(ret);

	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid == null || obstacleGrid.length == 0
				|| obstacleGrid[0].length == 0) {
			return 0;
		}
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[] ret = new int[n];
		ret[0] = 1;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (obstacleGrid[i][j] == 1) {
					ret[j] = 0;
				} else {
					if (j > 0) {
						ret[j] = ret[j] + ret[j - 1];
					}
				}
			}
		}
		return ret[n - 1];
	}
}
