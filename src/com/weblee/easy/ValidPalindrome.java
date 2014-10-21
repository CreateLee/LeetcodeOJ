package com.weblee.easy;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月18日下午8:35:57
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
	if (s.length() == 0 || s == null) {
	    return true;
	}
	int i = 0;
	int j = s.length() - 1;

	while (i < j) {
	    if (Character.isLetterOrDigit(s.charAt(i))
		    && Character.isLetterOrDigit(s.charAt(j))) {
		if (s.charAt(i) == s.charAt(j)
			|| ((Character.isLetter(s.charAt(i))
				&& Character.isLetter(s.charAt(j)) && Math
				.abs(s.charAt(i) - s.charAt(j)) == 32))) {
		    i++;
		    j--;
		} else {
		    return false;
		}
	    } else if (!Character.isLetterOrDigit(s.charAt(i))) {
		i++;
	    } else if (!Character.isLetterOrDigit(s.charAt(j))) {
		j--;
	    }
	}

	return true;
    }
    
    
    public static boolean isLetterOrDigit(char c) {
	return isDigit(c) || isLetter(c);
    }
    
    public static boolean isLetter(char c) {
	// 
	return isLetterOrDigit(c) || isUpperCaseLetter(c);
    }
    
    public static boolean isLowerCaseLetter(char c) {
	// 
	return c>='a' && c<='z';
    }
    
    public static boolean isUpperCaseLetter(char c) {
	// 
	return c>='A' && c<='Z';
    }
    
    public static boolean isDigit(char c) {
	return c>='0' && c<='9';
    }
}
