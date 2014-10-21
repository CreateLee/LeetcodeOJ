package com.weblee.Medium.linkedList;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014��10��20������6:29:36

 *************  function description  ***************
 *
 ****************************************************
 */

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
	// ��������ָ�룬һ����һ����
	ListNode slow = head, fast = head;
	while (fast != null && fast.next != null) {
	    slow = slow.next;
	    fast = fast.next.next;
	    
	    if (slow == fast)
		return true;
	}
	
	return false;
    }
}
