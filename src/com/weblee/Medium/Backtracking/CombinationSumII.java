package com.weblee.Medium.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月24日上午8:23:31
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
	List<List<Integer>> res = new ArrayList<List<Integer>>();

	if (num == null || num.length == 0)
	    return res;

	Arrays.sort(num);
	dfs(num, 0, target, new ArrayList<Integer>(), res);

	return res;
    }

    private static void dfs(int[] num, int start, int target,
	    List<Integer> item, List<List<Integer>> res) {
	if (target == 0) {
	    res.add(new ArrayList<Integer>(item));
	    return;
	}

	if (target < 0 || start >= num.length)
	    return;

	for (int i = start; i < num.length; i++) {
	    if (i > start && num[i] == num[i - 1])
		continue;

	    item.add(num[i]);

	    dfs(num, i + 1, target - num[i], item, res);

	    item.remove(item.size() - 1);
	}
    }
}
