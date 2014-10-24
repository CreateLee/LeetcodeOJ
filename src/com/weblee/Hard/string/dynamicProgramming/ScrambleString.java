package com.weblee.Hard.string.dynamicProgramming;

import java.util.Arrays;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月24日下午5:45:47
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
	final int N = s1.length();

	if (N != s2.length())
	    return false;
	// f[n][i][j]，表示长度为n，起点为s1[i] 和
	// 起点为s2[j] 两个字符串是否互为scramble
	boolean[][][] f = new boolean[N + 1][N][N];
	for (boolean[][] boolss : f) {
	    for (boolean[] bools : boolss) {
		Arrays.fill(bools, false);
	    }
	}

	for (int i = 0; i < N; i++)
	    for (int j = 0; j < N; j++)
		f[1][i][j] = s1.charAt(i) == s2.charAt(j);

	for (int n = 1; n <= N; ++n) {
	    for (int i = 0; i + n <= N; ++i) {
		for (int j = 0; j + n <= N; ++j) {
		    for (int k = 1; k < n; ++k) {
			if ((f[k][i][j] && f[n - k][i + k][j + k])
				|| (f[k][i][j + n - k] && f[n - k][i + k][j])) {
			    f[n][i][j] = true;

			    break;
			}
		    }
		}
	    }
	}

	return f[N][0][0];
    }
}
