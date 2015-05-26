 

public class ReverseWordsinaString {
	public static void main(String[] args) {
		ReverseWordsinaString rws = new ReverseWordsinaString();
		String s = "    the    sky    is   blue   ";
		String ret = rws.reverseWords(s);
		System.out.println(ret);
	}

	public String reverseWords(String s) {
		s = s.trim();
		String[] ret = s.split("\\s+");
		String result = "";
		if (ret.length > 0) {
			for (int i = ret.length - 1; i > 0; i--) {
				result = result + ret[i] + " ";
			}
		}
		result += ret[0];
		return result;
	}
}
