package com.weblee.easy;

import java.util.Arrays;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年10月19日下午1:42:04
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class ClimbingStairs { 
    public static int climbStairs(int n) {
        // dp数组，用来保存结果，可以适当开大一些
        int[] dp = new int[n+5];        
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        
        return rec(n, dp);
    }
     
    // 递归+dp
    private static int rec(int n, int[] dp){
        if(dp[n] != -1){
            return dp[n];
        }else{
            dp[n] = rec(n-1, dp) + rec(n-2, dp);
            return dp[n];
        }
    }
}
