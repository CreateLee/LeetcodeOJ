package com.weblee.Medium.tree;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014��10��20������4:44:48
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class FlattenBinaryTree_to_LinkedList {
    public void flatten(TreeNode root) {
	if (root == null)
	    return; // ��ֹ����

	flatten(root.left);
	flatten(root.right);

	if (null == root.left)
	    return;

	// �����ϲ��������������γɵ�������뵽root ��root->right ֮��
	TreeNode p = root.left;
	while (p.right != null)
	    p = p.right; // Ѱ�����������һ���ڵ�

	p.right = root.right;
	root.right = root.left;
	root.left = null;
    }
}
