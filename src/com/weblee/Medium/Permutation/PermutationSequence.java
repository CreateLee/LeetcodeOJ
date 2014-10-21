package com.weblee.Medium.Permutation;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014��10��20������10:45:39
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class PermutationSequence {
    public String getPermutation(int n, int k) {
	int[] num = new int[n];

	// count = !n
	int count = 1;
	for (int i = 0; i < n; i++) {
	    num[i] = i + 1;
	    count *= (i + 1);
	}
	
	// n�Ǵ�1��ʼ ����kth�� ���±�Ϊ k-1
	k--;
	StringBuilder sb = new StringBuilder();
	
	// �ݹ����
	for (int i = 0; i < n; i++) {
	    // ��i�� ÿ���ڵ����ж�����������ϣ�ע�� count��������±�,�����±�� 0 ��ʼ
	    count /= n - i;
	    // Ӧ��ѡ�� i��ĵڼ�����ע�� selected ��������±�,�����±�� 0 ��ʼ
	    int selected = k / count;
	    // ���� ��i��ǰ��ģ� �õ���k
	    k = k % count;

	    sb.append(num[selected]);

	    // restruct nums since one num has been picked
	    for (int j = selected + 1; j < n; j++) {
		num[j - 1] = num[j];
	    }
	}

	return sb.toString();
    }
}
