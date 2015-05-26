 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public static void main(String[] args) {
		int[] num = { -1, 0, 1, 2, -1, -4 };
		List<List<Integer>> ret = threeSum(num);
		for (List<Integer> r : ret) {
			for (Integer i : r) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

	/* http://blog.csdn.net/li4951/article/details/8693212 */
	public static List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		int len = num.length;
		if (len < 3) {
			return ret;
		}
		Arrays.sort(num);
		for (int i = 0; i <= len - 3; i++) {
			if (i != 0 && num[i] == num[i - 1]) {
				continue;
				// 跳过重复ret {0,0,0,0}
			}
			int j = i + 1;
			int k = len - 1;
			int sum = 0;
			while (j < k) {
				List<Integer> tmp = new ArrayList<Integer>();
				sum = num[j] + num[k];
				if (sum + num[i] == 0) {
					tmp.add(num[i]);
					tmp.add(num[j]);
					tmp.add(num[k]);
					ret.add(tmp);
					j++;
					k--;
					while (j < k && num[j] == num[j - 1]) {
						j++;// 去重 若j指的数字和移动前的数字相同继续移动
					}
					while (j < k && num[k] == num[k + 1]) {
						k--;// 同上
					}
				} else if (sum + num[i] < 0) {
					j++;
				} else {
					k--;
				}
			}
		}
		return ret;
	}
}
