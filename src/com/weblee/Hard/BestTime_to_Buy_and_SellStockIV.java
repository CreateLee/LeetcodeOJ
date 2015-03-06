package com.weblee.Hard;


/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2015年2月18日上午10:03:42
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class BestTime_to_Buy_and_SellStockIV {
    public int maxProfit(int k, int[] prices) {
	if (prices.length == 0) {
	    return 0;
	}

	if (k >= prices.length) {
	    return solveMaxProfit(prices);
	}

	/*
	 * 局部最优值是比较前一天并少交易一次的全局最优加上大于0的差值，
	 * 和前一天的局部最优加上差值后相比，两者之中取较大值，
	 * 而全局最优比较局部最优和前一天的全局最优 
	 */
	int[] global = new int[k + 1];
	int[] local = new int[k + 1];

	for (int i = 0; i < prices.length - 1; ++i) {
	    int diff = prices[i + 1] - prices[i];

	    for (int j = k; j >= 1; --j) {
		local[j] = Math.max(global[j - 1] + Math.max(diff, 0), local[j]
			+ diff);

		global[j] = Math.max(global[j], local[j]);
	    }
	}

	return global[k];
    }

    public static int solveMaxProfit(int[] prices) {
	int result = 0;

	for (int i = 1; i < prices.length; i++) {
	    if (prices[i] - prices[i - 1] > 0) {
		result += (prices[i] - prices[i - 1]);
	    }
	}

	return result;
    }

}
