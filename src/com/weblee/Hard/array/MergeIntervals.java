package com.weblee.Hard.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月24日下午12:44:29
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
	if (intervals.size() == 0 || intervals.size() == 1)
	    return intervals;
	
	List<Interval> res = new ArrayList<Interval>();
	Collections.sort(intervals, new IntervalComparator());
	Interval temp = intervals.get(0);
	
	for (int i = 1; i < intervals.size(); i++) {
	    Interval interval = intervals.get(i);
	    if (interval.start <= temp.end) {
		int start = Math.min(temp.start, interval.start);
		int end = Math.max(temp.end, interval.end);
		
		temp = new Interval(start, end);
	    } else {
		res.add(temp);
		temp = interval;
	    }
	}
	res.add(temp);

	return res;
    }
}

class IntervalComparator implements Comparator<Interval> {
    public int compare(Interval o1, Interval o2) {
	return o1.start - o2.start;
    }
}
