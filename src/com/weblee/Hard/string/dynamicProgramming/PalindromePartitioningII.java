package com.weblee.Hard.string.dynamicProgramming;

import java.util.Arrays;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月24日下午4:53:50
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class PalindromePartitioningII {
    public int minCut(String s) {
	final int n = s.length();
	int[] f = new int[n + 1];
	boolean[][] p = new boolean[n][n];
	for (boolean[] bools : p) {
	    Arrays.fill(bools, false);
	}

	// the worst case is cutting by each char
	for (int i = 0; i <= n; i++)
	    f[i] = n - 1 - i; // 最后一个f[n]=-1
	
	for (int i = n - 1; i >= 0; i--) {
	    for (int j = i; j < n; j++) {
		if (s.charAt(i) == s.charAt(j)
			&& (j - i < 2 || p[i + 1][j - 1])) {
		    p[i][j] = true;
		    f[i] = Math.min(f[i], f[j + 1] + 1);
		}
	    }

	}
	
	return f[0];
    }
}
