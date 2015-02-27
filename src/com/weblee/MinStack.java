package com.weblee;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年11月12日上午11:13:03
 * 
 *************        function description ***************
 *
 ****************************************************
 */

class MinStack {
    Node top = null;

    public void push(int x) {
	if (top == null) {
	    top = new Node(x);
	    top.min = x;
	} else {
	    Node temp = new Node(x);
	    temp.next = top;
	    top = temp;
	    top.min = Math.min(top.next.min, x);
	}
    }

    public void pop() {
	top = top.next;
	return;
    }

    public int top() {
	return top == null ? 0 : top.val;
    }

    public int getMin() {
	return top == null ? 0 : top.min;
    }
}

class Node {
    int val;
    int min;
    Node next;

    public Node(int val) {
	this.val = val;
    }
}
