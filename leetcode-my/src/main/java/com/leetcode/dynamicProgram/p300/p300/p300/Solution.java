package com.leetcode.dynamicProgram.p300.p300.p300;


import java.util.Arrays;

/**
 * 300. 最长上升子序列
 *
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 *
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 *
 * 思路
 *      动态规划法：
 *          1.确定dp数组的定义
 *              dp[i]表示nums[i]的元素的最长上升子序列的长度
 *          2.base case
 *              dp[0]=1,
 *              所有数的初始值都是1，最长子序列要算上自己
 *          3.画图推导dp[i](数学归纳法)
 *              画出数组图，假设已经知道了dp[0,1,...,n-1]，怎么推导出dp[i]
 *                  类似递归方法的推导思想
 *              dp[i]=nums中i之前的那些比nums[i]小的长度的最大值 + 1
 *
 *          4.最后返回dp[i]中的最大值
 *
 *          注意数组边界问题
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        //base case
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        //计算dp[i]
        for (int i = 1; i <= nums.length - 1; i++) {
            //遍历i之前的所有数
            for (int j = 0; j < i; j++) {
                //找到比nums[i]小的数
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        //找到dp[]中的最大值
        int res = 0;
        for (int k = 0; k <= nums.length - 1; k++) {
            res = Math.max(res, dp[k]);
        }
        //同下
        // res = Arrays.stream(dp).max().getAsInt();

        return res;
    }
}
