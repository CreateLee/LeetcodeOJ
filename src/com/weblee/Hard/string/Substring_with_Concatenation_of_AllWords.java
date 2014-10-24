package com.weblee.Hard.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月24日下午1:04:59
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class Substring_with_Concatenation_of_AllWords {
    public List<Integer> findSubstring(String S, String[] L) {
	List<Integer> list = new ArrayList<Integer>();

	int arrLen = L.length;
	int strLen = L[0].length();
	Map<String, Integer> map = new HashMap<String, Integer>();

	for (int i = 0; i < arrLen; i++) {
	    if (map.get(L[i]) == null) {
		map.put(L[i], 1);
	    } else {
		map.put(L[i], map.get(L[i]) + 1);
	    }
	}

	Map<String, Integer> tempMap = new HashMap<String, Integer>();

	for (int i = 0; i < S.length() - arrLen * strLen + 1; i++) {
	    tempMap.clear();
	    boolean flag = true;

	    for (int j = 0; j < arrLen && flag; j++) {
		String str = S.substring(i + j * strLen, i + (j + 1) * strLen);
		if (map.containsKey(str)) {
		    tempMap.put(str,
			    tempMap.get(str) == null ? 1 : tempMap.get(str) + 1);
		    if (tempMap.get(str) > map.get(str)) {
			flag = false;
		    }
		} else {
		    flag = false;
		}

	    }

	    if (flag) {
		list.add(i);
	    }
	}

	return list;
    }
}
