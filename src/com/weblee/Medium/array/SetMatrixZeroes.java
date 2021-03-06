package com.weblee.Medium.array;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月23日下午2:41:29
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
	int m = matrix.length;
	int n = matrix[0].length;
	boolean row_has_zero = false; // 第一行是否存在0
	boolean col_has_zero = false; // 第一列是否存在0

	for (int i = 0; i < n; i++)
	    if (matrix[0][i] == 0) {
		row_has_zero = true;
		break;
	    }

	for (int i = 0; i < m; i++)
	    if (matrix[i][0] == 0) {
		col_has_zero = true;
		break;
	    }

	for (int i = 1; i < m; i++)
	    for (int j = 1; j < n; j++)
		if (matrix[i][j] == 0) {
		    matrix[0][j] = 0;
		    matrix[i][0] = 0;
		}

	for (int i = 1; i < m; i++)
	    for (int j = 1; j < n; j++)
		if (matrix[i][0] == 0 || matrix[0][j] == 0)
		    matrix[i][j] = 0;

	if (row_has_zero)
	    for (int i = 0; i < n; i++)
		matrix[0][i] = 0;

	if (col_has_zero)
	    for (int i = 0; i < m; i++)
		matrix[i][0] = 0;
    }
}
