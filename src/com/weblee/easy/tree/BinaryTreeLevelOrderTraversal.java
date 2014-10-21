package com.weblee.easy.tree;

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

	ArrayList<Integer> tmpList = new ArrayList<Integer>();
	Queue<TreeNode> curQueue = new LinkedList<TreeNode>();
	
	TreeNode ptr = null;

	curQueue.offer(root);

	while (true) {
	    curQueue.clear();

	    while (curQueue.peek() != null) {
		ptr = curQueue.poll();
		tmpList.add(ptr.val);

		if (ptr.left != null)
		    curQueue.offer(ptr.left);
		if (ptr.right != null)
		    curQueue.offer(ptr.right);
	    }

	    if (tmpList.size() > 0 && curQueue.peek() == null) {
		result.add(tmpList);
		curQueue.poll();
		curQueue.offer(null);
	    } else
		break;
	}

	return result;
    }

}
