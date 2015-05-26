 

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public static void main(String[] args) {
		Solution1 s = new Solution1();
		int[] numbers = { 3, 2, 4 };
		int target = 6;
		int[] ret = s.twoSum(numbers, target);
		for (int i : ret) {
			System.out.println(i);
		}
	}
}

class Solution1 {
	public int[] twoSum(int[] numbers, int target) {
		int[] ret = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < numbers.length; i++) {
			Integer n = map.get(numbers[i]);
			if (n == null) {
				map.put(numbers[i], i);
			}
			n = map.get(target - numbers[i]);
			if (n != null && n < i) {
				ret[0] = n + 1;
				ret[1] = i + 1;
				return ret;
			}
		}
		return ret;
	}
}