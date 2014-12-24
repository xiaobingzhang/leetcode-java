package leetcode;

public class ContainerWithMostWater {
	public static void main(String[] args) {
		int[] a = {};
		maxArea(a);
	}

	public static int maxArea(int[] height) {
		int ret = 0;
		for (int i = 0; i < height.length - 1; i++) {
			for (int j = i + 1; j < height.length; j++) {
				int area = Math.min(height[i], height[j]) * (j - i);
				ret = Math.max(area, ret);
			}
		}
		return ret;

	}

	public static int maxArea1(int[] height) {
		int ret = 0;
		for (int i = 1; i < height.length; i++) {
			if (height[i] == 0) {
				continue;
			}
			int maxPossibleIdx = i - ret / height[i];
			for (int j = 0; j < i && j < maxPossibleIdx; j++) {
				int area = Math.min(height[i], height[j]) * (i - j);
				ret = Math.max(area, ret);
			}
		}
		return ret;

	}

	public static int maxArea2(int[] height) {
		int ret = 0;
		int i = 0;
		int j = height.length - 1;
		if (j == 0) {
			return 0;
		}
		while (i < j) {
			int tmp = (Math.min(height[i], height[j]) * (j - i));
			if (height[i] < height[j]) {
				i++;
			} else {
				j--;
			}
			if (tmp > ret) {
				ret = tmp;
			}
		}
		return ret;
	}
}
