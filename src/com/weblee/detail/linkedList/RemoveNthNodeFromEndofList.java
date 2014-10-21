package com.weblee.detail.linkedList;


/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014��10��18������9:57:01
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class RemoveNthNodeFromEndofList {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
	// Note: The Solution object is instantiated only once and is reused by each test case.  
        if(head == null)  
            return null;  	
	
	ListNode first = head;
	ListNode rear = head;
	
	while (true) {
	    if (n==0) {
		//System.out.println(first.val);
		break;
	    }
	    
	    first = first.next;
	    n--;
	}
	
	while (true) {
	    // ��������n��Ԫ���ǵ�һ��Ԫ�أ�������head
	    if (first == null) {
		head = rear.next;
		
		return head;
	    }
	    if (first.next == null) {
		rear.next = rear.next.next;
		
		return head;
	    }
	    first = first.next;
	    rear = rear.next;
	}
    }
    
    public static void main(String[] args) {
	ListNode head = new ListNode(1);
	head.next = new ListNode(8);
	
	head = removeNthFromEnd(head, 2);
	
	while (head != null) {
	    System.out.println(head.val);
	    
	    head = head.next;
	}
    }
}
