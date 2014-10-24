package com.weblee.Medium.linkedList;

import javax.security.auth.kerberos.KerberosKey;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月23日下午7:32:09
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class RotateList {
    /*
     * 先遍历一遍，得出链表长度len，注意k 可能大于len，因此令k% = len。 将尾节点next 指针指向首节点，形成一个环，接着往后跑len
     * 􀀀 k 步，从这里断开，就是要求的结果了。
     */

    public ListNode rotateRight(ListNode head, int n) {
	if (head == null || n == 0) {
	    return head;
	}

	int len = 1;
	ListNode p = head;

	while (p.next != null) {// 求长度
	    len++;
	    p = p.next;
	}

	n = len - n % len;

	p.next = head;// 首尾相连

	for (int step = 0; step < n; step++) {
	    p = p.next;// 接着往后跑
	}

	head = p.next;// 新的首节点
	p.next = null;// 断开环

	return head;
    }
}
