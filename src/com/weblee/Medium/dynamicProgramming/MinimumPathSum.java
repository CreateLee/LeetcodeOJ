package com.weblee.Medium.dynamicProgramming;

import java.util.Arrays;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014��10��23������3:41:22
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
	Arrays.fill(f, Integer.MAX_VALUE); // ��ʼֵ��Integer.MAX_VALUE����Ϊ��������min ������

	f[0] = 0;

	for (int i = 0; i < m; i++) {
	    f[0] += grid[i][0];
	    for (int j = 1; j < n; j++) {
		// ��ߵ�f[j]����ʾ���º��f[j]���빫ʽ�е�f[i[[j] ��Ӧ
		// �ұߵ�f[j]����ʾ�ϵ�f[j]���빫ʽ�е�f[i-1][j] ��Ӧ
		f[j] = Math.min(f[j - 1], f[j]) + grid[i][j];
	    }
	}

	return f[n - 1];
    }
}
