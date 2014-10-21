package com.weblee.Medium.Permutation;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月20日下午12:34:56
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
	List<List<Integer>> result = new ArrayList<List<Integer>>();
	ArrayList<Integer> list = new ArrayList<Integer>();

	dfs(result, n, k, 0, list);

	return result;
    }

    private void dfs(List<List<Integer>> res, int n, int gap, int index,
	    ArrayList<Integer> list) {
	if (gap == 0) {
	    ArrayList<Integer> temp = new ArrayList<Integer>(list);
	    
	    res.add(temp);
	    
	    return;
	}
	
	for (int i = index + 1; i <= n; i++) {
	    list.add(i);
	    dfs(res, n, gap - 1, i, list);
	    
	    list.remove(list.size() - 1);
	}
    }

}
