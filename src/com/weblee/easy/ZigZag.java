package com.weblee.easy;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月18日下午7:24:45
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class ZigZag {
    /*
     * 关键是要会如何计算各个字符的位置，这就需要数学知识了，根据特殊推导出公式来。 主要是3个公式：
     *  1 之字形行数为nRows,那么每次重复样出现前的间隔字符为zigSpan = nRows*2-2; 
     *  2 第一行和最尾一行都是存放一个字符的，所以存储的字符为间隔为zigSpan的字符 
     *  3 中间行是需要额外存储多一个字符的，存储的字符位置是：zigSpan + j - 2*i（其中i为行数，j为该行第几个字符了）
     */
    public String convert(String s, int nRows) {
	if (nRows <= 1 || s.length() < 3 || s.length() <= nRows)
	    return s;
	
	StringBuffer buffer = new StringBuffer();
	
	int zigSpan = nRows * 2 - 2;
	for (int i = 0; i < nRows; i++) {
	    for (int j = i; j < s.length(); j += zigSpan) {
		buffer.append(s.charAt(j));
		// 注意：推导出zigSpan+j-2i的数学公式，一点都不能错
		if (i != 0 && i != nRows - 1
			&& (zigSpan + j - 2 * i) < s.length()) {
		    buffer.append(s.charAt(zigSpan + j - 2 * i));
		}
	    }
	}
	return buffer.toString();
    }
}
