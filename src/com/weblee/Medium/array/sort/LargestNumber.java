package com.weblee.Medium.array.sort;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2015年2月17日下午8:43:11
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class LargestNumber {

    /*
     * 要想比较两个数在最终结果中的先后位置，何不直接比较一下不同组合的结果大小？
     * 举个例子：要比较3和34的先后位置，可以比较334和343的大小，而343比334大，所以34应当在前。
     * 这样，有了比较两个数的方法，就可以对整个数组进行排序。然后再把排好序的数拼接在一起就好了。
     */
    public String largestNumber(int[] num) {
	int n = num.length;
	if (n < 1)
	    return "";

	// 把数组转化为字符串数组
	String[] strs = new String[n];
	for (int i = 0; i < n; i++) {
	    strs[i] = String.valueOf(num[i]);
	}

	// 按照数字在结果中的位置排序
	Arrays.sort(strs, new Cmp());

	// 把所有字符串拼接在一起
	String ans = "";
	for (int i = n - 1; i >= 0; i--) {
	    ans = ans.concat(strs[i]);
	}

	// 去掉数字开头的0，如输入[0, 0]
	int i = 0;
	while (i < n && ans.charAt(i) == '0') {
	    i++;
	}
	
	if (i == n)
	    return "0";

	return ans.substring(i);
    }
}

// 比较方法很简单：如果[a在前b在后]组成的结果大于[b在前a在后]组成的结果，那么a>b。
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
