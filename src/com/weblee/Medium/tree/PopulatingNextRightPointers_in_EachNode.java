package com.weblee.Medium.tree;

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

public class PopulatingNextRightPointers_in_EachNode {
    public void connect(TreeLinkNode root) {
	if (root == null) {
	    return ;
	}
	
	TreeLinkNode dummy = new TreeLinkNode(-1);
	
	for (TreeLinkNode curr = root, prev = dummy; curr!=null; curr=curr.next) {
	    if (curr.left != null) {
		prev.next = curr.left;
		prev = prev.next;
	    }
	    
	    if (curr.right != null) {
		prev.next = curr.right;
		prev = prev.next;
	    }
	}
	
	connect(dummy.next);
    }
    
}
