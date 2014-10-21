package com.weblee.detail.strings;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月18日下午8:20:13
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class Roman2Integer {
    public int romanToInt(String s) {
	if (s.length() < 1)
	    return 0;

	int result = 0;
	int sub = char2num(s.charAt(0));
	int lastv = sub;

	for (int i = 1; i < s.length(); ++i) {
	    char curc = s.charAt(i);
	    int curv = char2num(curc);
	    if (curv == lastv)
		sub += curv;
	    else if (curv < lastv) {
		result += sub;
		sub = curv;
	    } else {
		sub = curv - sub;
	    }
	    lastv = curv;
	}
	result += sub;

	return result;
    }

    int char2num(char c) {
	switch (c) {
	case 'I':
	    return 1;
	case 'V':
	    return 5;
	case 'X':
	    return 10;
	case 'L':
	    return 50;
	case 'C':
	    return 100;
	case 'D':
	    return 500;
	case 'M':
	    return 1000;
	default:
	    return 0;
	}
    }
}
