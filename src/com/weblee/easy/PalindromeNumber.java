package com.weblee.easy;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月18日下午7:56:07
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
	int digits = 0;
	int tmp = x;
	// 算出位数
	while (tmp != 0) {
	    tmp /= 10;
	    digits++;
	}
	// 为得到最高位服务
	int div = (int) Math.pow(10, digits - 1);
	return rec(x, div);
    }

    // 递归比较
    public static boolean rec(int x, int div) {
	if (div == 0) {
	    // the exit condition of program
	    return true;
	}
	if (x < 0) { // 负数
	    return false;
	}
	if (x < 10) { // 一位数
	    return true;
	}

	int quotient = (x / div) % 10; // 最高位
	int remainder = x % 10; // 最低位
	if (quotient != remainder) {
	    return false;
	}

	// 更新除数和被除数
	return rec(x / 10, div / 100);
    }

}
