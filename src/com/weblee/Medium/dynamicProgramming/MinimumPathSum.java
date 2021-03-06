package com.weblee.Medium.dynamicProgramming;

import java.util.Arrays;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月23日下午3:41:22
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
	final int m = grid.length;
	final int n = grid[0].length;

	int[] f = new int[n];
	Arrays.fill(f, Integer.MAX_VALUE); // 初始值是Integer.MAX_VALUE，因为后面用了min 函数。

	f[0] = 0;

	for (int i = 0; i < m; i++) {
	    f[0] += grid[i][0];
	    for (int j = 1; j < n; j++) {
		// 左边的f[j]，表示更新后的f[j]，与公式中的f[i[[j] 对应
		// 右边的f[j]，表示老的f[j]，与公式中的f[i-1][j] 对应
		f[j] = Math.min(f[j - 1], f[j]) + grid[i][j];
	    }
	}

	return f[n - 1];
    }
}
