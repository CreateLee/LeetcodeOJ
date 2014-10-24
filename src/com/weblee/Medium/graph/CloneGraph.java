package com.weblee.Medium.graph;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月23日上午9:40:25
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
	if (node == null)
	    return null;
	// key is original node，value is copied node
	Map<UndirectedGraphNode, UndirectedGraphNode> copied = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

	clone(node, copied);

	return copied.get(node);
    }

    // DFS
    private static UndirectedGraphNode clone(UndirectedGraphNode node,
	    Map<UndirectedGraphNode, UndirectedGraphNode> copied) {
	// a copy already exists
	if (copied.containsKey(node))
	    return copied.get(node);

	UndirectedGraphNode new_node = new UndirectedGraphNode(node.label);
	copied.put(node, new_node);

	for (UndirectedGraphNode nbr : node.neighbors)
	    new_node.neighbors.add(clone(nbr, copied));

	return new_node;
    }
    
    
}
