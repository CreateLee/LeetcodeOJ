package com.weblee.Hard.tree;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月24日下午3:40:57
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class BinaryTreeMaximumPathSum {
    public int maxPathSum(TreeNode root) {
	max_sum = Integer.MIN_VALUE;
	dfs(root);

	return max_sum;
    }

    int max_sum;

    int dfs(TreeNode root) {
	if (root == null)
	    return 0;
	int l = dfs(root.left);
	int r = dfs(root.right);
	int sum = root.val;
	if (l > 0)
	    sum += l;
	if (r > 0)
	    sum += r;
	max_sum = Math.max(max_sum, sum);
	
	return Math.max(r, l) > 0 ? Math.max(r, l) + root.val : root.val;
    }
}
