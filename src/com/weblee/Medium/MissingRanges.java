package com.weblee.Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2015年3月7日下午12:28:26
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class MissingRanges {
    public List<String> findMissingRanges(int[] vals, int start, int end) {
	List<String> ranges = new ArrayList<>();
	int prev = start - 1;
	
	for (int i = 0; i <= vals.length; i++) {
	    int curr = (i == vals.length) ? end + 1 : vals[i];
	    if (curr - prev >= 2) {
		ranges.add(getRange(prev + 1, curr - 1));
	    }
	    prev = curr;
	}
	
	return ranges;
    }

    private String getRange(int from, int to) {
	return (from == to) ? String.valueOf(from) : from + "->" + to;
    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
