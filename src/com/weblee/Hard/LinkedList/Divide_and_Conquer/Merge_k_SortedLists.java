package com.weblee.Hard.LinkedList.Divide_and_Conquer;

import java.util.List;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月24日下午12:35:59
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class Merge_k_SortedLists {
    /*
     *  思路：mergeSort的思想，K个链表先划分为合并两个k/2的链表，每个k/2的链表在划分为k/4的链表，一直到只剩一个或者两个链表。
     *  复杂度：T(k)=2T(k/2)+O(nk)，根据 主定理（算法导论上有讲），复杂度为O(nklogk)。
     */
    public ListNode mergeKLists(List<ListNode> lists) {
	if (lists == null || lists.size() == 0)
	    return null;

	return merge(lists, 0, lists.size() - 1);
    }

    private ListNode merge(List<ListNode> lists, int start, int end) {
	if (start == end)
	    return lists.get(start);

	int mid = (start + end) / 2;

	ListNode one = merge(lists, start, mid);
	ListNode two = merge(lists, mid + 1, end);

	return mergeTwoLists(one, two);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	if (l1 == null)
	    return l2;
	if (l2 == null)
	    return l1;
	ListNode p1 = l1;
	ListNode p2 = l2;

	ListNode head = new ListNode(-1);
	head.next = p1.val <= p2.val ? p1 : p2;
	ListNode tail = head;

	while (p1 != null && p2 != null) {
	    if (p1.val <= p2.val) {
		tail.next = p1;
		ListNode oldP1 = p1;
		p1 = p1.next;
		oldP1.next = null;
		tail = oldP1;
	    } else {
		tail.next = p2;
		ListNode oldP2 = p2;
		p2 = p2.next;
		oldP2.next = null;
		tail = oldP2;
	    }

	}
	if (p1 != null)
	    tail.next = p1;
	if (p2 != null)
	    tail.next = p2;

	return head.next;
    }
}
