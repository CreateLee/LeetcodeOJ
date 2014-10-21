package com.weblee.Medium.linkedList;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月20日下午6:30:23
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
	ListNode slow = head, fast = head;

	while (fast != null && fast.next != null) {
	    slow = slow.next;
	    fast = fast.next.next;
	    
	    if (slow == fast) {
		ListNode slow2 = head;
		
		while (slow2 != slow) {
		    slow2 = slow2.next;
		    slow = slow.next;
		}
		
		return slow2;
	    }
	}
	return null;
    }
}
