package com.weblee.Medium.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.weblee.Medium.array.NextPermutation;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月23日下午8:32:35
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class Permutations {
    public List<List<Integer>> permute(int[] num) {
	Arrays.sort(num);
	
	List<List<Integer>> permutations = new ArrayList<List<Integer>>();
	do {
	    permutations.add(array2List(num));
	    NextPermutation.nextPermutation(num);
	} while (!Arrays.equals(num, list2Array(permutations.get(0)))); // 见第2.1 节
	return permutations;
    }
    
    static List<Integer> array2List(int[] array) {
	List<Integer> result = new ArrayList<Integer>();
	
	for (int num : array) {
	    result.add(num);
	}
	
	return result;
    }
    
    static int[] list2Array(List<Integer> list) {
	int[] result = new int[list.size()];
	
	for (int i=0;i<list.size();i++) {
	    result[i] = list.get(i);
	}
	
	return result;
    }
}
