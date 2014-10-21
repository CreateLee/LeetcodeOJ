package com.weblee.easy.linkedList;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月20日下午12:47:24
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

	// 用dummyHead来增加一个虚拟表头有效地减少了工作量！！
	ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
	dummyHead.next = head;
	
	ListNode pre = dummyHead;
	ListNode cur = pre.next;
	ListNode next = cur.next;
	
	boolean dup = false; // 判断是否有重复

	while (true) {
	    //
	    if (next == null) {
		break;
	    }
	    
	    if (cur.val != next.val) {
		if (dup) { // 如果有重复的，就跳过
		    pre.next = next;
		    dup = false; // 恢复dup
		} else { // 否则同步更新pre
		    pre = cur;
		}
		cur = next;
		next = next.next;
	    } else if (cur.val == next.val) {
		dup = true;
		next = next.next;
	    }
	}

	// 扫尾工作，针对于例如{1,1}的情况，最后再判断一次
	if (dup) {
	    pre.next = next;
	}
	
	return dummyHead.next;
    }
}
