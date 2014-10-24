package com.weblee.Medium.array.sort;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014��10��23������2:30:30
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class SortColors {
    public void sortColors(int[] A) {
	int[] counts = { 0, 0, 0 }; // ��¼ÿ����ɫ���ֵĴ���
	
	for (int i = 0; i < A.length; i++)
	    counts[A[i]]++;

	for (int i = 0, index = 0; i < 3; i++)
	    for (int j = 0; j < counts[i]; j++)
		A[index++] = i;
    }
}
