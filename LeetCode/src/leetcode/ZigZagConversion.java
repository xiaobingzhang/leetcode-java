package leetcode;

public class ZigZagConversion {
	public String convert(String s, int nRows) {
        if (nRows <= 1 || s.length() == 0) {
			return s;
		}
		String res = "";
		int len = s.length();
		for (int i = 0; i < len && i < nRows; i++) {
			int index = i;
			res += s.substring(index, index + 1);
			while(index < len) {
				if (i == 0 || i == nRows - 1) {
					index += 2 * (nRows - 1);
				}else{
					if(index %(2*nRows -2) <nRows){
						index += 2*(nRows-i-1);
					}else{
						index += 2*i;
					}
				}
				if(index <len){
					res += s.substring(index, index + 1);
				}
			}
		}
		return res;
    }
}
