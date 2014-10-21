package com.weblee.Medium.string;

import java.util.Arrays;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月20日下午12:38:55
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
	final int n = s.length();

	boolean[][] f = new boolean[n][n];
	for (boolean[] bools : f) {
	    Arrays.fill(bools, false);
	}
	
	int max_len = 1, start = 0; // 最长回文子串的长度，起点
	for (int i = 0; i < s.length(); i++) {
	    f[i][i] = true;
	    
	    for (int j = 0; j < i; j++) { // [j, i]
		f[j][i] = (s.charAt(j) == s.charAt(i) && (i - j < 2 || f[j + 1][i - 1]));
		
		if (f[j][i] && max_len < (i - j + 1)) {
		    max_len = i - j + 1;
		    start = j;
		}
	    }
	}
	
	//System.out.println(start);
	//System.out.println(max_len);
	return s.substring(start, start+max_len);
    }
    
    public static void main(String[] args) {
	String string = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
	
	System.out.println(string.length());
	System.out.println(longestPalindrome(string));
    }
}
