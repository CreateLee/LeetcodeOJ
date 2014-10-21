package com.weblee.easy.array;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月19日下午1:52:15
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
	int ia = m - 1;
	int ib = n - 1;
	int icur = m + n - 1;
	
	while (ia >= 0 && ib >= 0) {
	    A[icur--] = (A[ia] >= B[ib]) ? A[ia--] : B[ib--];
	}
	
	while (ib >= 0) {
	    A[icur--] = B[ib--];
	}
    }
}
