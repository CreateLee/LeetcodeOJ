package com.weblee.Hard.backtracking;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月24日下午4:24:38
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class SudokuSolver {
    public boolean solveSudoku(char[][] board) {
	for (int i = 0; i < 9; ++i)
	    for (int j = 0; j < 9; ++j) {
		if (board[i][j] == '.') {
		    for (int k = 0; k < 9; ++k) {
			board[i][j] = (char) ('1' + k);
			if (isValid(board, i, j) && solveSudoku(board))
			    return true;

			board[i][j] = '.';
		    }

		    return false;
		}
	    }

	return true;
    }

    // 检查(x, y) 是否合法
    boolean isValid(char[][] board, int x, int y) {
	int i, j;

	for (i = 0; i < 9; i++)
	    // 检查y 列
	    if (i != x && board[i][y] == board[x][y])
		return false;

	for (j = 0; j < 9; j++)
	    // 检查x 行
	    if (j != y && board[x][j] == board[x][y])
		return false;

	for (i = 3 * (x / 3); i < 3 * (x / 3 + 1); i++)
	    for (j = 3 * (y / 3); j < 3 * (y / 3 + 1); j++)
		if ((i != x || j != y) && board[i][j] == board[x][y])
		    return false;

	return true;
    }
}
