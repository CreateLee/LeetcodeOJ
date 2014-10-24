package com.weblee.Medium.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月23日下午2:52:02
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class SimplifyPath {
    public String simplifyPath(String path) {
	if (path == null)
	    return null;

	String[] strs = path.split("/");
	Stack<String> stack = new Stack<String>();

	for (int i = 0; i < strs.length; i++) {
	    String s = strs[i];
	    if (s.equals(".") || s.length() == 0) {// !alert: s.length==0 or u
						   // will have many ////.
		continue;
	    } else if (s.equals("..")) {
		if (!stack.isEmpty()) {
		    stack.pop();
		}
	    } else {
		stack.push(s);
	    }
	}

	StringBuilder sb = new StringBuilder();
	if (stack.isEmpty())
	    return "/";

	Deque<String> alt = new ArrayDeque<String>();
	while (!stack.isEmpty()) {
	    alt.push(stack.pop());
	}

	while (!alt.isEmpty()) {
	    sb.append("/" + alt.pop());
	}

	return sb.toString();
    }

}
