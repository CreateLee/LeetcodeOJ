package com.weblee.Hard.tree;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月24日下午7:56:36
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

    // 中序遍历。p为最左边的错误节点，q为最右边的错误节点。
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
