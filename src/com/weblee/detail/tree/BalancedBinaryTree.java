package com.weblee.detail.tree;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014��10��19������2:37:12
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
	return balancedHeight(root) >= 0;
    }

    /**
     * Returns the height of `root` if `root` is a balanced tree, otherwise,
     * returns `-1`.
     */
    public static int balancedHeight(TreeNode root) {
	if (root == null)
	    return 0; // ��ֹ����

	int left = balancedHeight(root.left);
	int right = balancedHeight(root.right);
	if (left < 0 || right < 0 || Math.abs(left - right) > 1)
	    return -1; // ��֦
	return Math.max(left, right) + 1; // �����ϲ�
    }
}
