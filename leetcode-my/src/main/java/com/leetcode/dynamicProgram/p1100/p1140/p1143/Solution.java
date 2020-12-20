package com.leetcode.dynamicProgram.p1100.p1140.p1143;

import java.util.Arrays;

/**
 * 1143. 最长公共子序列
 *
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符
 * （也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 *
 * 若这两个字符串没有公共子序列，则返回 0。
 *
 *
 * 示例 1:
 *
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace"，它的长度为 3。
 * 示例 2:
 *
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc"，它的长度为 3。
 * 示例 3:
 *
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0。
 *
 * 提示:
 *
 * 1 <= text1.length <= 1000
 * 1 <= text2.length <= 1000
 * 输入的字符串只含有小写英文字符。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-subsequence
 *
 * 思路：
 *      不能用滑动窗口
 *      子序列问题，一般就是动态规划
 *
 *      两个字符串的动态规划，一般需要两个指针(i,j)指向字符串的最后，然后往前推导状态转移方程
 *      很有可能是二维的
 *
 *      dp(i,j)的定义：
 *          s1[0,...,i]和s2[0,...,j]的最长公共子序列的长度
 *          选择：
 *              第i,j个字符可能在lcs中，也可能不在lcs中
 *          状态转移方程：
 *              dp(i,j)=dp(i-1,j-1) + 1
 *      base case
 *          s1或s2为空时，长度为0
 *
 */
public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null) {
            return 0;
        }

        //dp数组
        int m = text1.length();
        int n = text2.length();
        //多出的1留给空字符串
        int[][] dp = new int[m + 1][n + 1];

        //base case  dp[0][]和dp[][0]为0 -- 两个字符串至少有一个为空时，LCS为0
        //全部初始化为0
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], 0);
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //对应位置字符相等时，LCS+1
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    //对应位置字符不相等，可能其中一个字符会在LCS中，也可能都不在LCS中
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

}
