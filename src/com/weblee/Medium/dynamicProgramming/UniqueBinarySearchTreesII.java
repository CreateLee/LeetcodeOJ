package com.weblee.Medium.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月23日上午9:34:03
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
	if (n == 0) 
	    return generate(1, 0);
	
	return generate(1, n);
    }

    List<TreeNode> generate(int start, int end) {
	List<TreeNode> subTree = new ArrayList<TreeNode>();

	if (start > end) {
	    subTree.add(null);

	    return subTree;
	}

	for (int k = start; k <= end; k++) {
	    List<TreeNode> leftSubs = generate(start, k - 1);
	    List<TreeNode> rightSubs = generate(k + 1, end);
	    for (TreeNode i : leftSubs) {
		for (TreeNode j : rightSubs) {
		    TreeNode node = new TreeNode(k);

		    node.left = i;
		    node.right = j;

		    subTree.add(node);
		}
	    }
	}
	
	return subTree;
    }
}
