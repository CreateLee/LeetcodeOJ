package com.weblee.Medium.string;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月20日下午9:32:56
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class ReverseWords_in_a_StringII {
    public void reverseWords(char[] s) {
	reverse(s, 0, s.length);
	for (int i = 0, j = 0; j <= s.length; j++) {
	    if (j == s.length || s[j] == ' ') {
		reverse(s, i, j);
		i = j + 1;
	    }
	}
    }

    private void reverse(char[] s, int begin, int end) {
	for (int i = 0; i < (end - begin) / 2; i++) {
	    char temp = s[begin + i];
	    s[begin + i] = s[end - i - 1];
	    s[end - i - 1] = temp;
	}
    }
}
