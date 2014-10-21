package com.weblee.Medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月20日上午10:43:33
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class Sum3 {
    public List<List<Integer>> threeSum(int[] num) {
	List<List<Integer>> result = new ArrayList<List<Integer>>();

	if (num.length < 3)
	    return result;

	Arrays.sort(num);

	// 用于去重
	Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();

	for (int firstPos = 0; firstPos < num.length; firstPos++) {
	    int secPos = firstPos + 1;
	    int thirdPos = num.length - 1;

	    while (secPos < thirdPos) {
		if (num[firstPos] + num[secPos] + num[thirdPos] == 0) {
		    ArrayList<Integer> midResult = new ArrayList<Integer>();
		    midResult.add(num[firstPos]);
		    midResult.add(num[secPos]);
		    midResult.add(num[thirdPos]);

		    set.add(midResult);

		    secPos += 1;
		    thirdPos -= 1;
		} else if (num[firstPos] + num[secPos] + num[thirdPos] < 0) {
		    secPos += 1;
		} else {
		    thirdPos -= 1;
		}
	    }
	}

	Iterator<ArrayList<Integer>> it = set.iterator();
	while (it.hasNext()) {
	    result.add((ArrayList<Integer>) it.next());
	}

	return result;
    }
}
