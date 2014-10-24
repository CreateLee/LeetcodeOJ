package com.weblee.Medium.array;

import java.util.Arrays;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014��10��23������9:26:58
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class RotateImage {
    public void rotate(int[][] matrix) {
	final int n = matrix.length;

	for (int i = 0; i < n / 2; ++i)
	    // ����ˮƽ���߷�ת
	    for (int j = 0; j < n; ++j) {
		// swap(matrix[i][j], matrix[n - 1 - i][j]);
		int temp = matrix[i][j];
		matrix[i][j] = matrix[n - 1 - i][j];
		matrix[n - 1 - i][j] = temp;
	    }

	for (int i = 0; i < n; ++i)
	    // �������Խ��߷�ת
	    for (int j = i + 1; j < n; ++j) {
		//swap(matrix[i][j], matrix[j][i]);
		int temp = matrix[i][j];
		matrix[i][j] = matrix[j][i];
		matrix[j][i] = temp;
	    }
    }

}
