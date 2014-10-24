package com.weblee.Hard.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月24日下午4:45:12
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num) {
	Map<Integer, Boolean> used = new HashMap<Integer, Boolean>();

	for (int tmp : num) {
	    used.put(tmp, false);
	}

	int longest = 0;

	for (int i : num) {
	    if (used.get(i))
		continue;

	    int length = 1;
	    used.put(i, true);

	    for (int j = i + 1; used.containsKey(j); ++j) {
		 used.put(j, true);
		++length;
	    }

	    for (int j = i - 1; used.containsKey(j); --j) {
		 used.put(j, true);
		++length;
	    }

	    longest = Math.max(longest, length);
	}

	return longest;
    }
}
