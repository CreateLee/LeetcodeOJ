package com.sinaWeibo.interview;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月25日下午5:22:58
 * 
 *************        function description *************** m个长度为n的ordered array，求top
 *        k 个 数字 *
 ****************************************************
 */

public class Top1000From2000Arrays {
    /*
     * 从m个数组中各取一个数，并记录每个数的来源数组，建立一个含k个元素的大根堆。
     * 此时堆顶就是最大的数，取出堆顶元素，并从堆顶元素的来源数组中取下一个数加入堆，再取最大值，一直这样进行k次即可。
     * 时间复杂度：k*log2(20)
     */
    public static int[] maxK(final int k, int[][] arrays) {
	int count = 0;
	Node max = null;
	int[] result = new int[k];

	TreeSet<Node> set = new TreeSet<Node>(new NodeComparator());

	set.add(new Node(arrays[0][0], 0, 0));

	for (int i = 0; i < arrays.length; i++) {
	    if (set.first().value < arrays[i][arrays[i].length - 1]) {
		set.add(new Node(arrays[i][arrays[i].length - 1], i,
			arrays[i].length - 1));

		if (set.size() > k) {
		    
		    
		    max = set.first();
		    result[count++] = max.value;
		    set.remove(set.first());
		    set.add(new Node(arrays[max.originX][max.originY - 1], max.originX,
			    max.originY - 1));
		    
		 // testing
		    Iterator<Node> iter = set.iterator();
		    while (iter.hasNext()) {
			System.out.print(iter.next().value + "\t");
		    }
		    System.out.println();
		    // testing
		}
	    }
	}

	while (true) {
	    max = set.first();
	    result[count++] = max.value;

	    if (count == k) {
		break;
	    }
	    
	    set.remove(set.first());
	    set.add(new Node(arrays[max.originX][max.originY - 1], max.originX,
		    max.originY - 1));

	    // testing
	    Iterator<Node> iter = set.iterator();
	    while (iter.hasNext()) {
		System.out.print(iter.next().value + "\t");
	    }
	    System.out.println();
	    // testing
	}

	return result;
    }

    public static void main(String[] args) {
	int[][] arrays = { { 4, 5, 6, 12 }, { 1, 2, 3, 45 }, { 3, 4, 5, 89 },
		{ 101, 102, 103, 189 },{ 11, 12, 13, 289 } };

	int[] result = maxK(4, arrays);

	for (int num : result) {
	    System.out.print(num + "\t");
	}
    }

}

class Node {
    int value;
    int originX;
    int originY;

    public Node(int value, int originX, int originY) {
	this.value = value;
	this.originX = originX;
	this.originY = originY;
    }
}

class NodeComparator implements Comparator<Node> {

    @Override
    public int compare(Node o1, Node o2) {
	// TODO Auto-generated method stub
	return -(o1.value - o2.value);
    }

}
