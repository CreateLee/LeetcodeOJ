package com.weblee.Medium.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月23日下午1:33:38
 * 
 *************        function description ***************
 *
 ****************************************************
 */
/* Definition for undirected graph. */
public class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
	label = x;
	neighbors = new ArrayList<UndirectedGraphNode>();
    }
}
