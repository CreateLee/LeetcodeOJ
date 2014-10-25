package com.sinaWeibo.interview;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014��10��25������5:22:58
 * 
 *************        function description *************** m������Ϊn��ordered array����top
 *        k �� ���� *
 ****************************************************
 */

public class Top1000From2000Arrays {
    /*
     * ��m�������и�ȡһ����������¼ÿ��������Դ���飬����һ����k��Ԫ�صĴ���ѡ�
     * ��ʱ�Ѷ�������������ȡ���Ѷ�Ԫ�أ����ӶѶ�Ԫ�ص���Դ������ȡ��һ��������ѣ���ȡ���ֵ��һֱ��������k�μ��ɡ�
     * ʱ�临�Ӷȣ�k*log2(20)
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
