package com.weblee.Medium.array;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月21日上午9:35:12
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
	int start = 0;
	int end = height.length - 1;
	int result = Integer.MIN_VALUE;

	while (start < end) {
	    int area = Math.min(height[end], height[start]) * (end - start);

	    result = Math.max(result, area);

	    if (height[start] <= height[end]) {
		start++;
	    } else {
		end--;
	    }
	}

	return result;
    }
}
