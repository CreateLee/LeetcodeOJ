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
    /*
     *  这个我们就得使用位运算。我们知道任何一个整数可以表示成以2的幂为底的一组基的线性组合，
     *  即num=a_0*2^0+a_1*2^1+a_2*2^2+...+a_n*2^n。基于以上这个公式以及左移一位相当于乘以2，
     *  我们先让除数左移直到大于被除数之前得到一个最大的基。然后接下来我们每次尝试减去这个基，
     *  如果可以则结果增加加2^k,然后基继续右移迭代，直到基为0为止。
     *  因为这个方法的迭代次数是按2的幂知道超过结果，所以时间复杂度为O(logn)。
     */
    public int divide(int dividend, int divisor) {
	if (divisor == 0)
	    return Integer.MAX_VALUE;

	int res = 0;
	if (dividend == Integer.MIN_VALUE) {
	    res = 1;
	    dividend += Math.abs(divisor);
	}
	
	if (divisor == Integer.MIN_VALUE)
	    return res;
	
	boolean isNeg = ((dividend ^ divisor) >>> 31 == 1) ? true : false;
	
	dividend = Math.abs(dividend);
	divisor = Math.abs(divisor);
	int digit = 0;
	
	while (divisor <= (dividend >> 1)) {
	    divisor <<= 1;
	    digit++;
	}
	
	while (digit >= 0) {
	    if (dividend >= divisor) {
		dividend -= divisor;
		
		res += 1 << digit;
	    }
	    
	    divisor >>= 1;
	    digit--;
	}
	
	return isNeg ? -res : res;
    }
}

/*
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
    */
