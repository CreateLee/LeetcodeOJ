package com.weblee.Medium.array;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月20日下午9:34:07
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class SingleNumberII {
    public int singleNumber(int[] A) {
	int ones = 0, twos = 0, threes = 0;

	for (int i = 0; i < A.length; i++) {
	    threes = twos & A[i]; // 已经出现两次并且再次出现
	    twos = twos | ones & A[i]; // 曾经出现两次的或者曾经出现一次但是再次出现的
	    ones = ones | A[i]; // 出现一次的

	    twos = twos & ~threes; // 当某一位出现三次后，我们就从出现两次中消除该位
	    ones = ones & ~threes; // 当某一位出现三次后，我们就从出现一次中消除该位
	}

	return ones; // twos, threes最终都为0.ones是只出现一次的数
    }

}
