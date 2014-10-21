package com.weblee.easy;

public class ReverseInteger {
    public static int reverse(int x) {
	int result = 0;

	for (; x != 0; x /= 10) {
	    result = result * 10 + x % 10;
	}

	return result;
    }

    public static void reverse(int[] input) {
	int end = input.length;
	end--;
	int begin = 0;
	while (begin < end) {
	    swap(input, begin++, end--);
	}
    }

    static void swap(int array[], int i, int j) {
	final int temp = array[i];
	array[i] = array[j];
	array[j] = temp;
    }
}
