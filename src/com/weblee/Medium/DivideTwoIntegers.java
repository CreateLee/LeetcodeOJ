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
    /*
     *  ������Ǿ͵�ʹ��λ���㡣����֪���κ�һ���������Ա�ʾ����2����Ϊ�׵�һ�����������ϣ�
     *  ��num=a_0*2^0+a_1*2^1+a_2*2^2+...+a_n*2^n���������������ʽ�Լ�����һλ�൱�ڳ���2��
     *  �������ó�������ֱ�����ڱ�����֮ǰ�õ�һ�����Ļ���Ȼ�����������ÿ�γ��Լ�ȥ�������
     *  ��������������Ӽ�2^k,Ȼ����������Ƶ�����ֱ����Ϊ0Ϊֹ��
     *  ��Ϊ��������ĵ��������ǰ�2����֪���������������ʱ�临�Ӷ�ΪO(logn)��
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
    */
