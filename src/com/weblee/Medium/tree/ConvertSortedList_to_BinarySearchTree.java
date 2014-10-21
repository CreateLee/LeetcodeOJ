package com.weblee.Medium.tree;


/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014��10��20������6:27:45
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class ConvertSortedList_to_BinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
	return rec(head, null); 
    }
    
    // ������[start, end)��ݹ飬�����end�ǰ������ڵģ��������Ա���Ҫ����һ��ָ������¼midǰ�Ľڵ�  
    public static TreeNode rec(ListNode start, ListNode end){  
        if(start == end){  
            return null;  
        }  
           
        // һ�α����ҵ��е�ķ���������ָ��  
        ListNode mid = start;           // ��ָ�����ջ�ָ���е�  
        ListNode probe = start;         // ̽�����ջᵽ��end  
        
        while(probe!=end && probe.next!=end){       // ̽�����������ע��ֹͣ�����Ǻ�end�Ƚ϶����Ǻ�null�ȣ�  
            mid = mid.next;  
            probe = probe.next.next;  
        }  
           
        TreeNode root = new TreeNode(mid.val);  
        root.left = rec(start, mid);  
        root.right = rec(mid.next, end);
        
        return root;  
    }  
    
    // find the second half head
    public static ListNode getMiddle(ListNode head) {
	ListNode fast = head.next;
 	ListNode slow = head;
 	
 	while (fast != null && fast.next != null) {
 	    fast = fast.next.next;
 	    slow = slow.next;
 	}
 	
 	return slow;
    }
 	
}
