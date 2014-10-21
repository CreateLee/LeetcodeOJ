package com.weblee.Medium.dynamicProgramming;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月21日下午7:53:55
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class BestTime_to_Buy_and_SellStock {
    public int maxProfit(int[] prices) {
	if (prices.length < 2) {
	    return 0;
	}
	
	int profit = 0;
	int curMin = prices[0];
	
	for (int i=1; i < prices.length; i++) {
	    profit = Math.max(profit, prices[i] - curMin);
	    curMin = Math.min(curMin, prices[i]);
	}
	
	return profit;
    }
}
