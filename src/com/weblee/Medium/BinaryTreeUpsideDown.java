package com.weblee.Medium;

import com.weblee.Medium.tree.TreeNode;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2015年3月7日下午1:12:04
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class BinaryTreeUpsideDown {
    public TreeNode UpsideDownBinaryTree(TreeNode root) {
	TreeNode p = root, parent = null, parentRight = null;
	while (p != null) {
	    TreeNode left = p.left;
	    p.left = parentRight;
	    parentRight = p.right;
	    p.right = parent;
	    parent = p;
	    p = left;
	}
	return parent;
    }

    public TreeNode UpsideDownBinaryTreeI(TreeNode root) {
	return dfsBottomUp(root, null);
    }

    private TreeNode dfsBottomUp(TreeNode p, TreeNode parent) {
	if (p == null)
	    return parent;
	TreeNode root = dfsBottomUp(p.left, p);
	p.left = (parent == null) ? parent : parent.right;
	p.right = parent;
	return root;
    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
