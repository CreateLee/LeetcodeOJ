package com.weblee.Medium.string;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月22日上午9:40:07
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class Integer2Roman {
    public static String intToRoman(int num) {
	final int radix[] = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5,
		4, 1 };
	final String symbol[] = { "M", "CM", "D", "CD", "C", "XC", "L", "XL",
		"X", "IX", "V", "IV", "I" };

	StringBuffer roman = new StringBuffer();
	for (int i = 0; num > 0; ++i) {
	    int count = num / radix[i];
	    num %= radix[i];
	    for (; count > 0; --count) {
		roman.append(symbol[i]);
	    }
	}

	return roman.toString();
    }
    
    
    public static void main(String[] args) {
	System.out.println(intToRoman(8));
    }
}
