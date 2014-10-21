package com.weblee.Medium.string;

import java.util.Arrays;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月21日上午9:23:39
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String string) {
	final int MAX = 128;

	int[] last = new int[MAX];
	int start = 0;

	Arrays.fill(last, -1);

	int maxLen = 0;
 
	for (int i = 0; i < string.length(); i++) {
	    if (last[string.charAt(i)] >= start) {
		maxLen = Math.max(i - start, maxLen);

		start = last[string.charAt(i)] + 1;
	    }

	    last[string.charAt(i)] = i;
	}

	return Math.max(string.length() - start, maxLen);
    }
}
