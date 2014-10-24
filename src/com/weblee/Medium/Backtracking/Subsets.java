package com.weblee.Medium.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月23日上午9:42:03
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class Subsets {
    public List<List<Integer>> subsets(int[] S) {
	Arrays.sort(S);
	List<List<Integer>> result = new ArrayList<List<Integer>>();
	// BitSet select = new BitSet(S.length);
	/**
	     * Sets all of the bits in this BitSet to {@code false}.
	     *
	     * @since 1.4
	     
	    public void clear() {
	        while (wordsInUse > 0)
	            words[--wordsInUse] = 0;
	    }
	    */
	//select.clear();
	boolean[] select = new boolean[S.length]; 
	
	subsets(S, select, 0, result);
	
	return result;
    }
    
    // public static void subsets(final int[] S, BitSet select, int step, List<List<Integer>> result) {
    public static void subsets(final int[] S, boolean[] select, int step, List<List<Integer>> result) {
	if (step == S.length) {
	    List<Integer> subset = new ArrayList<Integer>();
	    
	    for (int i=0; i< S.length; i++) {
		if (select[i]) {
		    subset.add(S[i]);
		}
	    }
	    
	    result.add(subset);
	    
	    return;
	}
	
	// 不选S[step]
	select[step] = false;
	subsets(S, select, step + 1, result);
	// 选S[step]
	select[step] = true;
	subsets(S, select, step + 1, result);
    }
}
