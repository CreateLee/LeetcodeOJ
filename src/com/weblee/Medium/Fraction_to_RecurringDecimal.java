package com.weblee.Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2015��2��17������10:04:52
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
	    result.append("-"); // ���numerator<0��denominator<0����һ��Ϊ
	}
	// ת��Ϊ������INT_MINת��Ϊ���������������long long��long long int
	// n=abs(INT_MIN)�õ���n��Ȼ�Ǹ��ģ�����д���������ʽ��
	long n = numerator;
	long d = denominator;

	n = Math.abs(n);
	d = Math.abs(d);

	Long mode = n / d;
	String modeStr = String.valueOf(mode);
	result.append(modeStr);
	
	long r = n % d; // ����r
	if (r == 0) {
	    return result.toString();
	} else {
	    result.append(".");
	}
	
	// ���洦��С�����֣��ù�ϣ��
	Map map = new HashMap();
	int begin = 0;
	while (true) {
	    // �������r�Ƿ��ڹ�ϣ���У��ǵĻ���ʼѭ����
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
	    // ��������
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
