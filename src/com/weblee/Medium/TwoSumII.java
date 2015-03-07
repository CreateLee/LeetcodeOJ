package com.weblee.Medium;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2015年3月7日下午12:12:30
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
	// Assume input is already sorted.
	int i = 0, j = numbers.length - 1;
	while (i < j) {
	    int sum = numbers[i] + numbers[j];
	    if (sum < target) {
		i++;
	    } else if (sum > target) {
		j--;
	    } else {
		return new int[] { i + 1, j + 1 };
	    }
	}
	throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
