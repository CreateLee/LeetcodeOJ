package com.weblee.Hard.string.dynamicProgramming;

import java.util.Arrays;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月24日下午1:18:48
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
	int[] f = new int[s.length()];
	Arrays.fill(f, 0);

	int ret = 0;
	for (int i = s.length() - 2; i >= 0; --i) {
	    int match = i + f[i + 1] + 1;
	    // case: "((...))"
	    if (s.charAt(i) == '(' && match < s.length()
		    && s.charAt(match) == ')') {
		f[i] = f[i + 1] + 2;

		// if a valid sequence exist afterwards "((...))()"
		if (match + 1 < s.length())
		    f[i] += f[match + 1];
	    }
	    
	    ret = Math.max(ret, f[i]);
	}

	return ret;
    }
}
