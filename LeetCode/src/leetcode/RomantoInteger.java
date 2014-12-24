package leetcode;

public class RomantoInteger {
	public static void main(String[] args) {
		System.out.println(romanToInt("MMDCLXI"));;
	}

	public static int romanToInt(String s) {
		String[] symbol = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
				"IX", "V", "IV", "I" };
		int[] value = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		int ret = 0;
		int j = 0;
		while (s.length() != 0) {
			while (s.startsWith(symbol[j])) {
				ret += value[j];
				s = s.substring(symbol[j].length());
			}
			j++;
		}
		return ret;

	}
}
