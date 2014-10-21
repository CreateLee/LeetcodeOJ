package com.weblee.Medium.array;

import java.util.Arrays;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月20日下午6:31:20
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class Sum3Closest {
    public int threeSumClosest(int[] num, int target) {
	if (num == null || num.length < 3)
	    return 0;

	int min = Integer.MAX_VALUE;
	int val = 0;
	Arrays.sort(num);
	
	for (int i = 0; i <= num.length - 3; i++) {
	    int low = i + 1;
	    int high = num.length - 1;
	    
	    while (low < high) {
		int sum = num[i] + num[low] + num[high];
		if (Math.abs(target - sum) < min) {
		    min = Math.abs(target - sum);
		    val = sum;
		}

		if (target == sum) {
		    return val;
		} else if (target > sum) {
		    low++;
		} else {
		    high--;
		}
	    }
	}
	
	return val;
    }
}
