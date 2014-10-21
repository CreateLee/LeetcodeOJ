package com.weblee.Medium.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月20日下午10:14:50
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	List<List<Integer>> ret = new ArrayList<List<Integer>>();

	if (root == null) {
	    return ret;
	}

	Queue<TreeNode> queue = new LinkedList<TreeNode>();
	ArrayList<Integer> al = new ArrayList<Integer>();
	queue.add(root);

	int currentLevel = 1;
	int nextLevel = 0;
	boolean left = true;

	while (!queue.isEmpty()) {
	    TreeNode cur = queue.remove();
	    currentLevel--;
	    al.add(cur.val);
	    if (cur.left != null) {
		queue.add(cur.left);
		nextLevel++;
	    }
	    if (cur.right != null) {
		queue.add(cur.right);
		nextLevel++;
	    }

	    if (currentLevel == 0) {
		if (!left) { // 当自右往左时，要翻转al
		    Collections.reverse(al);
		}
		left = !left;
		ret.add(al);
		al = new ArrayList<Integer>();
		currentLevel = nextLevel;
		nextLevel = 0;
	    }
	}

	return ret;
    }
}
