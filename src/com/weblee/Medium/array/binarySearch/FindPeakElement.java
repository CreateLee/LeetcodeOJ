package com.weblee.Medium.array.binarySearch;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2015年2月17日下午8:29:16
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class FindPeakElement {
    public int findPeakElement(int[] num) {
	int low = 0;
	int high = num.length - 1;

	while (low < high) {
	    int mid1 = (low + high) / 2;
	    int mid2 = mid1 + 1;
	    if (num[mid1] < num[mid2])
		low = mid2;
	    else
		high = mid1;
	}

	return low;
    }
}
