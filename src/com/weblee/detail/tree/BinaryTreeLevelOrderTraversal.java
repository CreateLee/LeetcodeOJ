package com.weblee.detail.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月19日下午2:35:50
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
	List<List<Integer>> result = new ArrayList<List<Integer>>();

	if (root == null) {
	    return result;
	}

	// ArrayList<Integer> level = new ArrayList<Integer>();
	// 內存回收机制
	Queue<TreeNode> curQueue = new LinkedList<TreeNode>();
	Queue<TreeNode> nextQueue = new LinkedList<TreeNode>();

	curQueue.offer(root);

	while (!curQueue.isEmpty()) {
	    ArrayList<Integer> level = new ArrayList<Integer>();
	    while (!curQueue.isEmpty()) {
		TreeNode node = curQueue.poll();

		level.add(node.val);

		if (node.left != null)
		    nextQueue.offer(node.left);
		if (node.right != null)
		    nextQueue.offer(node.right);
	    }

	    result.add(level);

	    Queue<TreeNode> temList = curQueue;
	    curQueue = nextQueue;
	    nextQueue = temList;
	}

	return result;
    }

}
