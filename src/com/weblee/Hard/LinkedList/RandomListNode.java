package com.weblee.Hard.LinkedList;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月24日下午5:52:44
 * 
 *************        function description ***************
 *
 ****************************************************
 */

// Definition for singly-linked list with a random pointer.
class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
	this.label = x;
    }
};
