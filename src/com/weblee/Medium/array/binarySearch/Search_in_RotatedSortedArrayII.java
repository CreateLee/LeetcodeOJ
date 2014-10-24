package com.weblee.Medium.array.binarySearch;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月23日上午9:41:17
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class Search_in_RotatedSortedArrayII {
    public boolean search(int[] A, int target) {
	int first = 0, last = A.length;

	while (first != last) {
	    int mid = (first + last) / 2;
	    // exit
	    if (A[mid] == target)
		return true;

	    if (A[first] < A[mid]) { // ASC
		if (A[first] <= target && target < A[mid])
		    last = mid;
		else
		    first = mid + 1;
	    } else if (A[first] > A[mid]) { // DESC
		if (A[mid] < target && target <= A[last - 1])
		    first = mid + 1;
		else
		    last = mid;
	    } else
		// skip duplicate one
		first++;
	}
	
	return false;
    }
}
