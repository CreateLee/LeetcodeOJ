package com.weblee.Medium.array.binarySearch;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月22日上午10:09:10
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class FindMinimum_in_RotatedSortedArray {
    int[] num;

    public int findMin(int start, int end) {
	if (num[start] <= num[end]) {
	    return num[start];
	}
	int middle = start + ((end - start) >> 1);
	if (num[middle] > num[end]) {
	    return findMin(middle + 1, end);
	}
	return findMin(start, middle);
    }

    public int findMin(int[] num) {
	this.num = num;
	return findMin(0, num.length - 1);
    }
}
