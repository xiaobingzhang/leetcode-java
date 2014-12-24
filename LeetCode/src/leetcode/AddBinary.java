package leetcode;

public class AddBinary {
	public String addBinary(String a, String b) {
		int aLen = a.length();
		int bLen = b.length();
		if (aLen < bLen) {
			for (int i = 0; i < bLen - aLen; i++) {
				a = "0" + a;
			}
		} else if (aLen > bLen) {
			for (int i = 0; i < aLen - bLen; i++) {
				b = "0" + b;
			}
		}

		int flag = 0;
		String ret = "";
		for (int i = a.length() - 1; i >= 0; i--) {
			char cha = a.charAt(i);
			char chb = b.charAt(i);
			int sum = flag + (cha + chb - '0' - '0');
			if (sum >= 2) {
				sum = sum - 2;
				flag = 1;
			} else {
				flag = 0;
			}
			ret = sum + ret;
		}
		if (flag == 1) {
			ret = "1" + ret;
		}
		return ret;
	}
}
