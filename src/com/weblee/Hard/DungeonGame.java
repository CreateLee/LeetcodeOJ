package com.weblee.Hard;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2015年2月18日上午10:02:59
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
	// 二维空间DP问题
	int m = dungeon.length;
	int n = dungeon[0].length;
	// 0225
	int[][] dp = new int[m][n];// dp[i][j]表示从(i,j)到目的地(m-1,n-1)需要的最小生命值
	// 初始化
	dp[m - 1][n - 1] = Math.max(0 - dungeon[m - 1][n - 1], 0);
	for (int i = m - 2; i >= 0; i--) {
	    dp[i][n - 1] = Math.max(dp[i + 1][n - 1] - dungeon[i][n - 1], 0);
	}
	for (int i = n - 2; i >= 0; i--) {
	    dp[m - 1][i] = Math.max(dp[m - 1][i + 1] - dungeon[m - 1][i], 0);
	}
	// 从下向上，从右向左填表
	// dp方程为 dp[i][j] = min(dp[i][j+1], dp[i+1][j]) - dungeon[i][j] 再和0取最大
	for (int i = m - 2; i >= 0; i--) {
	    for (int j = n - 2; j >= 0; j--) {
		dp[i][j] = Math.max(Math.min(dp[i][j + 1], dp[i + 1][j])
			- dungeon[i][j], 0);
	    }
	}
	
	return dp[0][0] + 1;
	// 0234
    }
}
