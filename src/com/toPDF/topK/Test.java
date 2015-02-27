package com.toPDF.topK;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年12月3日下午2:19:45

 *************  function description  ***************
 *
 ****************************************************
 */

public class Test {

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	String string = "dcaucf buayb  e554e sdfsuyfbs";
	
	
	
	for (String word : string.toLowerCase().split("\\W+|\\d+")) {
	    System.out.println(word);
	}
	
	
    }

}
