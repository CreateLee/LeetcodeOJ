package com.weblee.detail;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月18日下午5:47:07
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class String2Integer {
    public int atoi(String str) {
	//char[] chars = str.toCharArray();

	int count = 0;
	int result = 0;
	int sign = 1;
	boolean innum = false;
	int max = Integer.MAX_VALUE;
	int premax = 214748364;
	int min = Integer.MIN_VALUE;

	while (count != str.length()) {
	    //char c = chars[count];
	    char c = str.charAt(count);

	    if (c >= '0' && c <= '9') {
		innum = true;
		int digit = c - '0';
		boolean overflow = false;
		// 去除最后一位相比较，看高位是否溢出
		if (result - premax >= 1) {
		    overflow = true;
		} else if (result == premax) {
		    // 判断最后一位是否溢出
		    overflow = digit > 7;
		}
		if (overflow)
		    return (sign == 1 ? max : min);

		result = 10 * result + (c - '0');
	    } else {
		if (innum)
		    break;
		if (c == '-') {
		    sign = -1;
		    innum = true;
		} else if (c == '+') {
		    innum = true;
		} else if (c != ' ') {
		    break;
		}
	    }
	    ++count;
	}
	return sign * result;
    }
}
