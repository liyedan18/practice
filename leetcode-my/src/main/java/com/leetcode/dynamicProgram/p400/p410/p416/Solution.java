package com.leetcode.dynamicProgram.p400.p410.p416;

import java.util.Arrays;

/**
 * 416. 分割等和子集
 *
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 *
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 *
 * 输入: [1, 5, 11, 5]
 *
 * 输出: true
 *
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *
 *
 * 示例2:
 *
 * 输入: [1, 2, 3, 5]
 *
 * 输出: false
 *
 * 解释: 数组不能分割成两个元素和相等的子集.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
 *
 * 思路：
 *      类似0-1背包问题
 *          背包总共可以装sum/2的重量，有N个物品，每个物品重量nums[],是否可以刚好装满
 *
 *      状态：
 *          背包重量和物品个数
 *          dp[i][j]表示前i个物品，重量为j时，能否完全装满
 *      选择：
 *          第i个物品装、不装到背包
 *
 *      dp[i][j] = dp[i-1][j]  //不装
 *                  || dp[i-1][j-nums[i]]   //装
 *
 *      求：dp[N][sum/2]
 *      base case
 *          dp[0][*]=false
 *          dp[*][0]=true
 */
public class Solution {
    public boolean canPartition(int[] nums) {

        int sum = Arrays.stream(nums).sum();
        //不能被2整除，肯定不能分割成两个子集
        if (sum % 2 != 0) {
            return false;
        }
        sum = sum / 2;

        //初始化和base case，+1是因为有0的情况
        boolean[][] dp = new boolean[nums.length + 1][sum + 1];
        for (int i = 0; i < nums.length + 1; i++) {
            Arrays.fill(dp[i], false);
            dp[i][0] = true;
        }

        //base case

        //迭代计算
        //物品个数
        for (int i = 1; i <= nums.length; i++) {
            //背包重量
            for (int j = 1; j <= sum; j++) {
                //根据状态转移方程中的dp[i - 1][j - nums[i - 1]]考虑的边界情况
                if (j - nums[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j]  //不装
                            || dp[i - 1][j - nums[i - 1]];  //装
                }
            }

        }

        return dp[nums.length][sum];
    }
}
