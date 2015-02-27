package com.weblee.easy.strings;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2015年2月17日下午1:34:59
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class CompareVersionNumbers {

    public int compareVersion(String version1, String version2) {
	int lev1 = 0, lev2 = 0;
	int id1 = 0, id2 = 0;

	while (id1 != version1.length() || id2 != version2.length()) {
	    lev1 = 0;
	    while (id1 < version1.length()) {
		if (version1.charAt(id1) == '.') {
		    ++id1;
		    break;
		}
		lev1 = lev1 * 10 + (version1.charAt(id1) - '0');
		++id1;
	    }

	    lev2 = 0;
	    while (id2 < version2.length()) {
		if (version2.charAt(id2) == '.') {
		    ++id2;
		    break;
		}
		lev2 = lev2 * 10 + (version2.charAt(id2) - '0');
		++id2;
	    }

	    if (lev1 > lev2) {
		return 1;
	    } else if (lev1 < lev2) {
		return -1;
	    }
	}
	
	return 0;// equal
    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
