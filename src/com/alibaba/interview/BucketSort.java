package com.alibaba.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月25日下午12:08:52
 * 
 *************        function description ***************
 *一个整型数组中各元素排列组合得到的最大的一个数 ，比如，1,3,9,11,23,233,911 要得到：9，911，3，233，23，11，1
 ****************************************************
 */

public class BucketSort {
    // 一个数据结构，类Number 用来存放待排序的相关信息
    static class Number {
	Integer resource = 0;// 原始的数据
	Integer middle = 0;// 中间不断变化的数据
	int makeup = 0;// 记录补充的位置

	public Number(int resource) {
	    this.resource = resource;
	    this.middle = resource;
	}

    }

    // 一个桶的数据结构，里面用List存放数据
    static class Bucket {
	List<Number> list;

	public Bucket() {
	    list = new ArrayList<Number>();
	}

	public void addNumber(Number num) {
	    list.add(num);
	}

	public List<Number> getNumbers() {
	    return list;
	}
    }

    // 获得数据的首数字
    public static Integer getHeadNumber(Integer a) {
	Integer b = 0;
	String c = a.toString();
	b = Integer.valueOf(c.substring(0, 1));
	
	return b;
    }

    // 获得去掉首数字的剩下的数据
    public static Integer getSubNumber(Number a) {
	Integer b = 0;
	String c = a.middle.toString();
	// 当数据只剩下一位，没法截取时，要将其按原来的数据进行补充！
	if (c.length() == 1) {
	    if (a.makeup < a.resource.toString().length()) {
		b = Integer.valueOf(a.resource.toString().substring(a.makeup,
			a.makeup + 1));
		if (a.makeup == a.resource.toString().length() - 1) {
		    a.makeup = 0;
		} else {
		    a.makeup++;// 补充位置标记
		}
	    }
	} else {
	    b = Integer.valueOf(c.substring(1));
	}
	
	return b;
    }

    // 判断list中的值是否完全相同
    public static Boolean isCommon(List<Number> R) {
	for (int i = 0; i < R.size(); i++) {
	    for (int j = i + 1; j < R.size(); j++) {
		if (!R.get(i).middle.equals(R.get(j).middle)) {
		    return false;
		}
	    }
	}
	
	return true;
    }

    // 装箱排序的核心方法
    public static void Sort(List<Number> R, List<Integer> L) {
	// 将list中只有一个数据的值直接输出，递归的终止条件
	Boolean isCommon = isCommon(R);
	if (R.size() == 1) {
	    L.add(R.get(0).resource);
	}
	// 当链表中所有的数据都相同时就没有顺序，直接输出
	else if (R.size() > 1 && isCommon) {
	    for (int i = 0; i < R.size(); i++) {
		L.add(R.get(i).resource);
	    }
	}
	// 当链表中数据大于1，并且数据中有不同的时候执行递归装箱区分
	else if (R.size() > 1 && !isCommon) {
	    Bucket[] buckets = new Bucket[10];
	    for (int i = 0; i < 10; i++) {
		buckets[i] = new Bucket();
	    }
	    for (int i = 0; i < R.size(); i++) {
		// 先进行一次装箱操作
		int data = R.get(i).middle;// 获取要比较的数据
		int site = getHeadNumber(data);// 获取要比较的数据的首位数字
		R.get(i).middle = getSubNumber(R.get(i));
		buckets[site].addNumber(R.get(i));
	    }
	    // 将箱子按顺序递归，保证其大小顺序
	    for (int i = 0; i < buckets.length; i++) {
		// 递归调用Sort
		Sort(buckets[i].getNumbers(), L);
	    }
	}
    }

    // 调用sort核心方法的接口方法
    public static List<Integer> getMaxArray(Integer[] arr) {
	List<Number> R = new ArrayList<Number>();
	for (int i = 0; i < arr.length; i++) {
	    Number temp = new Number(arr[i]);
	    R.add(temp);
	}
	List<Integer> L = new ArrayList<Integer>();
	Sort(R, L);
	
	return L;
    }

    // 输出方法，因为sort是按照从小到大的进行排序的，所以要Display方法处理一下
    public static void display(List<Integer> L) {
	for (int i = L.size() - 1; i > 0; i--) {
	    System.out.print(L.get(i) +  "\t");
	}
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	Integer[] arr = { 1, 3, 9, 11, 23, 233, 911 };
	display(getMaxArray(arr));
    }
}
