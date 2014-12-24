package leetcode;

public class MajorityElement {
	public static void main(String[] args) {
		MajorityElement m = new MajorityElement();
		int[] num = { 6, 5, 5 };
		int ret = m.majorityElement(num);
		System.out.println(ret);
	}

	public int majorityElement(int[] num) {
		int data = num[0];
		int cnt = 1;
		for (int i = 1; i < num.length; i++) {
			if (cnt == 0) {
				cnt = 1;
				data = num[i];
			} else if (cnt != 0 && data == num[i]) {
				cnt++;
			} else if (cnt != 0 && data != num[i]) {
				cnt--;
			}
		}
		return data;
	}
}
