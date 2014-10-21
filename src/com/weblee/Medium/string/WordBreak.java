package com.weblee.Medium.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014��10��20������9:32:19
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class WordBreak {
    /*
     * ��̬�滮:��f(i,j)��ʾ�ַ���S��i��j���Ӵ��Ƿ�ɷָ���У�f(0,n) = f(0,i) && f(i,n)
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
