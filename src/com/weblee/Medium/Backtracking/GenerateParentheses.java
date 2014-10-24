package com.weblee.Medium.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月23日上午9:39:55
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
	List<String> result = new ArrayList<String>();
	// exit
	if (n == 0) {
	    result.add("");
	    return result;
	}
	if (n == 1) {
	    result.add("()");
	    return result;
	}
	// *********
	
	for (int i = 0; i < n; ++i)
	    for (String inner : generateParenthesis (i))	//left
		for (String outer : generateParenthesis (n - 1 - i))	//right
		    result.add("(" + inner + ")" + outer);
	
	return result;
    }
}
