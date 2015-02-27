package com.weblee.Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2015年2月17日下午10:04:52
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class Fraction_to_RecurringDecimal {
    public String find(int numerator, int denominator) {
	if (numerator == 0)
	    return "0";
	
	StringBuffer result = new StringBuffer();
	if ((numerator < 0) ^ (denominator < 0)) {
	    result.append("-"); // 异或，numerator<0和denominator<0仅有一个为
	}
	// 转化为正数，INT_MIN转化为正数会溢出，故用long long。long long int
	// n=abs(INT_MIN)得到的n仍然是负的，所以写成下面的形式。
	long n = numerator;
	long d = denominator;

	n = Math.abs(n);
	d = Math.abs(d);

	Long mode = n / d;
	String modeStr = String.valueOf(mode);
	result.append(modeStr);
	
	long r = n % d; // 余数r
	if (r == 0) {
	    return result.toString();
	} else {
	    result.append(".");
	}
	
	// 下面处理小数部分，用哈希表
	Map map = new HashMap();
	int begin = 0;
	while (true) {
	    // 检查余数r是否在哈希表中，是的话则开始循环了
	    if (map.containsKey(r)) {
		int last = result.length();
		int beginIn = (int) map.get(r);
		String head = result.substring(0, beginIn);
		String tail = result.substring(beginIn, last);
		result = new StringBuffer();
		result.append(head);
		result.append("(");
		result.append(tail);
		result.append(")");
		break;
	    }
	    
	    begin = result.length();
	    // 正常运算
	    map.put(r, begin);

	    r *= 10;
	    long sub = (r / d);
	    result.append(String.valueOf(sub));

	    r = r % d;
	    if (r == (long) 0) {
		break;
	    }

	}

	return result.toString();
    }
}
