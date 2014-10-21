package com.weblee.easy;

import java.util.Arrays;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014��10��20������9:10:03
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
		// �����
		if (!check(board[i][j], used))
		    return false;

	    Arrays.fill(used, 0, used.length, false);

	    for (int j = 0; j < 9; ++j)
		// �����
		if (!check(board[j][i], used))
		    return false;
	}
	
	// ��ι���3*3�ĸ���
	for (int r = 0; r < 3; ++r)
	    // ���9 ���Ӹ���
	    for (int c = 0; c < 3; ++c) {
		Arrays.fill(used, 0, used.length, false);

		for (int i = r * 3; i < r * 3 + 3; ++i)
		    for (int j = c * 3; j < c * 3 + 3; ++j)
			/*
			 * �����㷨Algorithm
			 */
			if (!check(board[i][j], used))
			    return false;
	    }
	return true;
    }

    public static boolean check(char ch, boolean[] used) {
	// ��Ϊ�ո���return TRUE
	if (ch == '.')
	    return true;
	// ���ѳ��ֹ�����return FALSE
	if (used[ch - '1'])
	    return false;
	// ��һ�γ�����TRUE����return TRUE
	return used[ch - '1'] = true;
    }

}
