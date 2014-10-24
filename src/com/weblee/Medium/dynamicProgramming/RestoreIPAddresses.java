package com.weblee.Medium.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月21日下午9:38:04
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
	List<String> result = new ArrayList<String>();
	
	dfs(s, 0, "", result);

	return result;
    }

    public void dfs(String dataSegment, int level, String temp,
	    List<String> result) {
	if (level == 4) {
	    if (dataSegment.length() == 0)
		result.add(temp.substring(1));
	    return;
	}
	
	int possi = dataSegment.length() >= 3 ? 3 : dataSegment.length();
	for (int i = 1; i <= possi; i++) {
	    String newOne = dataSegment.substring(0, i);
	    if (isValidSegment(newOne)) {
		temp += "." + newOne;
		
		dfs(dataSegment.substring(i), level + 1, temp, result);
		
		temp = temp.substring(0, temp.lastIndexOf("."));
	    }
	}
    }

    public boolean isValidSegment(String s) {
	if (s.charAt(0) == '0')
	    return s.length() == 1;
	Integer result = Integer.parseInt(s);
	if (result > 255)
	    return false;
	return true;
    }
}
