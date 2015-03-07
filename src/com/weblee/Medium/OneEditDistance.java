package com.weblee.Medium;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2015年3月7日下午12:40:17
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
	int m = s.length(), n = t.length();
	if (m > n)
	    return isOneEditDistance(t, s);
	
	if (n - m > 1)
	    return false;
	
	int i = 0, shift = n - m;
	while (i < m && s.charAt(i) == t.charAt(i))
	    i++;
	
	if (i == m)
	    return shift > 0;
	if (shift == 0)
	    i++;
	
	while (i < m && s.charAt(i) == t.charAt(i + shift))
	    i++;
	
	return i == m;
    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
