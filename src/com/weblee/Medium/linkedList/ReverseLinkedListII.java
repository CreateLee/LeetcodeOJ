package com.weblee.Medium.linkedList;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月23日上午9:37:03
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
	ListNode dummy = new ListNode(-1);
	dummy.next = head;

	ListNode prev = dummy;

	for (int i = 0; i < m - 1; ++i)
	    prev = prev.next;
	
	ListNode head2 = prev;
	prev = head2.next;
	ListNode cur = prev.next;

	for (int i = m; i < n; ++i) {
	    prev.next = cur.next;
	    cur.next = head2.next;
	    head2.next = cur; // 头插法
	    cur = prev.next;
	}

	return dummy.next;
    }
}
