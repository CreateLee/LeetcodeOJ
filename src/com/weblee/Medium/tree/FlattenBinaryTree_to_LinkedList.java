package com.weblee.Medium.tree;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月20日下午4:44:48
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class FlattenBinaryTree_to_LinkedList {
    public void flatten(TreeNode root) {
	if (root == null)
	    return; // 终止条件

	flatten(root.left);
	flatten(root.right);

	if (null == root.left)
	    return;

	// 三方合并，将左子树所形成的链表插入到root 和root->right 之间
	TreeNode p = root.left;
	while (p.right != null)
	    p = p.right; // 寻找左链表最后一个节点

	p.right = root.right;
	root.right = root.left;
	root.left = null;
    }
}
