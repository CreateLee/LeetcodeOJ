package com.weblee.Medium.tree;

import java.util.Stack;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2015年2月17日下午9:41:52
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class BinarySearchTreeIterator {
    private Stack<TreeNode> stack = new Stack<TreeNode>();

    public BinarySearchTreeIterator(TreeNode root) {
	pushAll(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
	return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
	TreeNode tmpNode = stack.pop();
	pushAll(tmpNode.right);
	return tmpNode.val;
    }

    private void pushAll(TreeNode node) {
	for (; node != null; stack.push(node), node = node.left)
	    ;
    }
}
