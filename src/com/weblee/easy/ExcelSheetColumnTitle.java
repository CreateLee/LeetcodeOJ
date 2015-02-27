package com.weblee.easy;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2015年2月17日下午12:54:50
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
	StringBuffer buffer = new StringBuffer();

	while (n >= 1) {
	    buffer.insert(0, (char) ('A' + (n - 1) % 26));

	    n = (n - 1) / 26;
	}

	return buffer.toString();
    }

    public static void main(String[] args) {
	System.out.println(new ExcelSheetColumnTitle().convertToTitle(1));
    }
}
