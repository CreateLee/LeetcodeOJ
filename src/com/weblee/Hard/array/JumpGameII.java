package com.weblee.Hard.array;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月24日下午3:32:29
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class JumpGameII {
    public int jump(int[] A) {
	int result = 0;
	// the maximum distance that has been reached
	int last = 0;
	// the maximum distance that can be reached by using "ret+1" steps
	int cur = 0;

	for (int i = 0; i < A.length; ++i) {
	    if (i > last) {
		last = cur;
		++result;
	    }

	    cur = Math.max(cur, i + A[i]);
	}

	return result;
    }
}
