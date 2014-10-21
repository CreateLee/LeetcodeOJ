package com.weblee.easy.strings;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014��10��18������9:18:17
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
	String rs = null;
	if (strs == null)
	    return rs;

	if (strs.length == 0) {
	    return "";
	}

	int len = strs[0].length();

	for (int i = 1; i < strs.length; i++) {
	    int j = 0;
	    for (; j < len && j < strs[i].length()
		    && strs[i - 1].charAt(j) == strs[i].charAt(j); j++)
		;
	    // �Ż��Ƚϴ���
	    len = j;
	}
	
	return strs[0].substring(0, len);
    }
}
