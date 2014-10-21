package com.weblee.detail;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014��10��19������3:43:55
 * 
 *************        function description ***************
 *
 ****************************************************
 */

/*
 * �ؿ��巨�ֳ��������������һ��Ӧ����������з�������ķ����� �ø÷�������еĻ���˼·�ǣ� ����Բ����Ĺ�ʽ�� s=��R2
 * ,��R=1ʱ��S=�С�����Բ�ķ����ǣ�x2+y2=1(X2ΪX��ƽ������˼),���1/4Բ���ΪX�ᡢy���������������Χ�Ĳ��֡�
 * �����1*1�ľ����о��ȵ���������㣬������1/4԰�еĵ�ĸ��ʾ���1/4Բ���������4��������Բ����� ���ڰ뾶Ϊ1���������ֵΪ�е�ֵ��
 */

public class Random_PI {
    //private static int N = 10000;

    public static double getPI(long N) {
	long k = 0;
	for (long i = 1; i <= N; ++i) {
	    double x = Math.random();
	    double y = Math.random();
	    // ��Բ��
	    if ((x * x + y * y) <= 1)
		++k;
	}
	
	return 4 * k / (double) N;
    }
    
    public static void main(String[] args) {
	System.out.println(getPI(10000));
    }

}
