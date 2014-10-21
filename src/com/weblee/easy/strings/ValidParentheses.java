package com.weblee.easy.strings;

import java.util.Stack;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月18日下午9:39:19
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class ValidParentheses {
    public boolean isValid(String s) {
	Stack<Character> lefts = new Stack<Character>();

	for (int i = 0; i < s.length(); ++i) {
	    char c = s.charAt(i);
	    if (c == '(' || c == '[' || c == '{') {
		lefts.push(c);
	    } else {
		if (lefts.size() == 0)
		    return false;
		char top = lefts.peek();
		if (c == ')') {
		    if (top != '(')
			return false;
		} else if (c == ']') {
		    if (top != '[')
			return false;
		} else if (c == '}') {
		    if (top != '{')
			return false;
		}
		lefts.pop();
	    }
	}
	return lefts.size() == 0;
    }
}
