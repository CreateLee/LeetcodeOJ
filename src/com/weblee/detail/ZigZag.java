package com.weblee.detail;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014��10��18������7:24:45
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class ZigZag {
    /*
     * �ؼ���Ҫ����μ�������ַ���λ�ã������Ҫ��ѧ֪ʶ�ˣ����������Ƶ�����ʽ���� ��Ҫ��3����ʽ��
     *  1 ֮��������ΪnRows,��ôÿ���ظ�������ǰ�ļ���ַ�ΪzigSpan = nRows*2-2; 
     *  2 ��һ�к���βһ�ж��Ǵ��һ���ַ��ģ����Դ洢���ַ�Ϊ���ΪzigSpan���ַ� 
     *  3 �м�������Ҫ����洢��һ���ַ��ģ��洢���ַ�λ���ǣ�zigSpan + j - 2*i������iΪ������jΪ���еڼ����ַ��ˣ�
     */
    public String convert(String s, int nRows) {
	if (nRows <= 1 || s.length() < 3 || s.length() <= nRows)
	    return s;
	
	StringBuffer buffer = new StringBuffer();
	
	int zigSpan = nRows * 2 - 2;
	for (int i = 0; i < nRows; i++) {
	    for (int j = i; j < s.length(); j += zigSpan) {
		buffer.append(s.charAt(j));
		// ע�⣺�Ƶ���zigSpan+j-2i����ѧ��ʽ��һ�㶼���ܴ�
		if (i != 0 && i != nRows - 1
			&& (zigSpan + j - 2 * i) < s.length()) {
		    buffer.append(s.charAt(zigSpan + j - 2 * i));
		}
	    }
	}
	return buffer.toString();
    }
}
