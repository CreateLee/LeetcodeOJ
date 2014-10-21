package com.weblee.easy.tree;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014��10��19������4:16:57
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
	// ͬʱ����Ҷ�ӽڵ�,��ֹ
	if (p == null && q == null) {
	    return true;
	}
	
	// ��ͬʱ����Ҷ�ӽڵ�,��֦
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
