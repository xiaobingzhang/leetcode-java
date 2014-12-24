package leetcode;

public class CompareVersionNumbers {
	public static void main(String[] args) {
		CompareVersionNumbers c = new CompareVersionNumbers();
		String version1 = "0001";
		String version2 = "0013.37";
		int ret = c.compareVersion(version1, version2);
		System.out.println(ret);
		
	}

	public int compareVersion(String version1, String version2) {
		Integer v1, v2;
		int t1 = 0, t2 = 0;
		int ret = 0;
		while (ret == 0 && (t1 >= 0 || t2 >= 0)) {
			t1 = version1.indexOf('.');
			t2 = version2.indexOf('.');
			if (t1 < 0) {
				v1 = Integer.parseInt(version1);
				version1 = "0";
			} else {
				v1 = Integer.parseInt(version1.substring(0, t1));
				version1 = version1.substring(t1 + 1);
			}
			if (t2 < 0) {
				v2 = Integer.parseInt(version2);
				version2 = "0";
			} else {
				v2 = Integer.parseInt(version2.substring(0, t2));
				version2 = version2.substring(t2 + 1);
			}
			ret = v1.compareTo(v2);
		}
		return ret;
	}

	public int compareVersion1(String version1, String version2) {
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");
		int len = (v1.length > v2.length) ? v1.length : v2.length;
		for (int i = 0; i < len; i++) {
			Integer value1 = (i < v1.length) ? Integer.parseInt(v1[i]) : 0;
			Integer value2 = (i < v2.length) ? Integer.parseInt(v2[i]) : 0;
			int compare = value1.compareTo(value2);
			if (compare != 0) {

				return compare;
			}
		}
		return 0;
	}
}
