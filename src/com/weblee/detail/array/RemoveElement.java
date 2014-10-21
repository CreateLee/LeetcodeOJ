package com.weblee.detail.array;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月18日下午4:52:38
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class RemoveElement {
    /*
     * Given an array and a value, remove all instances of that value in place
     * and return the new length. The order of elements can be changed. It
     * doesn't matter what you leave beyond the new length.
     * 
     * 去除A中的elem元素，两个哨兵i，j
     */
    public int removeElement(int[] A, int elem) {
	int i = 0, j = 0;
	while (j < A.length) {
	    if (A[j] == elem) {
		j++;
	    } else {
		if (i != j)
		    A[i] = A[j];
		i++;
		j++;
	    }
	}

	return i;
    }
}
