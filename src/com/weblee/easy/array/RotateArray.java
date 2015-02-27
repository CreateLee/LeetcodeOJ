package com.weblee.easy.array;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2015年2月27日上午11:38:26
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class RotateArray {
    public void rotate(int[] nums, int k) {
	reverse(nums, 0, nums.length);

	// when k is greater then nums.length , so k % nums.length
	reverse(nums, 0, k % nums.length);
	reverse(nums, k % nums.length, nums.length);
    }

    public static void reverse(int[] nums, int start, int end) {
	while (start < --end) {
	    int temp = nums[start];
	    nums[start] = nums[end];
	    nums[end] = temp;

	    start++;
	}
    }

    public static void main(String[] args) {
	int nums[] = { 4, 5, 6, 7, 8 };

	new RotateArray().rotate(nums, 4);

	for (int i = 0; i < nums.length; i++) {
	    System.out.print(nums[i] + "\t");
	}
    }
}
