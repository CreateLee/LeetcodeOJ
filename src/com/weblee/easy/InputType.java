package com.weblee.easy;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月18日下午5:24:14

 *************  function description  ***************
 *
 ****************************************************
 */

public enum InputType {
    INVALID(0),    // 0
    SPACE(1),      // 1
    SIGN(2),       // 2
    DIGIT(3),      // 3
    DOT(4),        // 4
    EXPONENT(5),   // 5
    NUM_INPUTS(6); // 6
    
    int index;
    
    private InputType(int index) {
	this.index = index;
    }
}
