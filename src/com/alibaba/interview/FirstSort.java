package com.alibaba.interview;

import java.util.Random;


/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月25日下午2:58:39
 * 
 *************        function description ***************
 *一个整型数组中各元素排列组合得到的最大的一个数 ，比如，1,3,9,11,23,233,911 要得到：9，911，3，233，23，11，1
 ****************************************************
 *
 *solution:
 *	①确定该数组array中数字最长的数字，得到最长len
 *	②new 等长的数组doArray，存放处理之后的原数组（角标pos与值对应关系不变），how to 处理，将所有的数追加末尾数字c变为等长（len），
 *	③对doArray 快速排序，同步交换 doArray、array的 角标对应的数字 swap(int[] doArray, int i, int j, int[] array) 
 *
 *	时间O（nlog(n)）,空间O(n)
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
     * 快速排序法
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

    // 输出方法，因为sort是按照从小到大的进行排序的，所以要Display方法处理一下
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
