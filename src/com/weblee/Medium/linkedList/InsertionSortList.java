package com.weblee.Medium.linkedList;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月23日下午8:20:26
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
	ListNode dummy = new ListNode(Integer.MIN_VALUE);

	for (ListNode cur = head; cur != null;) {
	    ListNode pos = findInsertPos(dummy, cur.val);

	    ListNode tmp = cur.next;
	    cur.next = pos.next;
	    pos.next = cur;
	    cur = tmp;
	}

	return dummy.next;
    }

    static ListNode findInsertPos(ListNode head, int x) {
	ListNode pre = null;

	for (ListNode cur = head; cur != null && cur.val <= x; pre = cur, cur = cur.next)
	    ;

	return pre;
    }
}
