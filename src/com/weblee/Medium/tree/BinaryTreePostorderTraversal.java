package com.weblee.Medium.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月22日下午9:39:44
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
	List<Integer> result = new ArrayList<Integer>();

	/* p，正在访问的结点，q，刚刚访问过的结点 */
	// TreeNode p = root, q = null;
	TreeNode p = root, q;

	Stack<TreeNode> stack = new Stack<TreeNode>();

	do {
	    while (p != null) {
		stack.push(p);

		p = p.left;
	    }

	    q = null;
	    
	    while (!stack.isEmpty()) {
		// 访问 too left
		p = stack.pop();
		/* 右孩子不存在或已被访问，访问之 */
		if (p.right == q) {
		    result.add(p.val);
		    q = p;/* 保存刚访问过的结点 */
		} else {
		    /* 当前结点不能访问，需第二次进栈 */
		    stack.push(p);
		    /* 先处理右子树 */
		    p = p.right;

		    break;
		}
	    }
	} while (!stack.isEmpty());

	return result;
    }
}
