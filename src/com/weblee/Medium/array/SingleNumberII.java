package com.weblee.Medium.array;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014��10��20������9:34:07
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class SingleNumberII {
    public int singleNumber(int[] A) {
	int ones = 0, twos = 0, threes = 0;

	for (int i = 0; i < A.length; i++) {
	    threes = twos & A[i]; // �Ѿ��������β����ٴγ���
	    twos = twos | ones & A[i]; // �����������εĻ�����������һ�ε����ٴγ��ֵ�
	    ones = ones | A[i]; // ����һ�ε�

	    twos = twos & ~threes; // ��ĳһλ�������κ����Ǿʹӳ���������������λ
	    ones = ones & ~threes; // ��ĳһλ�������κ����Ǿʹӳ���һ����������λ
	}

	return ones; // twos, threes���ն�Ϊ0.ones��ֻ����һ�ε���
    }

}
