package com.weblee.Medium.tree;

import java.util.Stack;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月20日下午10:13:03
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class ConstructBinaryTree_from_Preorder_and_InorderTraversal {
    // iterative
    public TreeNode buildTree(int[] preorder, int[] inorder) {
	// Start typing your Java solution below
	// DO NOT write main() function
	if (preorder.length == 0 || preorder.length != inorder.length)
	    return null;
	Stack<TreeNode> stack = new Stack<TreeNode>();
	TreeNode root = new TreeNode(preorder[0]);
	stack.push(root);
	int preindex = 1;
	int inindex = 0;
	TreeNode current = root;
	while (preindex < preorder.length) {
	    boolean flag = false;
	    while (!stack.empty() && inorder[inindex] == stack.peek().val) {
		current = stack.pop();
		inindex++;
		flag = true;
	    }
	    TreeNode next = new TreeNode(preorder[preindex++]);
	    stack.push(next);
	    if (flag == false) {
		current.left = next;
	    } else {
		current.right = next;
	    }
	    current = next;
	}
	return root;
    }
}
