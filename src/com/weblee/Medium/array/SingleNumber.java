package com.weblee.Medium.array;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月20日下午9:33:34

 *************  function description  ***************
 *
 ****************************************************
 */

public class SingleNumber {
    public int singleNumber(int[] A) {
	int result = A[0];
        for (int i = 1; i<A.length; i++) {
            result = result^A[i];
        }
        
        return result;
    }
}
