package com.weblee.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月19日下午2:47:15
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class PascalTriangle_II {
    public List<Integer> getRow(int rowIndex) {
	List<Integer> recordRow = null;

	for (int i = 0; i <= rowIndex; i++) {
	    List<Integer> tmp = new ArrayList<Integer>();
	    tmp.clear();
	    // 初始化
	    if (i == 0) {
		tmp.add(1);
		recordRow = tmp;

		continue;
	    }

	    for (int j = 0; j <= i; j++) {
		if (j == 0) {
		    tmp.add(1);
		} else if (i == j) {
		    tmp.add(1);
		} else {
		    tmp.add(recordRow.get(j - 1) + recordRow.get(j));
		}
	    }
	    
	    recordRow = tmp;
	}

	return recordRow;
    }
}
