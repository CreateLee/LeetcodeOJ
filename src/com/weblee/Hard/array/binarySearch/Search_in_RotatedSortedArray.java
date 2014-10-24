package com.weblee.Hard.array.binarySearch;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月24日下午2:38:34
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class Search_in_RotatedSortedArray {
    public int search(int[] A, int target) {
	int first = 0, last = A.length;
	
	while (first != last) {
	    int mid = (first + last) / 2;
	    if (A[mid] == target)
		return mid;
	    if (A[first] <= A[mid]) {
		if (A[first] <= target && target < A[mid])
		    last = mid;
		else
		    first = mid + 1;
	    } else {
		if (A[mid] < target && target <= A[last - 1])
		    first = mid + 1;
		else
		    last = mid;
	    }
	}
	
	return -1;
    }
}
