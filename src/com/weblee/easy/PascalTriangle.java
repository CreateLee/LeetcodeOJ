package com.weblee.easy;

import java.util.List;
import java.util.ArrayList;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月19日下午2:46:29
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
	List<List<Integer>> result = new ArrayList<List<Integer>>();

	for (int i = 0; i < numRows; i++) {
	    List<Integer> tmp = new ArrayList<Integer>();
	    tmp.clear();
	    // 初始化
	    if (i == 0) {
		tmp.add(1);
		result.add(tmp);

		continue;
	    }

	    for (int j = 0; j <= i; j++) {
		if (j == 0) {
		    tmp.add(1);
		} else if (i == j) {
		    tmp.add(1);
		} else {
		    tmp.add(result.get(i - 1).get(j - 1)
			    + result.get(i - 1).get(j));
		}
	    }
	    result.add(tmp);
	}

	return result;
    }

}
