package com.weblee.Medium.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月24日上午8:44:33
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class Anagrams {
    public static List<String> anagrams(String[] strs) {
	ArrayList<String> ret = new ArrayList<String>();

	// 用排序过的string作为key，它的anagram作为ArrayList
	Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

	for (String string : strs) {
	    char[] tmp = string.toCharArray();
	    Arrays.sort(tmp);
	    String tmpStr = new String(tmp);
	    if (!map.containsKey(tmpStr)) {
		map.put(new String(tmpStr), new ArrayList<String>());
	    }

	    map.get(tmpStr).add(string);
	}

	// Hashtable的循环方法 keySet
	Set<String> set = map.keySet();
	// 把所有anagram添加到ret中
	for (String s : set) {
	    if (map.get(s).size() > 1) {
		ret.addAll(map.get(s));
	    }
	}

	return ret;
    }
}
