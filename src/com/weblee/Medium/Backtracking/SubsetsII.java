package com.weblee.Medium.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.print.attribute.Size2DSyntax;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月23日上午9:37:42
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] num) {
	if (num == null)
	    return null;

	Arrays.sort(num);

	List<List<Integer>> result = new ArrayList<List<Integer>>();
	ArrayList<ArrayList<Integer>> prev = new ArrayList<ArrayList<Integer>>();

	for (int i = num.length - 1; i >= 0; i--) {
	    // get existing sets
	    if (i == num.length - 1 || num[i] != num[i + 1] || prev.size() == 0) {
		prev = new ArrayList<ArrayList<Integer>>();
		for (int j = 0; j < result.size(); j++) {
		    prev.add(new ArrayList<Integer>(result.get(j)));
		}
	    }

	    // add current number to each element of the set
	    for (ArrayList<Integer> temp : prev) {
		temp.add(0, num[i]);
	    }

	    // add each single number as a set, only if current element is
	    // different with previous
	    if (i == num.length - 1 || num[i] != num[i + 1]) {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.add(num[i]);
		prev.add(temp);
	    }

	    // add all set created in this iteration
	    for (ArrayList<Integer> temp : prev) {
		result.add(new ArrayList<Integer>(temp));
	    }
	}

	// add empty set
	result.add(new ArrayList<Integer>());

	return result;
    }
}
