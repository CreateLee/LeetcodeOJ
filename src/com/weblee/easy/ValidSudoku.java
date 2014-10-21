package com.weblee.easy;

import java.util.Arrays;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月20日上午9:10:03
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
	boolean[] used = new boolean[9];
	for (int i = 0; i < 9; ++i) {
	    Arrays.fill(used, 0, used.length, false);

	    for (int j = 0; j < 9; ++j)
		// 检查行
		if (!check(board[i][j], used))
		    return false;

	    Arrays.fill(used, 0, used.length, false);

	    for (int j = 0; j < 9; ++j)
		// 检查列
		if (!check(board[j][i], used))
		    return false;
	}
	
	// 如何构建3*3的格子
	for (int r = 0; r < 3; ++r)
	    // 检查9 个子格子
	    for (int c = 0; c < 3; ++c) {
		Arrays.fill(used, 0, used.length, false);

		for (int i = r * 3; i < r * 3 + 3; ++i)
		    for (int j = c * 3; j < c * 3 + 3; ++j)
			/*
			 * 核心算法Algorithm
			 */
			if (!check(board[i][j], used))
			    return false;
	    }
	return true;
    }

    public static boolean check(char ch, boolean[] used) {
	// 若为空格，则return TRUE
	if (ch == '.')
	    return true;
	// 若已出现过，则return FALSE
	if (used[ch - '1'])
	    return false;
	// 第一次出现置TRUE，并return TRUE
	return used[ch - '1'] = true;
    }

}
