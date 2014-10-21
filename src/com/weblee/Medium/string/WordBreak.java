package com.weblee.Medium.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月20日下午9:32:19
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class WordBreak {
    /*
     * 动态规划:用f(i,j)表示字符串S从i到j的子串是否可分割，则有：f(0,n) = f(0,i) && f(i,n)
     */
    public boolean wordBreak(String s, Set<String> dict) {
	List<Integer> list = new ArrayList<Integer>();
	
	for (int i = s.length() - 1; i >= 0; i--) {
	    String sub = s.substring(i);
	    if (dict.contains(sub)) {
		list.add(i);
	    } else {
		for (Integer index : list) {
		    sub = s.substring(i, index);
		    if (dict.contains(sub)) {
			list.add(i);
			break;
		    }
		}
	    }
	}
	
	if (list.isEmpty()) {
	    return false;
	} else {
	    Integer index = list.get(list.size() - 1);
	    return index == 0;
	}

    }
}
