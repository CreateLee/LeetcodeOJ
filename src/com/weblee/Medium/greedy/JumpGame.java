package com.weblee.Medium.greedy;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月23日下午7:08:03
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class JumpGame {
    public boolean canJump(int[] A) {
	int reach = 1;

	for (int i = 0; i < reach && reach < A.length; i++) {
	    reach = Math.max(reach, i + 1 + A[i]);
	}

	return reach >= A.length;
    }
}
