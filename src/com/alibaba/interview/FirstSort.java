package com.alibaba.interview;

import java.util.Random;


/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014��10��25������2:58:39
 * 
 *************        function description ***************
 *һ�����������и�Ԫ��������ϵõ�������һ���� �����磬1,3,9,11,23,233,911 Ҫ�õ���9��911��3��233��23��11��1
 ****************************************************
 *
 *solution:
 *	��ȷ��������array������������֣��õ��len
 *	��new �ȳ�������doArray����Ŵ���֮���ԭ���飨�Ǳ�pos��ֵ��Ӧ��ϵ���䣩��how to ���������е���׷��ĩβ����c��Ϊ�ȳ���len����
 *	�۶�doArray ��������ͬ������ doArray��array�� �Ǳ��Ӧ������ swap(int[] doArray, int i, int j, int[] array) 
 *
 *	ʱ��O��nlog(n)��,�ռ�O(n)
 */

public class FirstSort {
    public static void sort(int[] array) {
	int max = 0;
	for (int i = 1; i < array.length; i++) {
	    if (max < array[i])
		max = array[i];
	}

	int len = (max + "").length();
	int[] doArray = new int[array.length];

	for (int i = 0; i < array.length; i++) {
	    doArray[i] = doNum(array[i], len);
	}

	quickSort(doArray, 0, doArray.length - 1, array);

    }

    private static Random rand = new Random();

    /**
     * ��������
     */
    private static void quickSort(int[] a, int p, int r, int[] num) {
	while (p < r) {
	    int q = randomPartition(a, p, r, num);
	    quickSort(a, p, q - 1, num);
	    p++;
	}
    }

    private static int partition(int[] a, int p, int r, int[] num) {
	int x = a[p];
	int i = p - 1;
	for (int j = p; j <= r; j++) {
	    if (a[j] >= x) {
		i++;
		swap(a, i, j, num);
	    }
	}
	swap(a, p, i, num);
	return i;
    }

    private static int randomPartition(int[] a, int p, int r, int[] num) {
	int i = rand.nextInt(r - p) + p;
	swap(a, p, i, num);
	return partition(a, p, r, num);
    }

    private static void swap(int[] a, int i, int j, int[] num) {
	int temp = a[i];
	a[i] = a[j];
	a[j] = temp;

	//
	temp = num[i];
	num[i] = num[j];
	num[j] = temp;
    }

    static int doNum(int num, int len) {
	StringBuffer buffer = new StringBuffer(num + "");
	char c = buffer.charAt(buffer.length() - 1);

	int bit = buffer.length();

	while (bit != len) {
	    buffer.append(c);

	    bit++;
	}

	return Integer.parseInt(buffer.toString());
    }

    // �����������Ϊsort�ǰ��մ�С����Ľ�������ģ�����ҪDisplay��������һ��
    public static void display(int[] L) {
	for (int i : L) {
	    System.out.print(i + "\t");
	}
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	int[] arr = { 1, 3, 9, 11, 23, 233, 911 };
	sort(arr);

	display(arr);
    }
}
