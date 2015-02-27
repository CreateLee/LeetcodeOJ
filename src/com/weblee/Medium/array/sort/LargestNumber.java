package com.weblee.Medium.array.sort;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2015��2��17������8:43:11
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class LargestNumber {

    /*
     * Ҫ��Ƚ������������ս���е��Ⱥ�λ�ã��β�ֱ�ӱȽ�һ�²�ͬ��ϵĽ����С��
     * �ٸ����ӣ�Ҫ�Ƚ�3��34���Ⱥ�λ�ã����ԱȽ�334��343�Ĵ�С����343��334������34Ӧ����ǰ��
     * ���������˱Ƚ��������ķ������Ϳ��Զ����������������Ȼ���ٰ��ź������ƴ����һ��ͺ��ˡ�
     */
    public String largestNumber(int[] num) {
	int n = num.length;
	if (n < 1)
	    return "";

	// ������ת��Ϊ�ַ�������
	String[] strs = new String[n];
	for (int i = 0; i < n; i++) {
	    strs[i] = String.valueOf(num[i]);
	}

	// ���������ڽ���е�λ������
	Arrays.sort(strs, new Cmp());

	// �������ַ���ƴ����һ��
	String ans = "";
	for (int i = n - 1; i >= 0; i--) {
	    ans = ans.concat(strs[i]);
	}

	// ȥ�����ֿ�ͷ��0��������[0, 0]
	int i = 0;
	while (i < n && ans.charAt(i) == '0') {
	    i++;
	}
	
	if (i == n)
	    return "0";

	return ans.substring(i);
    }
}

// �ȽϷ����ܼ򵥣����[a��ǰb�ں�]��ɵĽ������[b��ǰa�ں�]��ɵĽ������ôa>b��
class Cmp implements Comparator<String> {
    @Override
    public int compare(String a, String b) {
	String ab = a.concat(b);
	String ba = b.concat(a);
	
	return ab.compareTo(ba);
	
	//return (int) (Long.parseLong(ab) - Long.parseLong(ba));
	
	//return Integer.parseInt(ab) - Integer.parseInt(ba);
    }
}
