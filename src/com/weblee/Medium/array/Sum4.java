package com.weblee.Medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月20日下午10:15:35
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class Sum4 {
    public List<List<Integer>> fourSum(int[] num, int target) {
	List<List<Integer>> results = new ArrayList<List<Integer>>();
	if (num == null || num.length < 4) {
	    return results;
	}

	Arrays.sort(num);
	int N = num.length;

	for (int i = 0; i < N - 3; ++i) {
	    if (i > 0 && num[i] == num[i - 1]) {
		continue;
	    }

	    for (int j = i + 1; j < N - 2; ++j) {
		if (j > i + 1 && num[j] == num[j - 1]) {
		    continue;
		}
		int k = j + 1;
		int l = N - 1;

		while (k < l) {
		    if (k > j + 1 && num[k] == num[k - 1]) {
			++k;
			continue;
		    }
		    if (l < N - 1 && num[l] == num[l + 1]) {
			--l;
			continue;
		    }
		    int sum = num[i] + num[j] + num[k] + num[l];
		    if (sum < target) {
			++k;
		    } else if (sum > target) {
			--l;
		    } else {
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(num[i]);
			list.add(num[j]);
			list.add(num[k]);
			list.add(num[l]);
			results.add(list);
			++k;
		    }
		}
	    }
	}
	return results;
    }
}
