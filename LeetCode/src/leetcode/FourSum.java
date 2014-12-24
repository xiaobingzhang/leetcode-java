package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	public static void main(String[] args) {
		int[] num = { -1, 0, 1, 2, -1, -4 };
		int k = 0;
		List<List<Integer>> ret = fourSum(num,k);
		for (List<Integer> r : ret) {
			for (Integer i : r) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

	public static List<List<Integer>> fourSum(int[] num, int target) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		int len = num.length;
		if (len < 4) {
			return ret;
		}
		Arrays.sort(num);
		for (int i = 0; i <= len - 4; i++) {
			if (i != 0 && num[i] == num[i - 1]) {
				continue;
			}
			for (int j = i + 1; j <= len - 3; j++) {
				if (j != i + 1 && num[j] == num[j - 1]) {
					continue;
				}
				int k = j + 1;
				int l = len - 1;
				int sum = 0;
				while (k < l) {
					List<Integer> tmp = new ArrayList<Integer>();
					sum = num[i] + num[j] + num[k] + num[l];
					if (sum == target) {
						tmp.add(num[i]);
						tmp.add(num[j]);
						tmp.add(num[k]);
						tmp.add(num[l]);
						ret.add(tmp);
						k++;
						l--;
						while (k < l && num[k] == num[k - 1]) {
							k++;
						}
						while (k < l && num[l] == num[l + 1]) {
							l--;
						}
					} else if (sum < target) {
						k++;
					} else {
						l--;
					}
				}
			}
		}

		return ret;
	}
}
