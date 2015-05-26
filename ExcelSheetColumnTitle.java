 

/*
 *   1 -> A
 2 -> B
 3 -> C
 ...
 26 -> Z
 27 -> AA
 28 -> AB 
 */
public class ExcelSheetColumnTitle {
	public static void main(String[] args) {
		ExcelSheetColumnTitle e =  new ExcelSheetColumnTitle();
		String ret = e.convertToTitle(26);
		
		System.out.println(ret+"--");
	}
	
	
	public String convertToTitle(int n) {
		String ret = "";
		while (n > 0) {
			int tmp = n % 26;
			n = (n-1) / 26;
			tmp = (tmp == 0) ? 26 : tmp;
			ret = String.valueOf((char)(tmp - 1 + 'A')) + ret;
		}
		return ret;
	}
}
