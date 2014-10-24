package com.weblee.Medium.linkedList;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014��10��23������9:39:07
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
	ListNode left_dummy = new ListNode(-1); // ͷ���
	ListNode right_dummy = new ListNode(-1); // ͷ���

	ListNode left_cur = left_dummy;
	ListNode right_cur = right_dummy;

	for (ListNode cur = head; cur != null; cur = cur.next) {
	    if (cur.val < x) {
		left_cur.next = cur;
		left_cur = cur;
	    } else {
		right_cur.next = cur;
		right_cur = cur;
	    }
	}
	
	left_cur.next = right_dummy.next;
	right_cur.next = null;

	return left_dummy.next;
    }
}
