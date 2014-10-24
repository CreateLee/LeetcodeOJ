package com.weblee.Hard.tree;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014��10��24������7:56:36
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class RecoverBinarySearchTree {
    TreeNode p, q;
    TreeNode pre;

    public void recoverTree(TreeNode root) {
	if (root == null)
	    return;
	
	getWrong(root);

	int tmp = p.val;
	p.val = q.val;
	q.val = tmp;
    }

    // ���������pΪ����ߵĴ���ڵ㣬qΪ���ұߵĴ���ڵ㡣
    public void getWrong(TreeNode root) {
	if (root == null)
	    return;
	
	getWrong(root.left);

	if (pre != null && root.val < pre.val) {
	    if (p == null) {
		p = pre;
		q = root;
	    } else
		q = root;
	}
	pre = root;

	getWrong(root.right);
    }
}
