package com.weblee.Medium.Permutation;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月20日上午10:45:39
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class PermutationSequence {
    public String getPermutation(int n, int k) {
	int[] num = new int[n];

	// count = !n
	int count = 1;
	for (int i = 0; i < n; i++) {
	    num[i] = i + 1;
	    count *= (i + 1);
	}
	
	// n是从1开始 所以kth个 的下标为 k-1
	k--;
	StringBuilder sb = new StringBuilder();
	
	// 递归迭代
	for (int i = 0; i < n; i++) {
	    // 第i层 每个节点下有多少种排列组合，注意 count是数组的下标,数组下标从 0 开始
	    count /= n - i;
	    // 应该选第 i层的第几个，注意 selected 是数组的下标,数组下标从 0 开始
	    int selected = k / count;
	    // 剪掉 第i层前面的， 得到新k
	    k = k % count;

	    sb.append(num[selected]);

	    // restruct nums since one num has been picked
	    for (int j = selected + 1; j < n; j++) {
		num[j - 1] = num[j];
	    }
	}

	return sb.toString();
    }
}
