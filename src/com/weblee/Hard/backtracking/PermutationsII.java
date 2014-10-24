package com.weblee.Hard.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月24日下午2:46:14
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class PermutationsII {
    private List<List<Integer>> result;
    private int N;
    private List<Integer> list;

    public List<List<Integer>> permuteUnique(int[] num) {
	result = new ArrayList<List<Integer>>();
	N = num.length;
	list = new ArrayList<Integer>();

	for (int i = 0; i < N; ++i) {
	    list.add(num[i]);
	}
	solve(0);
	
	return result;
    }

    private void solve(int k) {
	if (k >= N) {
	    result.add(new ArrayList<Integer>(list));
	    return;
	}

	Set<Integer> set = new HashSet<Integer>();
	for (int i = k; i < N; ++i) {
	    int value = list.get(i);
	    if (!set.contains(value)) {
		swap(i, k);
		solve(k + 1);
		swap(i, k);
		set.add(value);
	    }
	}
    }

    private void swap(int i, int j) {
	int temp = list.get(i);
	list.set(i, list.get(j));
	list.set(j, temp);
    }
}
