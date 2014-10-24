package com.weblee.Hard.array.binarySearch;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014��10��22������10:05:01
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class FindMinimum_in_RotatedSortedArrayII {
    public int findMin(int[] num) {
	int start = 0;
	int end = num.length - 1;

	while (num[start] >= num[end]) { // num[start]>=num[end]˵�����鲻����������ģ���Сֵ���ڵ�һ��λ��
	    if (end - start == 1) { // ѭ����������������ֻ������Ԫ�ص�
		return num[end];
	    }
	    int mid = (start + end) / 2;

	    if (num[start] == num[mid] && num[mid] == num[end]) {
		// ��������������������1����ֻ��һ��Ԫ��ʱ��
		// 2�����������д����ظ���Ԫ��ʱ����������ʹ�ö԰����
		int minValue = num[start];
		for (int i = start + 1; i <= end; i++) {
		    if (num[i] < minValue)
			minValue = num[i];
		}

		return minValue;
	    }

	    if (num[mid] >= num[start]) { // �������������˵����Сֵ������mid��end֮��
		start = mid;
	    } else { // ˵����С������start��mid֮��
		end = mid;
	    }
	}

	return num[start]; // �����˵�������start��end��������������Сֵ����startλ�õ�Ԫ��
    }
}
