package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
	public static void main(String[] args) {
		List<Interval> intervals  = new ArrayList<Interval>();
		intervals.add(new Interval(1,3));
		intervals.add(new Interval(2,6));
		intervals.add(new Interval(8,10));
		intervals.add(new Interval(15,18));
		merge(intervals );
	}

	public static List<Interval> merge(List<Interval> intervals) {
		 List<Interval> ret  = new ArrayList<Interval>();
		 if(intervals == null ||intervals.size() == 0){
			 return ret;
		 }
		 Comparator<Interval> c  = new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		};
		Collections.sort(intervals, c);
		int retIndex = 0;
		ret.add(intervals.get(0));
		for(int i = 1;i<intervals.size();i++){
			int start1 = ret.get(retIndex).start;
			int end1 = ret.get(retIndex).end;
			
			int start2 = intervals.get(i).start;
			int end2 = intervals.get(i).end;
			
			if(end1 >= start2){
				ret.remove(retIndex);
				ret.add(new Interval(start1,Math.max(end1, end2)));
			}else{
				retIndex++;
				ret.add(intervals.get(i));
			}
		}
		return ret;
	}
}

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}
