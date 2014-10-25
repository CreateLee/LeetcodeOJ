package com.alibaba.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014��10��25������12:08:52
 * 
 *************        function description ***************
 *һ�����������и�Ԫ��������ϵõ�������һ���� �����磬1,3,9,11,23,233,911 Ҫ�õ���9��911��3��233��23��11��1
 ****************************************************
 */

public class BucketSort {
    // һ�����ݽṹ����Number ������Ŵ�����������Ϣ
    static class Number {
	Integer resource = 0;// ԭʼ������
	Integer middle = 0;// �м䲻�ϱ仯������
	int makeup = 0;// ��¼�����λ��

	public Number(int resource) {
	    this.resource = resource;
	    this.middle = resource;
	}

    }

    // һ��Ͱ�����ݽṹ��������List�������
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

    // ������ݵ�������
    public static Integer getHeadNumber(Integer a) {
	Integer b = 0;
	String c = a.toString();
	b = Integer.valueOf(c.substring(0, 1));
	
	return b;
    }

    // ���ȥ�������ֵ�ʣ�µ�����
    public static Integer getSubNumber(Number a) {
	Integer b = 0;
	String c = a.middle.toString();
	// ������ֻʣ��һλ��û����ȡʱ��Ҫ���䰴ԭ�������ݽ��в��䣡
	if (c.length() == 1) {
	    if (a.makeup < a.resource.toString().length()) {
		b = Integer.valueOf(a.resource.toString().substring(a.makeup,
			a.makeup + 1));
		if (a.makeup == a.resource.toString().length() - 1) {
		    a.makeup = 0;
		} else {
		    a.makeup++;// ����λ�ñ��
		}
	    }
	} else {
	    b = Integer.valueOf(c.substring(1));
	}
	
	return b;
    }

    // �ж�list�е�ֵ�Ƿ���ȫ��ͬ
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

    // װ������ĺ��ķ���
    public static void Sort(List<Number> R, List<Integer> L) {
	// ��list��ֻ��һ�����ݵ�ֱֵ��������ݹ����ֹ����
	Boolean isCommon = isCommon(R);
	if (R.size() == 1) {
	    L.add(R.get(0).resource);
	}
	// �����������е����ݶ���ͬʱ��û��˳��ֱ�����
	else if (R.size() > 1 && isCommon) {
	    for (int i = 0; i < R.size(); i++) {
		L.add(R.get(i).resource);
	    }
	}
	// �����������ݴ���1�������������в�ͬ��ʱ��ִ�еݹ�װ������
	else if (R.size() > 1 && !isCommon) {
	    Bucket[] buckets = new Bucket[10];
	    for (int i = 0; i < 10; i++) {
		buckets[i] = new Bucket();
	    }
	    for (int i = 0; i < R.size(); i++) {
		// �Ƚ���һ��װ�����
		int data = R.get(i).middle;// ��ȡҪ�Ƚϵ�����
		int site = getHeadNumber(data);// ��ȡҪ�Ƚϵ����ݵ���λ����
		R.get(i).middle = getSubNumber(R.get(i));
		buckets[site].addNumber(R.get(i));
	    }
	    // �����Ӱ�˳��ݹ飬��֤���С˳��
	    for (int i = 0; i < buckets.length; i++) {
		// �ݹ����Sort
		Sort(buckets[i].getNumbers(), L);
	    }
	}
    }

    // ����sort���ķ����Ľӿڷ���
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

    // �����������Ϊsort�ǰ��մ�С����Ľ�������ģ�����ҪDisplay��������һ��
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
