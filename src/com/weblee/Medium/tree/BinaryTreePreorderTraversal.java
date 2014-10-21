package com.weblee.Medium.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月20日下午12:39:59
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
	Stack<TreeNode> stack = new Stack<TreeNode>();
	List<Integer> result = new ArrayList<Integer>();

	if (root == null) {
	    return result;
	}

	stack.add(root);

	while (true) {
	    if (stack.isEmpty()) {
		break;
	    }

	    TreeNode tmpNode = stack.pop();

	    //
	    result.add(tmpNode.val);

	    if (tmpNode.right != null) {
		stack.add(tmpNode.right);
	    }
	    
	    if (tmpNode.left != null) {
		stack.add(tmpNode.left);
	    }
	}

	return result;
    }
}
