package com.weblee.Medium.array;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月21日上午9:45:58
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class TrappingRainWater {
    public int trap(int[] A) {
	int max = 0;

	for (int i = 1; i < A.length; i++) {
	    // find the max's position
	    if (A[i] > A[max]) {
		max = i;
	    }
	}

	int water = 0;

	for (int i = 0, peak = 0; i < max; i++) {
	    if (A[i] > peak) {
		peak = A[i];
	    } else {
		water += peak - A[i];
	    }
	}

	for (int i = A.length - 1, top = 0; i > max; i--) {
	    if (A[i] > top) {
		top = A[i];
	    } else {
		water += top - A[i];
	    }
	}

	return water;
    }
}
