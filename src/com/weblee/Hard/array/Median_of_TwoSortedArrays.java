package com.weblee.Hard.array;

import java.util.Arrays;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月21日上午8:51:53
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class Median_of_TwoSortedArrays {
    public double findMedianSortedArrays(int[] A, int[] B) {
	int total = A.length + B.length;

	if (total % 2 == 0) {
	    return (find_kth(A, B, total / 2) + find_kth(A, B, total / 2 + 1)) / 2.0;
	} else {
	    return find_kth(A, B, total / 2 + 1);
	}
    }

    public int find_kth(int[] A, int[] B, int k) {
	if (A.length > B.length) {
	    return find_kth(B, A, k);
	}

	if (A.length == 0) {
	    return B[k - 1];
	}

	if (k == 1) {
	    return Math.min(A[0], B[0]);
	}

	int ia = Math.min(k / 2, A.length), ib = k - ia;

	if (A[ia - 1] < B[ib - 1]) {
	    return find_kth(Arrays.copyOfRange(A, ia, A.length), B, k - ia);
	} else if (A[ia - 1] > B[ib - 1]) {
	    return find_kth(A, Arrays.copyOfRange(B, ib, B.length), k - ib);
	} else {
	    return A[ia - 1];
	}
    }
}
