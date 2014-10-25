package com.Amazon.interview;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月25日下午5:14:33
 * 
 *************        function description ***************
 * 
 *        Question:
 * 
 *        Given an array with positive integers and another integer for
 *        example{7 2 4} 9, you are required to generate an equation, by
 *        inserting operator add ("+") and minus ("-") among the array . The
 *        left side of equation are consist of the array and the right side of
 *        equation is the integer. here the result is 7-2+4=9
 * 
 * 
 * 
 *        Rules:
 * 
 *        Don't include any space in the generated equation. In case there is no
 *        way to create the equation, please output "Invalid". For example {1 1}
 *        10, output is "Invalid"
 * 
 *        There is no operator "+" or "-" in front of the first number: Don't
 *        change the order of the numbers. For example: {7 2 4} 9. 7-2+4=9 is
 *        correct answer, 4-2+7=9 is wrong answer. There could be multiple
 *        input, meaning your function could be called multiple times. Do
 *        remember print a new line after the call.
 * 
 *        The length of the integer array is from 1 to 15( include 1 and 15). If
 *        the length is 1, for example the input {7} 7, the output is 7=7
 * 
 *        Sample Input and Output:
 * 
 *        Input:
 * 
 *        1 2 3 4 10
 * 
 *        1 2 3 4 5
 * 
 *        Output:
 * 
 *        1+2+3+4=10
 * 
 *        Invalid
 * 
 *
 * 
 ****************************************************
 */

public class GenerateEquation {
    public static void createEqualAndPrint(int[] a, int n, int target) {
	if (a == null || a.length == 0 || a.length != n || n == 0) {
	    System.out.println("Invalid");

	    return;
	}

	if (n < 1 || n > 15) {
	    System.out.println("Invalid");
	    return;
	}

	int i = n - 1;
	int v = 1;
	while (i > 1) {
	    v = (v << 1) + 1;
	    i--;
	}

	int sum = 0;
	String s = null;
	while (v > 0) {
	    sum = a[0];
	    s = a[0] + "";
	    for (int j = n - 1; j > 0; j--) {
		int c = v >> (j - 1);
		if ((c & 1) == 1) {
		    sum += a[n - j];
		    s += "+" + a[n - j];
		} else {
		    sum -= a[n - j];
		    s += "-" + a[n - j];
		}
	    }
	    if (sum == target) {
		System.out.println(s + "=" + target);
		return;
	    } else {
		v--;
	    }
	}

	System.out.println("Invalid.");
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	int[] a = { 1, 2, 3, 4 };

	createEqualAndPrint(a, 4, 2);
    }

}
