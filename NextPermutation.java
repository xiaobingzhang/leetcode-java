 

import java.util.Arrays;

public class NextPermutation {
	public static void main(String[] args) {
		int[] num = { 1, 1, 2 };
		nextPermutation(num);
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}
	}

	public static void nextPermutation1(int[] num) {
		int l = 0;
		int r = num.length - 1;
		for (int i = num.length - 1; i > 0; i--) {
			if (num[i - 1] < num[i]) {
				l = i - 1;
				break;
			}
		}
		boolean flag = true;
		for (; r > l; r--) {
			if (num[r] > num[l]) {
				int t = num[r];
				num[r] = num[l];
				num[l] = t;
				flag = false;
				break;
			}
		}
		if (flag) {
			l--;
		}
		Arrays.sort(num, l + 1, num.length);
	}

	public static void nextPermutation(int[] num) {
		int i = num.length - 1;
		while (i > 0) {
			if (num[i - 1] < num[i]) {
				break;
			}
			i--;
		}
		int j = i;
		while (j < num.length && j > 0) {
			if (num[j] <= num[i - 1]) {
				break;
			}
			j++;
		}
		int tmp;
		j--;
		int r = num.length - 1;
		if (i == 0) {
			while (i < r) {//reverse
				tmp = num[i];
				num[i] = num[r];
				num[r] = tmp;
				i++;
				r--;
			}
		} else {
			tmp = num[i - 1];
			num[i - 1] = num[j];
			num[j] = tmp;
			while (i < r) {
				tmp = num[i];
				num[i] = num[r];
				num[r] = tmp;
				i++;
				r--;
			}
		}
	}

}
