package com.weblee.Medium;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月21日下午9:40:42
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class Sqrt {
    public int sqrt(int x) {
	int left = 1, right = x / 2;
	int lastMid = 0;

	if (x < 2) {
	    return x;
	}

	while (left <= right) {
	    final int mid = left + (right - left) / 2;

	    if (x / mid > mid) {
		left = mid + 1;
		lastMid = mid;
	    } else if (x / mid < mid) {
		right = mid - 1;
	    } else {
		return mid;
	    }
	}

	return lastMid;
    }
}
