 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {
	public static void main(String[] args) {

	}

	public static List<String> anagrams(String[] strs) {
		List<String> ret = new ArrayList<String>();
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (String s : strs) {
			char[] tmp = s.toCharArray();
			Arrays.sort(tmp);
			String key = new String(tmp);
			if (map.get(key) != null) {
				map.get(key).add(s);
			} else {
				List<String> val = new ArrayList<String>();
				val.add(s);
				map.put(key, val);
			}
		}
		for (String key:map.keySet()) {
			List<String> values = map.get(key);
			if (values.size() > 1) {
				ret.addAll(values);
			}
		}
		return ret;
	}
}
