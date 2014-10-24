package com.weblee.Medium.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月21日下午9:36:43
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class LetterCombinations_of_a_PhoneNumber {
    public List<String> letterCombinations(String digits) {
	String[] ss = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs",
		"tuv", "wxyz" };

	List<String> ret = new ArrayList<String>();
	rec(ret, digits.length(), ss, digits, new StringBuffer());
	return ret;
    }

    public static void rec(List<String> ret, int remain, String[] ss,
	    String digits, StringBuffer sb) {
	// 说明对digits遍历结束
	if (remain == 0) {
	    ret.add(sb.toString());
	    return;
	}

	String s = ss[digits.charAt(0) - '0']; // 得到digits[0]对应的string s
	// DFS
	for (int i = 0; i < s.length(); i++) {
	    sb = sb.append(s.charAt(i));
	    rec(ret, remain - 1, ss, digits.substring(1), sb);
	    sb.deleteCharAt(sb.length() - 1); // 恢复现场
	}
    }
}
