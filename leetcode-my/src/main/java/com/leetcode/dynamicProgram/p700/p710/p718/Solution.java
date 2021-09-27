package com.leetcode.dynamicProgram.p700.p710.p718;

import java.util.Arrays;

/**
 * 718. 最长重复子数组
 *
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 *
 * 示例：
 *
 * 输入：
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出：3
 * 解释：
 * 长度最长的公共子数组是 [3, 2, 1] 。
 *
 * 提示：
 *
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 *
 */
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        //动态规划
        //定义：dp[i][j]为以nums[i-1]和nums[j-1]为结尾形成的公共子数组的长度
        //状态转移方程：dp[i][j]=dp[i-1][j-1]+1
        //那么就是求：dp[i][j]的最大值
        //初始化：dp[0][0]=0  dp[i][j]=0
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[][] dp = new int[length1 + 1][length2 + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], 0);
        }
        int res = 0;

        for (int i = 1; i < nums1.length + 1; i++) {
            for (int j = 1; j < nums2.length + 1; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    //也就是如果不想等，则不可能形成公共子数组
                    dp[i][j] = 0;
                }

                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}
