package com.weblee.Medium;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月21日下午9:41:28
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
	long result = 0; // 当dividend = INT_MIN 时，divisor = -1 时，结果会溢出
	final boolean sign = (dividend > 0 && divisor < 0)
		|| (dividend < 0 && divisor > 0); // 异号
	
	// 当dividend = INT_MIN 时，-dividend 会溢出，所以用long
	long a = dividend >= 0 ? dividend : -dividend;
	long b = divisor >= 0 ? divisor : -divisor;

	while (a >= b) {
	    int multi = 1;
	    long bb = b;
	    while (a >= bb) {
		a -= bb;
		result += multi;
		
		if (bb < Integer.MAX_VALUE) { // 防止溢出
		    bb += bb;
		    multi += multi;
		}
	    }
	}
	
	if (sign)
	    return (int) -result;
	else
	    return (int) result;
    }
}
