package com.weblee.Medium.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月23日下午3:09:44
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
	List<List<String>> ret = new ArrayList<List<String>>();
	List<String> r = new ArrayList<String>();
	int length = s.length();

	boolean[][] map = new boolean[length][length];

	findPartition(s, 0, ret, r, map);

	return ret;
    }

    private void findPartition(String s, int start, List<List<String>> ret,
	    List<String> r, boolean[][] map) {
	int length = s.length();

	if (start == length && r.size() != 0) {
	    ArrayList<String> clone = new ArrayList<String>(r);
	    ret.add(clone);
	} else {
	    for (int j = start; j < length; j++) {
		if (start == j
			|| (j - start > 1 && s.charAt(start) == s.charAt(j) && map[start + 1][j - 1])
			|| (j - start == 1 && s.charAt(start) == s.charAt(j))) {
		    map[start][j] = true;
		    r.add(s.substring(start, j + 1));

		    findPartition(s, j + 1, ret, r, map);

		    r.remove(r.size() - 1);
		}
	    }
	}
    }
}
