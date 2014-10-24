package com.weblee.Medium.tree.BFS;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月23日下午3:38:27
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class WordLadder {
    public int ladderLength(String start, String end, HashSet<String> dict) {
	if (start == null || end == null)
	    return 0;

	HashMap<String, Integer> visited = new HashMap<String, Integer>();
	visited.put(start, 1);

	int size = start.length();
	String alph = "abcdefghijklmnopqrstuvwxyz";

	for (int i = 0; i < size; i++) {
	    for (int j = 0; j < 26; j++) {
		String tmp = start.substring(0, i) + alph.substring(j, j + 1)
			+ start.substring(i + 1, size);

		if (tmp.equals(end))
		    return 2;
	    }
	}

	// 使用queue BFS
	Queue<String> queue = new LinkedList<String>();
	queue.offer(start);

	while (!queue.isEmpty()) {
	    String top = queue.poll();
	    int step = visited.get(top);

	    for (int i = 0; i < size; i++) {
		for (int j = 0; j < 26; j++) {
		    // 每次更换一个字符，然后比较是与end相同 或者 是否在dict里面
		    String tmp = top.substring(0, i) + alph.substring(j, j + 1)
			    + top.substring(i + 1, size);
		    // 如果与end相同，就返回。
		    if (tmp.equals(end))
			return step + 1;
		    else if (dict.contains(tmp) && !visited.containsKey(tmp)) {
			visited.put(tmp, step + 1);
			queue.offer(tmp);
		    }
		}
	    }
	}

	return 0;
    }
}
