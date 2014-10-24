package com.weblee.Hard.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月24日下午12:42:45
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
	List<Interval> res = new ArrayList<Interval>();

	for (Interval each : intervals) {
	    if (each.end < newInterval.start) {
		res.add(each);
	    } else if (each.start > newInterval.end) {
		res.add(newInterval);
		newInterval = each;
	    } else if (each.end >= newInterval.start
		    || each.start <= newInterval.end) {
		int nstart = Math.min(each.start, newInterval.start);
		int nend = Math.max(newInterval.end, each.end);
		newInterval = new Interval(nstart, nend);
	    }
	}

	res.add(newInterval);

	return res;
    }
}
