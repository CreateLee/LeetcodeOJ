package com.weblee.Medium.tree;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月20日下午6:27:01
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class ConvertSortedArray_to_BinarySearchTree {
    public TreeNode sortedArrayToBST(int[] num) {
	return help(num, 0, num.length - 1);
    }

    public TreeNode help(int[] num, int b, int e) {
	if (num.length <= 0 || b > e)
	    return null;

	int i = (e + b) / 2;
	TreeNode root = new TreeNode(num[i]);

	root.left = help(num, b, i - 1);
	root.right = help(num, i + 1, e);

	return root;
    }
}
