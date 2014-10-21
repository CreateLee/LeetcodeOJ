package com.weblee.Medium.tree;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月20日下午10:40:33
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
	return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean helper(TreeNode root, int min, int max) {
	if (root == null)
	    return true;
	if (root.val <= min || root.val >= max)
	    return false;
	return helper(root.left, min, root.val)
		&& helper(root.right, root.val, max);
    }
}
