package com.weblee.detail.array;

import java.util.Arrays;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月19日上午10:07:51
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class RemoveDuplicates_from_SortedArray {
    public int removeDuplicates(int[] A) {
	if (A.length == 0) {
	    return 0;
	}
	
	int j=0;
	for (int i = 1; i<A.length; i++) {
	    if (A[i] != A[j]) {
		A[++j] = A[i];
	    }
	}
	
	//A = Arrays.copyOf(A, j+1);
	
	return j+1;
    }
}
