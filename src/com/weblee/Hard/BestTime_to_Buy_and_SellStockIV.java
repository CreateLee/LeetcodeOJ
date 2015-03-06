package com.weblee.Hard;


/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2015��2��18������10:03:42
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
	 * �ֲ�����ֵ�ǱȽ�ǰһ�첢�ٽ���һ�ε�ȫ�����ż��ϴ���0�Ĳ�ֵ��
	 * ��ǰһ��ľֲ����ż��ϲ�ֵ����ȣ�����֮��ȡ�ϴ�ֵ��
	 * ��ȫ�����űȽϾֲ����ź�ǰһ���ȫ������ 
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
