package com.weblee.Medium.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月23日下午1:07:01
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class GrayCode {
    public List<Integer> grayCode(int n) {
	if (n == 0) {
	    List<Integer> result = new ArrayList<Integer>();
	    result.add(0);
	    return result;
	}

	List<Integer> tmp = grayCode(n - 1);
	int addNumber = 1 << (n - 1);
	List<Integer> result = new ArrayList<Integer>(tmp);
	
	for (int i = tmp.size() - 1; i >= 0; i--) {
	    result.add(addNumber + tmp.get(i));
	}
	
	return result;
    }
}
