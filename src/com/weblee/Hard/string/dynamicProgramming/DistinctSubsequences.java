package com.weblee.Hard.string.dynamicProgramming;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月24日下午5:01:11
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class DistinctSubsequences {
    public int numDistinct(String S, String T) {
	int[] f = new int[T.length() + 1];

	f[0] = 1;

	for (int i = 0; i < S.length(); ++i) {
	    for (int j = T.length() - 1; j >= 0; --j) {
		f[j + 1] += (S.charAt(i) == T.charAt(j)) ? f[j] : 0;
	    }
	}

	return f[T.length()];
    }
}
