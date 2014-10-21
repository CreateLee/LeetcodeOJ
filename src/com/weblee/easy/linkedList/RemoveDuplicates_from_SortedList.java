package com.weblee.easy.linkedList;


/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014��10��19������1:54:07
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class RemoveDuplicates_from_SortedList {
    public static ListNode deleteDuplicates(ListNode head) {
	ListNode base = head; // base Ϊÿ�α��ȽϵĶ���
	
	if (head == null || head.next == null) {
	    return head;
	}
	ListNode cur = head.next; // curΪÿ��ȥ�ȽϵĶ���

	while (base != null && cur != null) {
	    if (base.val == cur.val) { // �ظ��˾�����ȥ
		base.next = cur.next;
	    } else { // ���ظ��͸���base
		base = base.next;
	    }
	    cur = cur.next; // ����cur
	}

	return head;
    }
}
