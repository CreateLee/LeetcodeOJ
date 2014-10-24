package com.weblee.Medium.dynamicProgramming;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月23日下午3:48:33
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class MaximumSubarray {
    public int maxSubArray(int[] A) {
	int result = Integer.MIN_VALUE;
	int f = 0;

	for (int i = 0; i < A.length; i++) {
	    f = Math.max(f + A[i], A[i]);

	    result = Math.max(result, f);
	}

	return result;
    }
}
