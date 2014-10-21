package com.weblee.Medium.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月20日上午10:41:07
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
	List<List<Integer>> result = new ArrayList<List<Integer>>();
	List<Integer> cur = new ArrayList<Integer>();

	pathSum(root, sum, cur, result);
	
	return result;
    }

    static void pathSum(TreeNode root, int gap, List<Integer> curList,
	    List<List<Integer>> result) {
	List<Integer> cur = new ArrayList<Integer>(curList);
	
	if (root == null)
	    return;
	
	cur.add(root.val);

	if (root.left == null && root.right == null) { // leaf
	    if (gap == root.val)
		result.add(cur);
	}
	
	pathSum(root.left, gap - root.val, cur, result);
	pathSum(root.right, gap - root.val, cur, result);
	
    }
}
