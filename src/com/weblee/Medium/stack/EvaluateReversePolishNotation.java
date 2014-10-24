package com.weblee.Medium.stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月23日下午2:51:20
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class EvaluateReversePolishNotation {
    private Set<String> set = new HashSet<String>();
    { // 初始化块
	set.add("+");
	set.add("-");
	set.add("*");
	set.add("/");
    }

    public int evalRPN(String[] tokens) {
	Stack<Integer> stack = new Stack<Integer>();
	int num1, num2 = 0;
	for (int i = 0; i < tokens.length; i++) {
	    if (!set.contains(tokens[i])) {
		stack.push(Integer.parseInt(tokens[i]));
	    } else {
		num2 = stack.pop();
		num1 = stack.pop();
		stack.push(calculate(tokens[i].charAt(0), num1, num2));
	    }
	}
	return stack.pop();
    }

    private int calculate(char operator, int num1, int num2) {
	switch (operator) {
	case '+':
	    return num1 + num2;
	case '-':
	    return num1 - num2;
	case '*':
	    return num1 * num2;
	case '/':
	    return num1 / num2;
	default:
	    return 0;
	}
    }
}
