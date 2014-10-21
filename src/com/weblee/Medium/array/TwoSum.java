package com.weblee.Medium.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月21日上午8:38:37
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	int[] result = new int[2];

	for (int i = 0; i < numbers.length; i++) {
	    map.put(numbers[i], i);
	}

	for (int i = 0; i < numbers.length; i++) {
	    final int gap = target - numbers[i];

	    if (map.containsKey(gap) && map.get(gap) > i) {
		result[0] = i + 1;
		result[1] = map.get(gap) + 1;

		break;
	    }
	}

	return result;
    }
}
