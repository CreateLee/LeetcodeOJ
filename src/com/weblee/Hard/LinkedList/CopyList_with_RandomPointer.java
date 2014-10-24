package com.weblee.Hard.LinkedList;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014��10��24������5:52:19
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class CopyList_with_RandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
	for (RandomListNode cur = head; cur != null;) {
	    RandomListNode node = new RandomListNode(cur.label);
	    node.next = cur.next;
	    cur.next = node;
	    cur = node.next;
	}

	for (RandomListNode cur = head; cur != null;) {
	    if (cur.random != null)
		cur.next.random = cur.random.next;

	    cur = cur.next.next;
	}
	// �ֲ�����������
	RandomListNode dummy = new RandomListNode(-1);

	for (RandomListNode cur = head, new_cur = dummy; cur != null;) {
	    new_cur.next = cur.next;
	    new_cur = new_cur.next;
	    cur.next = cur.next.next;
	    cur = cur.next;
	}

	return dummy.next;
    }
}
