package com.weblee.Hard.array.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月24日下午12:32:56
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class Largest_Rectangle_in_Histogram {
    public int largestRectangleArea(int[] height) {
	Stack<Integer> stack = new Stack<Integer>();

	height = Arrays.copyOf(height, height.length+1);
	height[height.length-1] = 0;
	
	int result = 0;
	for (int i = 0; i < height.length;) {
	    if (stack.isEmpty() || height[i] > height[stack.peek()])
		stack.push(i++);
	    else {
		int tmp = stack.peek();
		stack.pop();
		result  = Math.max(result, height[tmp]
			* (stack.isEmpty() ? i : i - stack.peek() - 1));
	    }
	}

	return result;
    }
}
