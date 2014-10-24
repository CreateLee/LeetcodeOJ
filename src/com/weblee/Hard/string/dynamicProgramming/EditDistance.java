package com.weblee.Hard.string.dynamicProgramming;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月24日下午12:41:25
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class EditDistance {
    public int minDistance(String word1, String word2) {
	if (word1.length() < word2.length()) {
	    return minDistance(word2, word1);
	}

	int[] f = new int[word2.length() + 1];
	int upperLeft = 0; // 额外用一个变量记录f[i-1][j-1]

	for (int i = 0; i <= word2.length(); ++i)
	    f[i] = i;

	for (int i = 1; i <= word1.length(); ++i) {
	    upperLeft = f[0];
	    f[0] = i;
	    for (int j = 1; j <= word2.length(); ++j) {
		int upper = f[j];
		if (word1.charAt(i - 1) == word2.charAt(j - 1))
		    f[j] = upperLeft;
		else
		    f[j] = 1 + Math.min(upperLeft, Math.min(f[j], f[j - 1]));
		
		upperLeft = upper;
	    }
	}

	return f[word2.length()];
    }
}
