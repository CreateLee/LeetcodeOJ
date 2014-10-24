package com.weblee.Hard.LinkedList;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月24日下午12:40:13
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class ReverseNodes_in_k_Group {
    public ListNode reverseKGroup(ListNode head, int k) {
	ListNode dummy = new ListNode(0);
	dummy.next = head;
	ListNode lastGroupTail = dummy;
	ListNode p = head;
	boolean reverse = true;

	while (reverse) {
	    for (int i = 0; i < k; ++i) {
		if (p == null) {
		    reverse = false;
		    break;
		}
		p = p.next;
	    }

	    if (reverse) {
		ListNode nextGroupHead = p;
		p = lastGroupTail.next;
		ListNode tmp = p;
		lastGroupTail.next = null;

		for (int i = 0; i < k; ++i) {
		    ListNode next = p.next;
		    p.next = lastGroupTail.next;
		    lastGroupTail.next = p;
		    p = next;
		}

		reverse = true;
		lastGroupTail = tmp;
		lastGroupTail.next = nextGroupHead;
		p = nextGroupHead;
	    }
	}

	return dummy.next;
    }
}
