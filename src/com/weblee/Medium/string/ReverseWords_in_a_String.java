package com.weblee.Medium.string;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月20日下午9:32:56
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class ReverseWords_in_a_String {
    public String reverseWords(String s) {
	if (s == "")
	    return "";

	StringBuffer buffer = new StringBuffer();
	int start = 0, end;

	for (int i = s.length() - 1; i >= 0;) {
	    while (i >= 0 && s.charAt(i) == ' ')
		i--;

	    if (i != start)
		buffer.append(" ");

	    end = i;
	    while (i >= 0 && s.charAt(i) != ' ')
		i--;
	    start = i;
	    buffer.append(s.substring(start + 1, end + 1));
	}

	String str = buffer.toString();
	buffer = null;
	// 去除两端空格
	start = 0;
	end = str.length() - 1;
	while (start <= end && str.charAt(start) == ' ')
	    start++;
	while (start <= end && str.charAt(end) == ' ')
	    end--;

	return str.substring(start, end + 1);
    }
}
