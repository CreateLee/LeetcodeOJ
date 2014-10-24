package com.weblee.Hard.array;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月24日下午3:08:22
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
	bucketSort(A, A.length);
	
	for (int i = 0; i < A.length; ++i)
	    if (A[i] != (i + 1))
		return i + 1;
	
	return A.length + 1;
    }

    static void bucketSort(int[] A, int n) {
	for (int i = 0; i < n; i++) {
	    while (A[i] != i + 1) {
		if (A[i] <= 0 || A[i] > n || A[i] == A[A[i] - 1])
		    break;
		
		// swap(A[i], A[A[i] - 1])
		int tmp = A[i];
		A[i] = A[A[i] - 1];
		A[tmp - 1] = tmp;
	    }
	}
    }
}
