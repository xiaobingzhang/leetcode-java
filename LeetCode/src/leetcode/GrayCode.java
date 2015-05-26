 

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
	public static void main(String[] args) {
		GrayCode g = new GrayCode();
		int n = 3;
		List<Integer> ret = g.grayCode1(n);
		for (Integer i : ret) {
			System.out.println(i);
		}
	}
	
	public List<Integer> grayCode1(int n) {
		int size = 1 << n;
		List<Integer> ret = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			ret.add(i >> 1 ^ i);
		}
		return ret;
	}
	/*
	0
	==>	
	0
	1
	==>	
	0  0
	0  1
	1  1
	1  0
	==>	
	0  0  0
	0  0  1
	0  1  1
	0  1  0
	后两位对称
	1  1  0
	1  1  1
	1  0  1
	1  0  0
	==>	
	*/	
	public List<Integer> grayCode(int n) {
		List<Integer> ret = new ArrayList<Integer>();
		ret.add(0);

		for (int i = 0; i < n; i++) {
			int len = ret.size();
			int highBit = 1 << i;
			for (int j = len - 1; j >= 0; j--) {
				ret.add(ret.get(j) + highBit);
			}
		}
		return ret;
	}
}
