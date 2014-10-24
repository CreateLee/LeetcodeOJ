package com.weblee.Hard.array.binarySearch;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月23日下午9:30:45
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class Search_for_a_Range {
    public int[] searchRange(int[] A, int target) {
	int len = A.length;
	int srt = 0, end = len - 1;
	int left = -1, right = -1;
	
	while (srt <= end) {
	    int mid = (srt + end) / 2;
	    if (A[mid] < target)
		srt = mid + 1;
	    else if (A[mid] > target)
		end = mid - 1;
	    else {
		left = mid;
		end = mid - 1;
	    }
	}
	
	srt = 0;
	end = len - 1;
	while (srt <= end) {
	    int mid = (srt + end) / 2;
	    if (A[mid] < target)
		srt = mid + 1;
	    else if (A[mid] > target)
		end = mid - 1;
	    else {
		right = mid;
		srt = mid + 1;
	    }
	}

	return new int[] { left, right };
    }
}
