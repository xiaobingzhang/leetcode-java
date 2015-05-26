 

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1, 5));
		// intervals.add(new Interval(3,5));
		// intervals.add(new Interval(6,7));
		// intervals.add(new Interval(8,10));
		// intervals.add(new Interval(12,16));
		Interval newInterval = new Interval(7, 8);
		insert(intervals, newInterval);
	}

	public static List<Interval> insert(List<Interval> intervals,
			Interval newInterval) {
		List<Interval> ret = new ArrayList<Interval>();
		if (intervals == null || intervals.size() == 0) {
			ret.add(newInterval);
			return ret;
		}
		int i;
		boolean flag = false;
		for (i = 0; i < intervals.size(); i++) {
			Interval interval = intervals.get(i);
			if (interval.end < newInterval.start) {
				ret.add(interval);
				flag =true;
			} else if(newInterval.end < interval.start){
				ret.add(newInterval);
				break;
			}
			else {
				ret.add(new Interval(Math.min(newInterval.start, interval.start), Math.max(newInterval.end, interval.end)));
				break;
			}
		}
		if (i == intervals.size()  && flag) {
			ret.add(newInterval);
		}
		for (; i < intervals.size(); i++) {
			Interval interval = ret.get(ret.size() - 1);
			if (interval.end < intervals.get(i).start) {
				ret.add(intervals.get(i));
			} else {
				ret.remove(ret.size() - 1);
				ret.add(new Interval(Math.min(intervals.get(i).start,interval.start), Math.max(intervals.get(i).end,interval.end)));
			}
		}

		return ret;

	}
}
