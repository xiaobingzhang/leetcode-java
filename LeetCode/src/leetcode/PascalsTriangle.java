package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
	public static void main(String[] args) {
		int rowIndex = 5;
		generate(rowIndex);
	}

	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if(numRows == 0){
			return ret;
		}
		List<Integer> one = new ArrayList<Integer>();
		one.add(1);
		ret.add(one);
		if (numRows == 1) {
			return ret;
		}
		for (int i = 2; i <= numRows; i++) {
			List<Integer> tmp = new ArrayList<Integer>();
			List<Integer> resolve = new ArrayList<Integer>();
			resolve = ret.get(i - 2);
			tmp.add(1);
			for (int j = 0; j < resolve.size() - 1; j++) {
				tmp.add(resolve.get(j) + resolve.get(j + 1));
			}
			tmp.add(1);

			ret.add(tmp);
		}
		return ret;

	}
}
