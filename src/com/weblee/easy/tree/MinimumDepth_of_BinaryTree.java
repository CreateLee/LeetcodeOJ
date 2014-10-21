package com.weblee.easy.tree;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月19日下午2:37:47
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class MinimumDepth_of_BinaryTree {
    public int minDepth(TreeNode root) {
	if (root == null)
	    return 0;
	if (root.left == null && root.right == null)
	    return 1;

	if (root.left == null)
	    return 1 + minDepth(root.right);
	if (root.right == null)
	    return 1 + minDepth(root.left);

	return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    // Iterative O(logn) solution (BFS ):
    public int minDepthBFS(TreeNode root) {
/*
	if (root == null)
	    return 0;
	Queue<TreeNode> q = new ArrayBlockingQueue<TreeNode>();
	int depth = 1;
	q.push(TreeNode(root, depth));

	while (!q.empty()) {
	    TreeNode u = q.front();
	    q.pop();
	    if (u.root.left)
		q.push(Node(u.root.left, u.depth + 1));
	    if (u.root.right)
		q.push(Node(u.root.right, u.depth + 1));
	    if ((!u.root.right) && (!u.root.left))
		return u.depth;

	}
	*/
	return 0;
    }
}
