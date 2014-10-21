package com.weblee.easy;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014��10��18������7:56:07
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
	int digits = 0;
	int tmp = x;
	// ���λ��
	while (tmp != 0) {
	    tmp /= 10;
	    digits++;
	}
	// Ϊ�õ����λ����
	int div = (int) Math.pow(10, digits - 1);
	return rec(x, div);
    }

    // �ݹ�Ƚ�
    public static boolean rec(int x, int div) {
	if (div == 0) {
	    // the exit condition of program
	    return true;
	}
	if (x < 0) { // ����
	    return false;
	}
	if (x < 10) { // һλ��
	    return true;
	}

	int quotient = (x / div) % 10; // ���λ
	int remainder = x % 10; // ���λ
	if (quotient != remainder) {
	    return false;
	}

	// ���³����ͱ�����
	return rec(x / 10, div / 100);
    }

}
