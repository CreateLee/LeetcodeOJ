package com.weblee.Hard.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014��10��24������1:40:20
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class NQueensII {
    int count; // ��ĸ���
    // �������������ڼ�֦
    int[] columns; // ��ʾ�Ѿ����õĻʺ�ռ������Щ��
    int[] main_diag; // ռ������Щ���Խ���
    int[] anti_diag; // ռ������Щ���Խ���

    public int totalNQueens(int n) {
	count = 0;
	columns = new int[n];
	main_diag = new int[n * 2];
	anti_diag = new int[n * 2];
	Arrays.fill(columns, 0);
	Arrays.fill(main_diag, 0);
	Arrays.fill(anti_diag, 0);

	int[] C = new int[n]; // C[i] ��ʾ��i �лʺ����ڵ��б��
	Arrays.fill(C, 0);

	dfs(C, 0);

	return count;
    }

    void dfs(int[] C, int row) {
	int N = C.length;
	if (row == N) { // ��ֹ������Ҳ��������������ζ���ҵ���һ�����н�
	    ++count;

	    return;
	}

	for (int j = 0; j < N; ++j) { // ��չ״̬��һ��һ�е���
	    boolean ok = columns[j] == 0 && main_diag[row + j] == 0
		    && anti_diag[row - j + N] == 0;

	    if (!ok)
		continue; // ��֦������Ϸ��������ݹ�
	    // ִ����չ����
	    C[row] = j;

	    columns[j] = main_diag[row + j] = anti_diag[row - j + N] = 1;

	    dfs(C, row + 1);
	    // ��������
	    // C[row] = 0;
	    columns[j] = main_diag[row + j] = anti_diag[row - j + N] = 0;
	}
    }
}
