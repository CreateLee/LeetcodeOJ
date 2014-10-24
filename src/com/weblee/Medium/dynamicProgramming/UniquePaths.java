package com.weblee.Medium.dynamicProgramming;

import java.util.Arrays;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014��10��23������3:48:58
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
		// ��ߵ�f[j]����ʾ���º��f[j]���빫ʽ�е�f[i][j] ��Ӧ
		// �ұߵ�f[j]����ʾ�ϵ�f[j]���빫ʽ�е�f[i-1][j] ��Ӧ
		f[j] = f[j - 1] + f[j];
	    }
	}

	return f[n - 1];
    }
}
