package com.weblee.Medium.linkedList;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月23日下午2:21:31
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class SwapNodes_in_Pairs {
    public ListNode swapPairs(ListNode head) {
	if (head == null || head.next == null) {
	    return head;
	}

	ListNode dummy = new ListNode(-1);
	dummy.next = head;

	for (ListNode prev = dummy, cur = prev.next, next = cur.next; next != null; prev = cur, cur = cur.next, next = (cur != null) ? cur.next
		: null) {
	    prev.next = next;
	    cur.next = next.next;
	    next.next = cur;
	}

	return dummy.next;
    }
}
