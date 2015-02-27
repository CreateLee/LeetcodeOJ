package com.weblee.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2015年2月18日上午9:20:12
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	List<String> result = new ArrayList<String>();

	int t = 0, i = 0, ss = s.length();

	while (i < ss)
	    
	    if (map.get(t = (t << 3 | s.charAt(i++) & 7) & 0x3FFFFFFF) == 1) {
		map.put(t = (t << 3 | s.charAt(i) & 7) & 0x3FFFFFFF,
			map.get(t = (t << 3 | s.charAt(i) & 7) & 0x3FFFFFFF) + 1);

		result.add(s.substring(i - 10, 10));
	    }

	return result;
    }
}
