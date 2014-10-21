package com.weblee.easy.linkedList;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014��10��20������12:47:24
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class RemoveDuplicates_from_SortedListII {
    public ListNode deleteDuplicates(ListNode head) {
	if (head == null) {
	    return null;
	}

	// ��dummyHead������һ�������ͷ��Ч�ؼ����˹���������
	ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
	dummyHead.next = head;
	
	ListNode pre = dummyHead;
	ListNode cur = pre.next;
	ListNode next = cur.next;
	
	boolean dup = false; // �ж��Ƿ����ظ�

	while (true) {
	    //
	    if (next == null) {
		break;
	    }
	    
	    if (cur.val != next.val) {
		if (dup) { // ������ظ��ģ�������
		    pre.next = next;
		    dup = false; // �ָ�dup
		} else { // ����ͬ������pre
		    pre = cur;
		}
		cur = next;
		next = next.next;
	    } else if (cur.val == next.val) {
		dup = true;
		next = next.next;
	    }
	}

	// ɨβ���������������{1,1}�������������ж�һ��
	if (dup) {
	    pre.next = next;
	}
	
	return dummyHead.next;
    }
}
