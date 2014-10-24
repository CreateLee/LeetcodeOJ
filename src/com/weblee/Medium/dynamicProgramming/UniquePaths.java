package com.weblee.Medium.dynamicProgramming;

import java.util.Arrays;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月23日下午3:48:58
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class UniquePaths {
    public int uniquePaths(int m, int n) {
	int[] f = new int[n];
	Arrays.fill(f, 0);

	f[0] = 1;

	for (int i = 0; i < m; i++) {
	    for (int j = 1; j < n; j++) {
		// 左边的f[j]，表示更新后的f[j]，与公式中的f[i][j] 对应
		// 右边的f[j]，表示老的f[j]，与公式中的f[i-1][j] 对应
		f[j] = f[j - 1] + f[j];
	    }
	}

	return f[n - 1];
    }
}
