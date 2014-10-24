package com.weblee.Medium.array;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月23日下午8:44:33
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class NextPermutation {
    public static void nextPermutation(int[] num) {
	if (num == null || num.length <= 1) {
	    return;
	}

	int partitionIdx = num.length - 2;

	while (partitionIdx >= 0 && num[partitionIdx] >= num[partitionIdx + 1]) {
	    partitionIdx--;
	}

	int tmp;
	if (partitionIdx == -1) {
	    for (int i = 0, j = num.length - 1; i < j; i++, j--) {
		tmp = num[i];
		num[i] = num[j];
		num[j] = tmp;
	    }
	} else {
	    int changeNumIdx = -1;
	    for (int i = num.length - 1; i > partitionIdx; i--) {
		if (num[i] > num[partitionIdx]) {
		    changeNumIdx = i;

		    break;
		}
	    }

	    tmp = num[partitionIdx];
	    num[partitionIdx] = num[changeNumIdx];
	    num[changeNumIdx] = tmp;

	    for (int i = partitionIdx + 1, j = num.length - 1; i < j; i++, j--) {
		tmp = num[i];
		num[i] = num[j];
		num[j] = tmp;
	    }

	}

    }
}
