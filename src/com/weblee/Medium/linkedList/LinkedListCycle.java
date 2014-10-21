package com.weblee.Medium.linkedList;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月20日下午6:29:36

 *************  function description  ***************
 *
 ****************************************************
 */

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
	// 设置两个指针，一个快一个慢
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
