package com.weblee.detail;

public class RotateRight {
    public static void swap(int array[], int i, int j) {
	final int temp = array[i];
	array[i] = array[j];
	array[j] = temp;
    }

    public static void reverse(int array[], int begin, int end) { // ����ҿ�����
	end--;
	while (begin < end)
	    swap(array, begin++, end--);
    }

    /*
     * �Ƚ�A ��Ԫ�ص��ã���1, 2, 3, 4, 5 ���5, 4, 3, 2, 1��Ȼ��ǰk λ���ã� ��3, 4, 5, 2, 1���ٽ���n-k
     * λ���ã���3, 4, 5, 1, 2����ɡ�
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

    int[] num;

    public int findMin(int start, int end) {
	if (num[start] <= num[end]) {
	    return num[start];
	}
	int middle = start + ((end - start) >> 1);
	if (num[middle] > num[end]) {
	    return findMin(middle + 1, end);
	}
	return findMin(start, middle);
    }

    public int findMin(int[] num) {
	this.num = num;
	return findMin(0, num.length - 1);
    }

}
