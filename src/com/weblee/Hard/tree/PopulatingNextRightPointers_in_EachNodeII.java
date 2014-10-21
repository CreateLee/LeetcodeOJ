package com.weblee.Hard.tree;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月20日下午6:25:07
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class PopulatingNextRightPointers_in_EachNodeII {
    public void connect(TreeLinkNode root) {
	connect(root, null);
    }
    
    private static void connect(TreeLinkNode root, TreeLinkNode sibling) {
	if (root == null) {
	    return ;
	} else {
	    root.next = sibling;
	}
	
	connect(root.left, root.right);
	
	if (sibling != null) {
	    connect(root.right, sibling.left);
	} else {
	    connect(root.right, null);
	}
    }
    
}
