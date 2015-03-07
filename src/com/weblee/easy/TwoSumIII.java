package com.weblee.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2015年3月7日下午12:05:36
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class TwoSumIII {
    private Map<Integer, Integer> table = new HashMap<>();

    public void add(int input) {
	int count = table.containsKey(input) ? table.get(input) : 0;
	table.put(input, count + 1);
    }

    public boolean find(int val) {
	for (Map.Entry<Integer, Integer> entry : table.entrySet()) {
	    int num = entry.getKey();
	    int y = val - num;
	    if (y == num) {
		// For duplicates, ensure there are at least two individual
		// numbers.
		if (entry.getValue() >= 2)
		    return true;
	    } else if (table.containsKey(y)) {
		return true;
	    }
	}
	return false;
    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
