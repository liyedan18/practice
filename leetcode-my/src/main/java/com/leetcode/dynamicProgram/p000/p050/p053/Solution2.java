package com.leetcode.dynamicProgram.p000.p050.p053;

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
 *
 * 暴力解法，遍历所有结果(从开头到最后，组成所有的子序列)，找最大值
 *
 * 时间复杂度：
 *      O(N*N)
 *
 */
public class Solution2 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum = nums[j] + sum;
                if (sum > max) {
                    max = sum;
                }
            }
        }

        return max;
    }
}