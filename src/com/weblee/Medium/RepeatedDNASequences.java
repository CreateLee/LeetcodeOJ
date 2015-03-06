package com.weblee.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2015年2月18日上午9:20:12
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	List<String> result = new ArrayList<String>();

	if (s.length() <= 10) {
	    return result;
	}

	// encode
	char[] convert = new char[26];
	convert[0] = 0;
	convert[2] = 1;
	convert[6] = 2;
	convert[19] = 3;

	int hashValue = 0;

	/*
	 * the first 10 characters string
	 */
	for (int pos = 0; pos < 10; ++pos) {
	    hashValue <<= 2;
	    hashValue |= convert[s.charAt(pos) - 'A'];
	}

	// first 10-letter-long sequences encode -> value
	map.put(hashValue, 1);

	// remove duplicate
	HashSet<Integer> set = new HashSet<>();

	for (int pos = 10; pos < s.length(); ++pos) {
	    // left 2 bit, equal to multiply 4
	    hashValue <<= 2;
	    // the 2 right bit valued encode of s.char(pos) 
	    hashValue |= convert[s.charAt(pos) - 'A'];
	    // 最高两位置0
	    hashValue &= ~(0x300000);

	    if (!map.containsKey(hashValue)) {
		map.put(hashValue, 1);
	    } else {
		if (!set.contains(hashValue)) {
		    // 10-letter-long sequences
		    result.add(s.substring(pos - 9, pos + 1));

		    set.add(hashValue);
		}

		map.replace(hashValue, 1 + map.get(hashValue));
	    }
	}

	return result;
    }
    
    public static void main(String[] args) {
	System.out.println(4 << 2);
    }

}
