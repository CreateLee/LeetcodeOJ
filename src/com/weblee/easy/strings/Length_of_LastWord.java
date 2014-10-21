package com.weblee.easy.strings;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月20日上午9:48:09
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class Length_of_LastWord {
    public static int lengthOfLastWord(String s) {
	if (s == null) {
	    return 0;
	}
	int len = 0;
	int i = s.length() - 1;
	
	while (true) {
	    if (i == -1) {
		break;
	    }
	    
	    if (s.charAt(i) != ' ') {
		len++;
	    } else if (s.charAt(i) == ' ') {
		// 若再次遇到blank，则退出while loop
		if (len>0) {
		    break;
		}
		
		len = 0;
	    }
	    
	    i--;
	}
	
	return len;
    }
    
    public static void main(String[] args) {
	System.out.println(lengthOfLastWord("likai"));
    }
   
}
