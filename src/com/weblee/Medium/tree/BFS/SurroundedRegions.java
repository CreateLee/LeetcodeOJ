package com.weblee.Medium.tree.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月23日下午3:39:03
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class SurroundedRegions {
    public void solve(char[][] board) {
	if (board == null || board.length == 0 || board[0] == null || board[0].length == 0)
	    return;

	int m = board.length;
	int n = board[0].length;

	for (int i = 0; i < n; i++) {
	    bfs(board, 0, i);
	    bfs(board, m - 1, i);
	}

	for (int j = 1; j < m - 1; j++) {
	    bfs(board, j, 0);
	    bfs(board, j, n - 1);
	}

	for (int i = 0; i < m; i++)
	    for (int j = 0; j < n; j++) {
		if (board[i][j] == 'O')
		    board[i][j] = 'X';
		else if (board[i][j] == '+')
		    board[i][j] = 'O';
	    }
    }

    static void bfs(char[][] board, int i, int j) {
	Queue<State_t> queue = new LinkedList<State_t>();

	State_t start = new State_t(i, j);

	if (isValid(start, board)) {
	    board[i][j] = '+';

	    queue.offer(start);

	}
	
	while (!queue.isEmpty()) {
	    State_t cur = queue.poll();

	    List<State_t> list = stateExtend(cur, board);

	    for (State_t s : list)
		queue.offer(s);
	}
    }

    static boolean isValid(State_t state_t, char[][] board) {
	final int m = board.length;
	final int n = board[0].length;

	final int x = state_t.first;
	final int y = state_t.second;

	if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] != 'O')
	    return false;

	return true;
    }

    static List<State_t> stateExtend(State_t state_t, char[][] board) {
	List<State_t> result = new ArrayList<State_t>();
	final int x = state_t.first;
	final int y = state_t.second;
	// 上下左右
	State_t[] new_states = { new State_t(x - 1, y), new State_t(x + 1, y),
		new State_t(x, y - 1), new State_t(x, y + 1) };

	for (int k = 0; k < 4; ++k) {
	    if (isValid(new_states[k], board)) {
		// 既有标记功能又有去重功能
		board[new_states[k].first][new_states[k].second] = '+';

		result.add(new_states[k]);
	    }
	}
	return result;
    }
}

class State_t {
    public State_t(int first, int second) {
	// TODO Auto-generated constructor stub
	this.first = first;
	this.second = second;

    }

    int first;
    int second;
}
