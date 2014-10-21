package com.weblee.easy.array;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月20日下午12:48:09
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class RemoveDuplicates_from_SortedArrayII {
    public int removeDuplicates(int[] A) {
	if (A.length < 2) {
	    return A.length;
	}

	int j = 1;
	for (int i = 2; i < A.length; i++) {
	    if (!(A[i] == A[j] && A[i] == A[j-1])) {
		A[++j] = A[i];
	    }
	}

	// A = Arrays.copyOf(A, j+1);

	return j + 1;
    }
}
