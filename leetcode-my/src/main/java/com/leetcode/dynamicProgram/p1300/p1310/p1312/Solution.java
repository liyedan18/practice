package com.leetcode.dynamicProgram.p1300.p1310.p1312;

import java.util.Arrays;

/**
 * 1312. 让字符串成为回文串的最少插入次数
 *
 * 给你一个字符串 s ，每一次操作你都可以在字符串的任意位置插入任意字符。
 *
 * 请你返回让 s 成为回文串的 最少操作次数 。
 *
 * 「回文串」是正读和反读都相同的字符串。
 *
 *
 * 示例 1：
 *
 * 输入：s = "zzazz"
 * 输出：0
 * 解释：字符串 "zzazz" 已经是回文串了，所以不需要做任何插入操作。
 * 示例 2：
 *
 * 输入：s = "mbadm"
 * 输出：2
 * 解释：字符串可变为 "mbdadbm" 或者 "mdbabdm" 。
 * 示例 3：
 *
 * 输入：s = "leetcode"
 * 输出：5
 * 解释：插入 5 个字符后字符串变为 "leetcodocteel" 。
 * 示例 4：
 *
 * 输入：s = "g"
 * 输出：0
 * 示例 5：
 *
 * 输入：s = "no"
 * 输出：1
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 500
 * s 中所有字符都是小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-insertion-steps-to-make-a-string-palindrome
 *
 *
 * 思路：
 *      字符串动态规划
 *      dp数组：
 *          dp(i,j)表示s(i,...,j)构造成为回文串的最少次数.结果：dp[0][length-1]
 *              字符串问题转换为字符问题，画字符串图和二维数组图推算
 *          相等：dp(i,j) = dp(i+1,j-1)
 *          不相等：dp(i,j) = min(dp(*,*) + 1)
 *
 *      base case
 *          i==j dp(i,j) = 0  一个字符本身就是回文串
 *          i>j dp(i,j) = 0
 */
public class Solution {
    public int minInsertions(String s) {

        //dp初始化
        int length = s.length();
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            Arrays.fill(dp[i], 0);
        }

        //base case 上面初始化时已经设置了

        //迭代计算
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i + 1; j <= length - 1; j++) {
                //相等
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    //不相等
                    dp[i][j] = Math.min(dp[i + 1][j] + 1, dp[i][j - 1] + 1);
                }
            }
        }

        return dp[0][length - 1];
    }
}
