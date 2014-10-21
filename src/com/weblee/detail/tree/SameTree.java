package com.weblee.detail.tree;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月19日下午4:16:57
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
	// 同时到达叶子节点,终止
	if (p == null && q == null) {
	    return true;
	}
	
	// 不同时到达叶子节点,剪枝
	if (p == null || q == null) {
	    return false;
	}
	
	if (p.val == q.val) {
	    boolean left = isSameTree(p.left, q.left);
	    boolean right = isSameTree(p.right, q.right);

	    return left && right;
	} else {
	    return false;
	}
    }
}
