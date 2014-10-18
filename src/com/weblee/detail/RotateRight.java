package com.weblee.detail;

import java.util.Arrays;

public class RotateRight {
	public static void swap(int array[], int i, int j) {
		final int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void reverse(int array[], int begin, int end) { // 左闭右开区间
		end--;
		while (begin < end)
			swap(array, begin++, end--);
	}

	/*
	 * 先将A 的元素倒置，即1, 2, 3, 4, 5 变成5, 4, 3, 2, 1，然后将前k 位倒置， 即3, 4, 5, 2, 1，再将后n-k
	 * 位倒置，即3, 4, 5, 1, 2，完成。
	 */
	public void ror3(int array[], int n, int k) {
		k %= n;

		if (k == 0)
			return;
		reverse(array, 0, n);
		reverse(array, 0, k);
		reverse(array, k, n - k);
	}

	public static int gcd(int a, int b) {
		assert (a >= b);
		if (b == 0) {
			return a;
		}
		while (b > 0) {
			int tmp = a % b;
			a = b;
			b = tmp;
		}
		return a;
	}

	/*
	 * 
	 */
	public void ror4(int[] array, int n, int k) {
		int i;
		final int g = gcd(n, k);
		k %= n;
		if (k == 0)
			return;
		for (i = 0; i < g; ++i) {
			int j = i;

			int cur = array[j], tmp;

			do {
				tmp = array[(j + k) % n];
				array[(j + k) % n] = cur;
				cur = tmp;
				j = (j + k) % n;
			} while (j != i);
		}
	}
	
	public static int findMinnum(int[] num) {
		int minnum = num[0];
		int flag = 0;
		StringBuffer buffer = new StringBuffer();
		for (int i=1; i<num.length; i++) {
			if (num[i] < minnum) {
				flag = i;
			}
		}
		
		for (int i = flag; i < flag + num.length; i++) {
			buffer.append(num[i%num.length]);
			
		}
		
		return Integer.parseInt(buffer.toString());
	}
	
	public static void main(String[] args) {
		int[] num = {266,267,268,269,271,278,282,292,293,298,6};
		//int[] num = {4,1,5,6};
		//System.out.println(Arrays.toString(num).replaceAll("[^\\d]", ""));
		System.out.println(findMinnum(num));
	}
	
	public static int ints2int(int[] nums) {
		StringBuffer buffer = new StringBuffer();
		
		for (int num : nums) {
			buffer.append(num);
			System.out.print(num + "\t");
		}
		
		return Integer.parseInt(buffer.toString());
	}
}
