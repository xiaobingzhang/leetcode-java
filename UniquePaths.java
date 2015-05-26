 

public class UniquePaths {
	public static void main(String[] args) {
		UniquePaths up = new UniquePaths();
		int m = 4;
		int n = 3;
		int ret = up.uniquePaths3(m, n);
		System.out.println(ret);

	}

	public int uniquePaths(int m, int n) {
		if (m == 1 || n == 1) {
			return 1;
		}
		return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
	}

	public int uniquePaths2(int m, int n) {
		int[][] ret = new int[m][n];

		for (int i = 0; i < n; i++) {
			ret[0][i] = 1;
		}
		for (int i = 0; i < m; i++) {
			ret[i][0] = 1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				ret[i][j] = ret[i - 1][j] + ret[i][j - 1];
			}
		}
		return ret[m - 1][n - 1];
	}

	public int uniquePaths3(int m, int n) {
		int[] ret = new int[n];

		for (int i = 0; i < n; i++) {
			ret[i] = 1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				ret[j] = ret[j] + ret[j - 1];
			}
		}
		return ret[n - 1];
	}

	/*
	 * First of all you should understand that we need to do n + m - 2 movements
	 * : m - 1 down, n - 1 right, because we start from cell (1, 1).
	 * 
	 * Secondly, the path it is the sequence of movements( go down / go right),
	 * therefore we can say that two paths are different when there is i-th (1
	 * .. m + n - 2) movement in path1 differ i-th movement in path2.
	 * 
	 * So, how we can build paths. Let's choose (n - 1) movements(number of
	 * steps to the right) from (m + n - 2), and rest (m - 1) is (number of
	 * steps down).
	 * 
	 * I think now it is obvious that count of different paths are all
	 * combinations (n - 1) movements from (m + n-2).
	 */
	public int uniquePath4(int m, int n) {
		int N = m + n - 2;
		int K = m - 1;
		double ret = 1;
		for(int i =1; i<=K;i++){
			ret = ret *(N-K+i)/i;
		}
		return (int) ret;
	}
}
