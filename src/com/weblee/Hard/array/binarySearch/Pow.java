package com.weblee.Hard.array.binarySearch;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月23日下午9:28:47
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class Pow {
    public double pow(double x, int n) {
	if (n < 0)
	    return 1.0 / power(x, -n);
	else
	    return power(x, n);
    }

    static double power(double x, int n) {
	if (n == 0)
	    return 1;

	double v = power(x, n / 2);

	if (n % 2 == 0)
	    return v * v;
	else
	    return v * v * x;
    }
}
