package com.weblee.Medium.tree;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月23日下午3:33:27
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class SumRoot_to_LeafNumbers {
    public int sumNumbers(TreeNode root) {
	return dfs(root, 0);
    }

    static int dfs(TreeNode root, int sum) {
	if (root == null)
	    return 0;
	if (root.left == null && root.right == null)
	    return sum * 10 + root.val;
	return dfs(root.left, sum * 10 + root.val)
		+ dfs(root.right, sum * 10 + root.val);
    }
}
