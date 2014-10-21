package com.weblee.detail.strings;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月19日上午10:23:28
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class Count_and_Say {
    public static String countAndSay(int n) {
	String pre = 1+"";

	for (int i = 1; i < n; i++) {
	    pre = sayPre(pre);
	}

	return pre;
    }

    public static String sayPre(String string) {
	StringBuffer buffer = new StringBuffer();
	int count = 0;
	int index = string.length() - 1;
	char record = string.charAt(index);

	while (index != -1) {
	   char current = string.charAt(index);

	    if (current == record) {
		count++;
	    } else {
		buffer.insert(0, record);
		buffer.insert(0, count);

		record = current;
		count = 1;
	    }

	    index--;
	}
	buffer.insert(0, record);
	buffer.insert(0, count);

	return buffer.toString();
    }

    public static void main(String[] args) {
	System.out.println(countAndSay(10));
    }
}
