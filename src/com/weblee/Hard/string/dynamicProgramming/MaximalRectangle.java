package com.weblee.Hard.string.dynamicProgramming;

import java.util.Arrays;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月24日下午2:48:32
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
	if (matrix == null || matrix.length == 0)
	    return 0;

	final int m = matrix.length;
	final int n = matrix[0].length;

	int[] H = new int[n];
	int[] L = new int[n];
	int[] R = new int[n];
	Arrays.fill(H, 0);
	Arrays.fill(L, 0);
	Arrays.fill(R, n);

	int ret = 0;

	for (int i = 0; i < m; ++i) {
	    int left = 0, right = n;
	    // calculate L(i, j) from left to right
	    for (int j = 0; j < n; ++j) {
		if (matrix[i][j] == '1') {
		    ++H[j];
		    L[j] = Math.max(L[j], left);
		} else {
		    left = j + 1;
		    H[j] = 0;
		    L[j] = 0;
		    R[j] = n;
		}
	    }

	    // calculate R(i, j) from right to left
	    for (int j = n - 1; j >= 0; --j) {
		if (matrix[i][j] == '1') {
		    R[j] = Math.min(R[j], right);
		    ret = Math.max(ret, H[j] * (R[j] - L[j]));
		} else {
		    right = j;
		}
	    }
	}

	return ret;
    }
}
