package com.weblee.Medium.linkedList;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014��10��23������7:14:55
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class SortList {
    public ListNode sortList(ListNode head) {
	if (head == null || head.next == null)
	    return head;
	// ����ָ���ҵ��м�ڵ�
	ListNode fast = head, slow = head;
	while (fast.next != null && fast.next.next != null) {
	    fast = fast.next.next;
	    slow = slow.next;
	}
	// �Ͽ�
	fast = slow;
	slow = slow.next;
	fast.next = null;

	ListNode l1 = sortList(head); // ǰ�������
	ListNode l2 = sortList(slow); // ��������
	return mergeTwoLists(l1, l2);
    }

    // Merge Two Sorted Lists
    static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	ListNode dummy = new ListNode(-1);

	for (ListNode p = dummy; l1 != null || l2 != null; p = p.next) {
	    int val1 = (l1 == null) ? Integer.MAX_VALUE : l1.val;
	    int val2 = (l2 == null) ? Integer.MAX_VALUE : l2.val;

	    if (val1 <= val2) {
		p.next = l1;
		l1 = l1.next;
	    } else {
		p.next = l2;
		l2 = l2.next;
	    }
	}

	return dummy.next;
    }
}
