package com.weblee.Hard.string.dynamicProgramming;

import java.util.Arrays;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014��10��24������4:31:32
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
	if (s1.length() + s2.length() != s3.length())
	    return false;

	if (s1.length() < s2.length())
	    return isInterleave(s2, s1, s3);

	boolean[] f = new boolean[s2.length() + 1];
	Arrays.fill(f, true);

	for (int i = 1; i <= s2.length(); ++i)
	    f[i] = s2.charAt(i - 1) == s3.charAt(i - 1) && f[i - 1];

	for (int i = 1; i <= s1.length(); ++i) {
	    f[0] = (s1.charAt(i - 1) == s3.charAt(i - 1)) && f[0];

	    for (int j = 1; j <= s2.length(); ++j)
		f[j] = (s1.charAt(i - 1) == s3.charAt(i + j - 1) && f[j])
			|| (s2.charAt(j - 1) == s3.charAt(i + j - 1) && f[j - 1]);
	}

	return f[s2.length()];
    }
}
