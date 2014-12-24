package leetcode;

public class ValidPalindrome {
	public static void main(String[] args) {
		ValidPalindrome vp = new ValidPalindrome();
		String s = "A man, a plan, a canal: Panama";
		String s1 = "race a car";
		String s2 = "   ";
		boolean ret = vp.isPalindrome(s2);

		System.out.println(ret);
	}

	public boolean isPalindrome(String s) {
		if (s.length() == 0 || s == null) {
			return true;
		}
		int len = s.length();
		for (int i = 0, j = len - 1; i <= j; ) {
			char tmp1 = s.charAt(i);
			char tmp2 = s.charAt(j);
			if((Character.isAlphabetic(tmp1)||Character.isDigit(tmp1))
					&&(Character.isAlphabetic(tmp2)||Character.isDigit(tmp2))){
				
				if(!Character.toString(tmp1).equalsIgnoreCase(Character.toString(tmp2))){
					return false; 
				}
				i++;
				j--;
			}
			if(!(Character.isAlphabetic(tmp1)||Character.isDigit(tmp1))){
				i++;
			}
			if(!(Character.isAlphabetic(tmp2)||Character.isDigit(tmp2))){
				j--;
			}
		}
		return true;
	}
}
