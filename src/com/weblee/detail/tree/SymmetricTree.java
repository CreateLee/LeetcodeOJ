package com.weblee.detail.tree;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月19日下午2:33:01
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class SymmetricTree {
    public static boolean isSymmetric(TreeNode left, TreeNode right) {
	if (left == null) {
	    return right == null;
	} else {
	    if (right == null)
		return false;
	    else {
		// left, right 均不为空
		if (left.val != right.val) {
		    return false;
		}
		if (!isSymmetric(left.right, right.left)) {
		    return false;
		}
		if (!isSymmetric(left.left, right.right)) {
		    return false;
		}
		return true;
	    }
	}
    }

    public static boolean isSymmetric(TreeNode root) {
	if (null == root)
	    return true;

	return isSymmetric(root.left, root.right);
    }
}
