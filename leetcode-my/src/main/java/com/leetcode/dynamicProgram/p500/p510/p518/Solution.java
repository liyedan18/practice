package com.leetcode.dynamicProgram.p500.p510.p518;

import java.util.Arrays;

/**
 * 518. 零钱兑换 II
 *
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。 
 *
 * 示例 1:
 *
 * 输入: amount = 5, coins = [1, 2, 5]
 * 输出: 4
 * 解释: 有四种方式可以凑成总金额:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * 示例 2:
 *
 * 输入: amount = 3, coins = [2]
 * 输出: 0
 * 解释: 只用面额2的硬币不能凑成总金额3。
 * 示例 3:
 *
 * 输入: amount = 10, coins = [10]
 * 输出: 1
 *
 * 注意:
 *
 * 你可以假设：
 *
 * 0 <= amount (总金额) <= 5000
 * 1 <= coin (硬币面额) <= 5000
 * 硬币种类不超过 500 种
 * 结果符合 32 位符号整数
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change-2
 *
 * 思路：
 *      穷举 -> 动态规划
 *      类似背包问题  完全背包问题  使用背包问题解决套路
 *
 *      状态：
 *          物品个数、背包重量
 *          二维
 *      选择：
 *          装、不装到背包
 *      状态转移方程：
 *          dp[i][j]表示对于前i个物品，背包总重量为j时，组合个数为dp[i][j]
 *          dp[i][j]表示对于前i个硬币，总金额为j时，组合个数为dp[i][j]
 *
 *          求dp[n][coins.length]
 *          求所有组合个数，用加法
 *          dp[i][j] = dp[i-1][j]
 *                      + dp[i][j-coins[i-1]]
 *      base case:
 *          dp[0][*]=0
 *          dp[*][0]=1
 */
public class Solution {
    public int change(int amount, int[] coins) {

        int length = coins.length;
        //初始化和base case
        int[][] dp = new int[length + 1][amount + 1];
        for (int i = 0; i < length + 1; i++) {
            Arrays.fill(dp[i], 0);
            dp[i][0] = 1;
        }

        //迭代计算
        //个数，从1开始
        for (int i = 1; i < length + 1; i++) {
            //总金额
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j]    //不装
                            + dp[i][j - coins[i - 1]];    //装
                }
            }
        }

        return dp[length][amount];
    }
}
