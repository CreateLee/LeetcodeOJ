package com.weblee.detail.linkedList;


/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月19日下午1:54:07
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class RemoveDuplicates_from_SortedList {
    public static ListNode deleteDuplicates(ListNode head) {
	ListNode base = head; // base 为每次被比较的对象
	
	if (head == null || head.next == null) {
	    return head;
	}
	ListNode cur = head.next; // cur为每次去比较的对象

	while (base != null && cur != null) {
	    if (base.val == cur.val) { // 重复了就跳过去
		base.next = cur.next;
	    } else { // 不重复就更新base
		base = base.next;
	    }
	    cur = cur.next; // 更新cur
	}

	return head;
    }
}
