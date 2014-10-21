package com.weblee.detail.tree;


/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014��10��19������2:38:34

 *************  function description  ***************
 *
 ****************************************************
 */

public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
	if (root == null)
	    return false;
	if (root.left == null && root.right == null)
	    if (root.val == sum)
		return true;
	    else
		return false;
	
	// 
	if (hasPathSum(root.left, sum - root.val))
	    return true;
	
	return hasPathSum(root.right, sum - root.val);
    }
}
