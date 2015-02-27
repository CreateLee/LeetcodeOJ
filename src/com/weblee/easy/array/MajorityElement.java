package com.weblee.easy.array;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2015年2月17日下午1:48:23
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class MajorityElement {
    /*
     * O(n) computation/O(1) space] The problem can be extended to ⌊n/k⌋
     * situation Find k different element, and "remove" them as a group, the
     * remaining element must be the element that appears more than ⌊n/k⌋ times.
     * (Detailed explanation is given in comment)
     * 
     * In this problem, k equals to 2.
     * 
     * Thus we "remove" each pair of 2 different elements, and the remaining
     * element that do not have its counterpart is the desired element.
     */
    public int majorityElement(int[] num) {
	int nTimes = 0;
	int candidate = 0;
	
	for (int i = 0; i < num.length; i++) {
	    if (nTimes == 0) {
		candidate = num[i];
		nTimes = 1;
	    } else {
		if (candidate == num[i])
		    nTimes++;
		else
		    nTimes--;
	    }
	}
	
	return candidate;
    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
