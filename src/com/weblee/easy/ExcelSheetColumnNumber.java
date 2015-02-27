package com.weblee.easy;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2015年2月15日下午5:39:23
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class ExcelSheetColumnNumber {

    public int titleToNumber(String s) {
	/*
	 * thinks:
	 * 26 Hex == 16 Hex + 8 Hex + 2Hex
	 */
	int result = 0;
	
	for (char ch : s.toCharArray()) {
	    //int temp = (result  << 1) + (result << 3) + (result << 4);
	    result = result * 26 + (ch - '@');
	}
	
	return result;
    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	int a = 2;
	
	int result = 2;
	System.out.println((result  << 1) + (result << 3) + (result << 4));
	System.out.println(a << 2);
	System.out.println(a << 1);

    }

}
