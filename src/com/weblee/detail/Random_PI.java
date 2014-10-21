package com.weblee.detail;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月19日下午3:43:55
 * 
 *************        function description ***************
 *
 ****************************************************
 */

/*
 * 特卡洛法又称随机抽样技术是一种应用随机数进行仿真试验的方法。 用该方法计算π的基本思路是： 根据圆面积的公式： s=πR2
 * ,当R=1时，S=π。由于圆的方程是：x2+y2=1(X2为X的平方的意思),因此1/4圆面积为X轴、y轴和上述方程所包围的部分。
 * 如果在1*1的矩形中均匀地落入随机点，则落入1/4园中的点的概率就是1/4圆的面积。其4倍，就是圆面积。 由于半径为1，该面积的值为π的值。
 */

public class Random_PI {
    //private static int N = 10000;

    public static double getPI(long N) {
	long k = 0;
	for (long i = 1; i <= N; ++i) {
	    double x = Math.random();
	    double y = Math.random();
	    // 在圆内
	    if ((x * x + y * y) <= 1)
		++k;
	}
	
	return 4 * k / (double) N;
    }
    
    public static void main(String[] args) {
	System.out.println(getPI(10000));
    }

}
