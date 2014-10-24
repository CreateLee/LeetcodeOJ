package com.weblee.Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月21日下午9:20:36
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class MaxPoints_on_a_Line {
    public int maxPoints(Point[] points) {
	if (points == null || points.length == 0)
	    return 0;
	if (points.length == 1 || points.length == 2)
	    return points.length;

	Map<Double, Integer> map = new HashMap<Double, Integer>();
	double k;
	Point p1, p2;
	int size = points.length;
	int max = 1;
	int tmp = 1;

	for (int i = 0; i < size; i++) {
	    tmp = 1;
	    map.clear(); // put all points in the map, key is the k, and value
			 // is the numbers of points of same k with p1.
	    p1 = points[i];
	    // calculate points in same line.
	    for (int j = 0; j < size; j++) {
		p2 = points[j];
		if (i == j) // do not count p1 itself.
		    continue;
		if (p1.x == p2.x && p1.y == p2.y) // if p1 and p2 is the same
						  // point,
		    tmp++;
		else {
		    if (p1.x == p2.x)
			k = Double.MAX_VALUE;
		    else
			k = ((double) p2.y - (double) p1.y)
				/ ((double) p2.x - (double) p1.x); // cast int
								   // to double
		    if (map.containsKey(k)) {
			map.put(k, map.get(k) + 1);
		    } else
			map.put(k, 1);
		}
	    }

	    int count = 0;
	    // count max number of points in same line with p1.
	    for (Integer tmpint : map.values())
		if (tmpint > count)
		    count = tmpint;
	    count += tmp;

	    if (count > max)
		max = count;
	}

	return max;
    }
}
