package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
	public static void main(String[] args) {
		int rowIndex = 3;
		getRow2(rowIndex);
	}

	public static List<Integer> getRow(int rowIndex) {
		List<Integer> orign = new ArrayList<Integer>();
		List<Integer> ret;
		orign.add(1);
		if (rowIndex == 0) {
			return orign;
		}
		for (int i = 1; i <= rowIndex; i++) {
			ret = new ArrayList<Integer>();
			ret.add(1);
			for (int j = 0; j < orign.size() - 1; j++) {
				ret.add(orign.get(j) + orign.get(j + 1));
			}
			ret.add(1);

			orign = ret;
		}
		return orign;
	}

	public static List<Integer> getRow2(int rowIndex) {
		List<Integer> ret = new ArrayList<Integer>();
		ret.add(1);
		for (int i = 1; i <= rowIndex; i++) {
			for (int j = i - 1; j >= 1; j--) {
				int tmp = ret.get(j - 1) + ret.get(j);
				ret.set(j, tmp);
			}
			ret.add(1);
		}
		return ret;
	}
}
