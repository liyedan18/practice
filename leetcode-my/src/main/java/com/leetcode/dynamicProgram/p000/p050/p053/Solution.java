package com.leetcode.dynamicProgram.p000.p050.p053;

import java.util.Arrays;

/**
 * 53. 最大子序和
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * dp数组定义：
 *      dp[i]表示nums[0.。。i]的最大连续子数组和
 *          结果为dp[i]
 *          不可行
 *
 *      dp[i]表示以nums[i]结尾的最大连续子数组和为dp[i]
 *          结果为dp[]数组的最大值
 *          多一步比较最大值
 *
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        //初始化
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MIN_VALUE);

        //base case
        dp[0] = nums[0];
        //dp[i]等于自己，或者dp[i]等于dp[i-1]+自己
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }

        int res = Arrays.stream(dp).max().getAsInt();
        // for (int i = 0; i < dp.length; i++) {
        //     res = Math.max(res, dp[i]);
        // }
        return res;
    }
}