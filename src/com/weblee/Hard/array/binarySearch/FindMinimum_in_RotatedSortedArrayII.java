package com.weblee.Hard.array.binarySearch;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月22日上午10:05:01
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class FindMinimum_in_RotatedSortedArrayII {
    public int findMin(int[] num) {
	int start = 0;
	int end = num.length - 1;

	while (num[start] >= num[end]) { // num[start]>=num[end]说明数组不是正向有序的，最小值不在第一个位置
	    if (end - start == 1) { // 循环结束的条件，当只有两个元素的
		return num[end];
	    }
	    int mid = (start + end) / 2;

	    if (num[start] == num[mid] && num[mid] == num[end]) {
		// 有这个条件有两种情况：1、当只有一个元素时；
		// 2、当数组中有大量重复的元素时，不可以再使用对半查找
		int minValue = num[start];
		for (int i = start + 1; i <= end; i++) {
		    if (num[i] < minValue)
			minValue = num[i];
		}

		return minValue;
	    }

	    if (num[mid] >= num[start]) { // 当出现这种情况说明最小值出现在mid与end之间
		start = mid;
	    } else { // 说明最小出现在start与mid之间
		end = mid;
	    }
	}

	return num[start]; // 这个是说明数组从start到end正向有序，所以最小值就是start位置的元素
    }
}
