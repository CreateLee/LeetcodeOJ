package com.weblee.Medium.array.binarySearch;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月23日下午2:36:10
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class Search_a_2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
	if (matrix == null)
	    return false;
	int m = matrix.length;
	int n = matrix[0].length;
	int first = 0;
	int last = m * n;

	while (first < last) {
	    int mid = first + (last - first) / 2;
	    int value = matrix[mid / n][mid % n];

	    if (value == target)
		return true;
	    else if (value < target)
		first = mid + 1;
	    else
		last = mid;
	}

	return false;
    }
}
