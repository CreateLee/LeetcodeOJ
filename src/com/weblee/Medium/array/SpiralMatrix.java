package com.weblee.Medium.array;

import java.util.ArrayList;
import java.util.List;

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

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
	List<Integer> result = new ArrayList<Integer>();

	if (matrix == null || matrix.length == 0)
	    return result;
	
	int beginX = 0, endX = matrix[0].length - 1;
	int beginY = 0, endY = matrix.length - 1;

	while (true) {
	    // From left to right
	    for (int j = beginX; j <= endX; ++j)
		result.add(matrix[beginY][j]);
	    if (++beginY > endY)
		break;
	    // From top to bottom
	    for (int i = beginY; i <= endY; ++i)
		result.add(matrix[i][endX]);
	    if (beginX > --endX)
		break;
	    // From right to left
	    for (int j = endX; j >= beginX; --j)
		result.add(matrix[endY][j]);
	    if (beginY > --endY)
		break;
	    // From bottom to top
	    for (int i = endY; i >= beginY; --i)
		result.add(matrix[i][beginX]);
	    if (++beginX > endX)
		break;
	}
	
	return result;
    }
}
