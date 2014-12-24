package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSequence {
	public static void main(String[] args) {
		LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
		int[] num = { 100, 4, 200, 1, 3, 2 };// 4
		int[] num1 = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };// 9
		int ret = lcs.longestConsecutive1(num1);
		System.out.println(ret);
	}

	public int longestConsecutive1(int[] num) {
		Set<Integer> set  =new HashSet<Integer>();
 		int ret = 1;
		for(int i:num){
			set.add(i);
		}
 		for(int i:num){
 			int left = i-1;
 			int right = i+1;
 			int count = 1;
 			while(set.contains(left)){
 				count++;
 				set.remove(left);
 				left--;
 			}
 			while(set.contains(right)){
 				count++;
 				set.remove(right);
 				right++;
 			}
 			ret = Math.max(count, ret);
 		}
 		return ret;
	}
	public int longestConsecutive(int[] num) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int ret = 0;
		for (int i = 0; i < num.length; i++) {
			if (map.containsKey(num[i])) {
				continue;
			}
			int lowerbound = num[i];
			int upperbound = num[i];
			if (map.containsKey(num[i] - 1)) {
				lowerbound = map.get(num[i] - 1);
			}
			if (map.containsKey(num[i] + 1)) {
				upperbound = map.get(num[i] + 1);
			}
			ret = Math.max(ret, (upperbound - lowerbound) + 1);
			map.put(num[i], num[i]);
			map.put(lowerbound, upperbound);
			map.put(upperbound, lowerbound);
		}
		return ret;
	}
}
