package com.weblee.Medium.linkedList;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月20日下午6:30:46
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class ReorderList {
    /*
     * 解题思路：
     *  1.将单链表从中点处拆分成两部分：head和middle，可以采用快慢指针的方法实现；
     *  2.将middle部分单链表反转；
     *  3.穿插式合并head和middle两部分。
     */
    public void reorderList(ListNode head) {
	if (head == null || head.next == null) {
	    return;
	}

	// find the second half head
	ListNode fast = head.next;
	ListNode slow = head;
	while (fast != null && fast.next != null) {
	    fast = fast.next.next;
	    slow = slow.next;
	}
	
	// reverse the second half
	ListNode p = slow.next;
	slow.next = null; // cut the first half
	ListNode pPre = null;
	ListNode pSuf = p.next;
	
	while (p != null) {
	    pSuf = p.next;
	    p.next = pPre;
	    pPre = p;
	    p = pSuf;
	}
	
	// combine two halves
	ListNode l1 = head;
	ListNode l2 = pPre;
	while (l1 != null && l2 != null) {
	    ListNode l1Next = l1.next;
	    ListNode l2Next = l2.next;
	    l1.next = l2;
	    l2.next = l1Next;
	    
	    l1 = l1Next;
	    l2 = l2Next;
	}
    }
}
