package com.leetcode.dynamicProgram.p500.p510.p516;

import java.util.Arrays;

/**
 * 516. 最长回文子序列
 *
 * 给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。
 *
 * 示例 1:
 * 输入:
 *
 * "bbbab"
 * 输出:
 *
 * 4
 * 一个可能的最长回文子序列为 "bbbb"。
 *
 * 示例 2:
 * 输入:
 *
 * "cbbd"
 * 输出:
 *
 * 2
 * 一个可能的最长回文子序列为 "bb"。
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 只包含小写英文字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-subsequence
 *
 * 思路：
 *      单字符串的动态规划（子序列问题）
 *      dp数组：
 *          二维dp[][]
 *          dp(i,j)表示str(i,...,j)的最长回文子序列,结果：dp(0,length-1)
 *              相等：dp(i,j) = dp(i+1,j-1)+1
 *              不相等：dp(i,j) = max(dp(*,*))
 *      base case
 *          i==j dp(i,j)=1 单字符
 *          i>j dp(i,j)=0
 *
 *      注意迭代方向
 *
 */
public class Solution {
    public int longestPalindromeSubseq(String s) {

        // 初始化
        int length = s.length();
        int[][] dp = new int[length][length];

        //base case
        for (int i = 0; i < length; i++) {
            Arrays.fill(dp[i], 0);
            dp[i][i] = 1;
        }

        //迭代计算,方向要朝着dp[0][length-1]去
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {

                //相等
                if (s.charAt(i) == s.charAt(j)) {
                    //注意这里不是 +1
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][length - 1];
    }
}
