package com.weblee.Medium;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014��10��21������9:41:28
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
	long result = 0; // ��dividend = INT_MIN ʱ��divisor = -1 ʱ����������
	final boolean sign = (dividend > 0 && divisor < 0)
		|| (dividend < 0 && divisor > 0); // ���
	
	// ��dividend = INT_MIN ʱ��-dividend �������������long
	long a = dividend >= 0 ? dividend : -dividend;
	long b = divisor >= 0 ? divisor : -divisor;

	while (a >= b) {
	    int multi = 1;
	    long bb = b;
	    while (a >= bb) {
		a -= bb;
		result += multi;
		
		if (bb < Integer.MAX_VALUE) { // ��ֹ���
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
