package com.weblee.easy.tree;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月19日下午2:36:33
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class MaximumDepth_of_BinaryTree {
    public int maxDepth(TreeNode root) {
	if (root == null)
	    return 0;
	if (root.left == null && root.right == null)
	    return 1;

	if (root.left == null)
	    return 1 + maxDepth(root.right);
	if (root.right == null)
	    return 1 + maxDepth(root.left);

	return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
