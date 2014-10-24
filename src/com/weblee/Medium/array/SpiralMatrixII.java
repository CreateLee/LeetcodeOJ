package com.weblee.Medium.array;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月23日下午7:00:29
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
	int[][] matrix = new int[n][n];

	int begin = 0, end = n - 1;
	int num = 1;

	while (begin < end) {
	    // from left to right
	    for (int j = begin; j < end; ++j)
		matrix[begin][j] = num++;
	    // from top to bottom
	    for (int i = begin; i < end; ++i)
		matrix[i][end] = num++;
	    // from right to left
	    for (int j = end; j > begin; --j)
		matrix[end][j] = num++;
	    // from bottom to top
	    for (int i = end; i > begin; --i)
		matrix[i][begin] = num++;

	    ++begin;
	    --end;
	}

	if (begin == end)
	    matrix[begin][begin] = num;

	return matrix;
    }
}
