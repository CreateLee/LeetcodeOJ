package com.weblee.Medium.greedy;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月23日上午9:39:34
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
	int total = 0;
	int j = -1;
	
	for (int i = 0, sum = 0; i < gas.length; ++i) {
	    sum += gas[i] - cost[i];
	    total += gas[i] - cost[i];
	    
	    if (sum < 0) {
		j = i;
		sum = 0;
	    }
	}
	
	return total >= 0 ? j + 1 : -1;
    }
}
