package com.weblee.Medium.array;

import java.util.List;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月20日下午12:36:24
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
	for (int i = triangle.size() - 2; i >= 0; --i) {
	    for (int j = 0; j < i + 1; ++j) {
		triangle.get(i).set(
			j,
			triangle.get(i).get(j)
				+ Math.min(triangle.get(i + 1).get(j), triangle
					.get(i + 1).get(j + 1)));
	    }
	}

	return triangle.get(0).get(0);
    }
}
