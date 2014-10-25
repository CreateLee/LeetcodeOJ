package com.Netesay.interview;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月24日下午6:29:40
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class LRUCache {
    Map<Integer, CacheNode> cacheMap;
    CacheNode head, tail;
    int capacity;
    
    //使用双向链表和map，map将k对应与链表的节点  
    //链表里保存k和value  
    public LRUCache(int capacity) {
	this.capacity = capacity;
	
	cacheMap = new HashMap<Integer, CacheNode>(capacity);
	
	head = new CacheNode(-1, -1);
	tail = new CacheNode(1, 1);
	
	head.next = tail;
	tail.pre = head;
    }

    public int get(int key) {
	if (cacheMap.containsKey(key)) {
	    CacheNode node = (CacheNode)cacheMap.get(key);
	    
	    put2Head(node);
	    
	    return node.value;
	} else {
	    return -1;
	}
    }

    public void set(int key, int value) {
	if (cacheMap.containsKey(key)) {
	    CacheNode p = cacheMap.get(key);
	    
	    p.value = value;
	    
	    put2Head(p);
	} else if(cacheMap.size() < capacity) {
	    CacheNode node = new CacheNode(key, value);
	    put2Head(node);
	    cacheMap.put(key, node);
	} else {
	    CacheNode p = new CacheNode(key, value);
	    put2Head(p);
	    cacheMap.put(key, p);
	    
	    int tmpKey = removeEnd();
	    cacheMap.remove(tmpKey);
	}
    }
    
    private void put2Head(CacheNode p) {
	if (p.next != null && p.pre != null) {
	    p.pre.next = p.next;
	    p.next.pre = p.pre;
	}
	
	p.pre = head;
	p.next = head.next;
	head.next.pre = p;
	head.next = p;
    }
    
    private int removeEnd() {
	CacheNode p = tail.pre;
	tail.pre.pre.next = tail;
	tail.pre = p.pre;
	
	p.pre = null;
	p.next = null;
	
	return p.key;
    }
}

class CacheNode {
    int key;
    int value;
    
    CacheNode pre;
    CacheNode next;

    public CacheNode(int key, int value) {
	this.key = key;
	this.value = value;
    }
}
