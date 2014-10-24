package com.weblee.Medium.dynamicProgramming;

import java.util.Arrays;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月23日下午3:49:32
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
	int m = obstacleGrid.length;
	int n = obstacleGrid[0].length;

	if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
	    return 0;
	}

	int[] f = new int[n];
	Arrays.fill(f, 0);

	f[0] = obstacleGrid[0][0] == 1 ? 0 : 1;

	for (int i = 0; i < m; i++)
	    for (int j = 0; j < n; j++)
		f[j] = obstacleGrid[i][j] == 1 ? 0 : (j == 0 ? 0 : f[j - 1])
			+ f[j];

	return f[n - 1];
    }
}
