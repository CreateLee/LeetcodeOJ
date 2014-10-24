package com.weblee.Hard.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月24日下午1:40:20
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class NQueens {
    // 这三个变量用于剪枝
    int[] columns; // 表示已经放置的皇后占据了哪些列
    int[] main_diag; // 占据了哪些主对角线
    int[] anti_diag; // 占据了哪些副对角线

    public List<String[]> solveNQueens(int n) {
	columns = new int[n];
	main_diag = new int[n * 2];
	anti_diag = new int[n * 2];
	Arrays.fill(columns, 0);
	Arrays.fill(main_diag, 0);
	Arrays.fill(anti_diag, 0);

	List<String[]> result = new ArrayList<String[]>();
	int[] C = new int[n]; // C[i] 表示第i 行皇后所在的列编号
	Arrays.fill(C, 0);

	dfs(C, result, 0);
	return result;
    }

    void dfs(int[] C, List<String[]> result, int row) {
	int N = C.length;
	if (row == N) { // 终止条件，也是收敛条件，意味着找到了一个可行解
	    List<String> solution = new ArrayList<String>();

	    for (int i = 0; i < N; ++i) {
		char[] string = new char[N];
		Arrays.fill(string, '.');

		for (int j = 0; j < N; ++j) {
		    if (j == C[i])
			string[j] = 'Q';
		}

		solution.add(new String(string));
	    }

	    result.add(list2Array(solution));

	    return;
	}

	for (int j = 0; j < N; ++j) { // 扩展状态，一列一列的试
	    boolean ok = columns[j] == 0 && main_diag[row + j] == 0
		    && anti_diag[row - j + N] == 0;

	    if (!ok)
		continue; // 剪枝：如果合法，继续递归
	    // 执行扩展动作
	    C[row] = j;

	    columns[j] = main_diag[row + j] = anti_diag[row - j + N] = 1;

	    dfs(C, result, row + 1);

	    // 撤销动作

	    // C[row] = 0;
	    columns[j] = main_diag[row + j] = anti_diag[row - j + N] = 0;
	}
    }

    public static String[] list2Array(List<String> list) {
	String[] result = new String[list.size()];

	for (int i = 0; i < list.size(); i++) {
	    result[i] = list.get(i);
	}

	return result;
    }
}
