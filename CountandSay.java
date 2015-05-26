 

public class CountandSay {
	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			System.out.println(countAndSay(20));
		}
	}

	public static String countAndSay(int n) {
		String ret = "1";
		for (int i = 1; i < n; i++) {
			String previous = ret;
			int count = 1;
			char say = previous.charAt(0);
			ret = "";
			for (int j = 1; j < previous.length(); j++) {
				if (say != previous.charAt(j)) {
					ret = ret + count + say;
					count = 1;
					say = previous.charAt(j);
				} else {
					count++;
				}
			}
			ret = ret + count + say;
		}
		return ret;
	}
}
