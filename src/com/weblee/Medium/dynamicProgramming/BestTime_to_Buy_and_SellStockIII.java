package com.weblee.Medium.dynamicProgramming;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月21日下午8:03:41
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class BestTime_to_Buy_and_SellStockIII {
    public int maxProfit(int[] prices) {
	if (prices.length < 2) {
	    return 0;
	}

	final int n = prices.length;

	int[] f = new int[n];
	Arrays.fill(f, 0);

	int[] g = new int[n];
	Arrays.fill(g, 0);

	for (int i = 1, valley = prices[0]; i < n; ++i) {
	    valley = Math.min(valley, prices[i]);
	    f[i] = Math.max(f[i - 1], prices[i] - valley);
	}

	for (int i = n - 2, peak = prices[n - 1]; i >= 0; --i) {
	    peak = Math.max(peak, prices[i]);
	    g[i] = Math.max(g[i], peak - prices[i]);
	}

	int maxProfit = 0;
	for (int i = 0; i < n; ++i) {
	    maxProfit = Math.max(maxProfit, f[i] + g[i]);
	}

	return maxProfit;
    }
}
