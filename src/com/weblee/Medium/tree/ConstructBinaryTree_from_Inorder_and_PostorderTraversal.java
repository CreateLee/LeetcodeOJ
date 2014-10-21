package com.weblee.Medium.tree;

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

public class ConstructBinaryTree_from_Inorder_and_PostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
	if (inorder.length < 1)
	    return null;

	TreeNode root = new TreeNode(postorder[postorder.length - 1]);

	int index = 0;
	for (index = 0; index < inorder.length; index++) {
	    if (inorder[index] == postorder[postorder.length - 1])
		break;
	}

	if (index > 0) {
	    int[] preP = new int[index];
	    int[] preI = new int[index];
	    for (int i = 0; i < index; i++) {
		preP[i] = postorder[i];
		preI[i] = inorder[i];
	    }
	    root.left = buildTree(preI, preP);
	}

	if (postorder.length - index - 1 > 0) {
	    int[] postP = new int[postorder.length - index - 1];
	    int[] postI = new int[inorder.length - index - 1];
	    for (int i = index + 1; i < postorder.length; i++) {
		postP[i - index - 1] = postorder[i - 1];
		postI[i - index - 1] = inorder[i];
	    }
	    root.right = buildTree(postI, postP);
	}

	return root;
    }
}
