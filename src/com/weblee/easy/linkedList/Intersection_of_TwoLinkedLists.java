package com.weblee.easy.linkedList;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2015年2月17日下午7:04:43
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class Intersection_of_TwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	int lenA = getListLen(headA);
	int lenB = getListLen(headB);
	int diff = Math.abs(lenA - lenB);
	ListNode temp = null;
	ListNode flag = null;

	if (lenA > lenB) {
	    temp = headA;
	    flag = headB;

	} else {
	    temp = headB;
	    flag = headA;
	}

	while (diff-- != 0) {
	    temp = temp.next;
	}

	while (temp != flag) {
	    temp = temp.next;
	    flag = flag.next;
	}

	return flag;
    }

    public int getListLen(ListNode node) {
	int result = 0;

	ListNode temp = node;

	while (temp != null) {
	    result++;

	    temp = temp.next;
	}

	return result;
    }
}
