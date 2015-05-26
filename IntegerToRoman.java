 

public class IntegerToRoman {
	public static void main(String[] args) {
		int num = 99;
		String ret = intToRoman2(num);
		System.out.println(ret);
	}

	public static String intToRoman(int num) {
		String ret = "";
		String[] symbol = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
				"IX", "V", "IV", "I" };
		int[] value = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		int i = 0;
		while (num != 0) {
			while (num >= value[i]) {
				num -= value[i];
				ret += symbol[i];
			}
			i++;
		}
		return ret;
	}

	public static String intToRoman2(int num) {
		int th = num / 1000 % 10;
		int hu = num / 100 % 10;
		int te = num / 10 % 10;
		int on = num % 10;
		String ret ="";
		ret += gen_single(th, "M", "V", "X");
		ret += gen_single(hu, "C", "D", "M");
		ret += gen_single(te, "X", "L", "C");
		ret += gen_single(on, "I", "V", "X");
		return ret;
	}

	private static String gen_single(int n, String one, String five, String ten) {
		switch (n) {
		case 1:
			return one;

		case 2:
			return one + one;

		case 3:
			return one + one + one;

		case 4:
			return one + five;

		case 5:
			return five;

		case 6:
			return five + one;

		case 7:
			return five + one + one;

		case 8:
			return five + one + one + one;

		case 9:
			return one + ten;

		}
		return "";
	}
}
