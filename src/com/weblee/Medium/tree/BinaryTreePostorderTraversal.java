package com.weblee.Medium.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014��10��22������9:39:44
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
	List<Integer> result = new ArrayList<Integer>();

	/* p�����ڷ��ʵĽ�㣬q���ոշ��ʹ��Ľ�� */
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
		// ���� too left
		p = stack.pop();
		/* �Һ��Ӳ����ڻ��ѱ����ʣ�����֮ */
		if (p.right == q) {
		    result.add(p.val);
		    q = p;/* ����շ��ʹ��Ľ�� */
		} else {
		    /* ��ǰ��㲻�ܷ��ʣ���ڶ��ν�ջ */
		    stack.push(p);
		    /* �ȴ��������� */
		    p = p.right;

		    break;
		}
	    }
	} while (!stack.isEmpty());

	return result;
    }
}
