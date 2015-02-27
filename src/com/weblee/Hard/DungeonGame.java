package com.weblee.Hard;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2015��2��18������10:02:59
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
	// ��ά�ռ�DP����
	int m = dungeon.length;
	int n = dungeon[0].length;
	// 0225
	int[][] dp = new int[m][n];// dp[i][j]��ʾ��(i,j)��Ŀ�ĵ�(m-1,n-1)��Ҫ����С����ֵ
	// ��ʼ��
	dp[m - 1][n - 1] = Math.max(0 - dungeon[m - 1][n - 1], 0);
	for (int i = m - 2; i >= 0; i--) {
	    dp[i][n - 1] = Math.max(dp[i + 1][n - 1] - dungeon[i][n - 1], 0);
	}
	for (int i = n - 2; i >= 0; i--) {
	    dp[m - 1][i] = Math.max(dp[m - 1][i + 1] - dungeon[m - 1][i], 0);
	}
	// �������ϣ������������
	// dp����Ϊ dp[i][j] = min(dp[i][j+1], dp[i+1][j]) - dungeon[i][j] �ٺ�0ȡ���
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
