package com.weblee.Medium.dynamicProgramming;

import java.util.Arrays;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月23日上午9:34:03
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
	int[] f = new int[n + 1];
	Arrays.fill(f, 0);

	f[0] = 1;
	f[1] = 1;

	for (int i = 2; i <= n; ++i) {
	    for (int k = 1; k <= i; ++k)
		f[i] += f[k - 1] * f[i - k];
	}

	return f[n];

    }
}
