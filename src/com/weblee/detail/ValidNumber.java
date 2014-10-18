package com.weblee.detail;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月18日下午4:59:50
 * 
 *************        function description ***************
 *
 *        Validate if a given string is numeric.
 * 
 ****************************************************
 */

public class ValidNumber {
    public boolean isNumber(String s, String regex) {
	if (s.trim().isEmpty()) {
	    return false;
	}
	// String regex = "[-+]?(\\d+\\.?|\\.\\d+)\\d*(e[-+]?\\d+)?";
	if (s.trim().matches(regex)) {
	    return true;
	} else {
	    return false;
	}
    }

    
}
