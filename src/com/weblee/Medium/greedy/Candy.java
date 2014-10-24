package com.weblee.Medium.greedy;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014��10��22������9:19:09
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class Candy {
    public int candy(int[] ratings) {
	int[] A = new int[ratings.length];
	A[0] = 1;

	// �����ھӴ�
	for (int i = 1; i < ratings.length; i++) {
	    if (ratings[i] > ratings[i - 1])
		A[i] = A[i - 1] + 1;
	    else
		A[i] = 1;
	}

	int ans = A[ratings.length - 1];
	// ���ھ�
	for (int i = ratings.length - 2; i >= 0; i--) {
	    if (ratings[i] > ratings[i + 1]) {
		// A[i] = Math.max(A[i], A[i + 1] + 1);
		
		if (A[i] <= A[i+1]) {
		    A[i] = A[i+1]+1;
		}
		
	    }
	    ans += A[i];
	}
	return ans;
    }
}
