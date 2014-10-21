package com.weblee.Medium.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月21日下午5:07:39
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
	List<Integer> result = new ArrayList<Integer>();

	TreeNode p = root;

	Stack<TreeNode> stack = new Stack<TreeNode>();

	while (!(stack.isEmpty() && p == null)) {
	    if (p != null) {
		stack.push(p);

		p = p.left;
	    } else {
		p = stack.pop();

		result.add(p.val);

		p = p.right;
	    }
	}

	return result;
    }
}
