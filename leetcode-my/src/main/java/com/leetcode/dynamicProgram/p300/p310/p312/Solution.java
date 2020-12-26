package com.leetcode.dynamicProgram.p300.p310.p312;

import java.util.Arrays;

/**
 * 312. 戳气球
 *
 * 有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组nums中。
 *
 * 现在要求你戳破所有的气球。如果你戳破气球 i ，就可以获得nums[left] * nums[i] * nums[right]个硬币。
 * 这里的left和right代表和i相邻的两个气球的序号。注意当你戳破了气球 i 后，气球left和气球right就变成了相邻的气球。
 *
 * 求所能获得硬币的最大数量。
 *
 * 说明:
 *
 * 你可以假设nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
 * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * 示例:
 *
 * 输入: [3,1,5,8]
 * 输出: 167
 * 解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 *     coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/burst-balloons
 *
 * 思路：
 *      求最值 -> 穷举 -> 动态规划
 *
 *      数组，一般用双指针类型的动态规划，dp[i][j]
 *          dp[i][j]表示戳破(i,j)开区间之间气球后获得的最大硬币数量，提示有nums[-1] = nums[n] = 1
 *          加入区间，则所求为dp[0][n]
 *          状态转移方程：
 *              选择：最后一个戳破的是气球是哪个k
 *              （可以写出dp数组，然后倒推dp方程）
 *              dp[i][j]=max(dp[i][j], dp[i][k] + dp[k][j]
 *                          + nums[k-1]*nums[i-1]*nums[j-1])
 *      base case
 *          i==j时，dp[i][j]=0
 *          i>j时，dp[i][j]=0
 *
 */
public class Solution {
    public int maxCoins(int[] nums) {

        //初始化，将两头的-1和n也加入进去
        int length = nums.length;
        int[][] dp = new int[length + 2][length + 2];
        for (int i = 0; i < length + 2; i++) {
            Arrays.fill(dp[i], 0);
        }

        //重新组织硬币数组，加入头-1和尾n
        int[] money = new int[length + 2];
        money[0] = money[length + 1] = 1;
        for (int i = 0; i < length; i++) {
            money[i + 1] = nums[i];
        }

        //求dp[0][n]，注意方向
        for (int i = length + 2 - 1; i >= 0; i--) {
            for (int j = i + 1; j <= length + 2 - 1; j++) {

                //做选择，取最后一个戳破的气球的最大值.不知道哪一个最大，就全部遍历一遍，然后找最大值
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j],
                            dp[i][k] + dp[k][j] + money[i] * money[k] * money[j]);
                }
            }
        }

        return dp[0][length + 1];
    }
}
