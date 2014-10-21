package com.weblee.Medium.greedy;

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

public class BestTime_to_Buy_and_SellStockII {
    public int maxProfit(int[] prices) {
	int sum = 0;

	for (int i = 1; i < prices.length; i++) {
	    int diff = prices[i] - prices[i - 1];

	    if (diff > 0) {
		sum += diff;
	    }
	}

	return sum;
    }
}
