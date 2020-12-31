package com.leetcode.dynamicProgram.p200.p210.p213;

import java.util.Arrays;

/**
 * 213. 打家劫舍 II
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。
 *
 *
 * 示例1：
 *
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 示例 2：
 *
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *     偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：0
 *
 *
 * 提示：
 *
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber-ii/
 *
 * 思路：
 *      最高金额 -> 穷举 -> 动态规划
 *      dp数组或dp函数
 *          数组类型：从头到尾、只包含中间段移动、从尾到头
 *          本题属于从尾到头计算，根据函数签名，可以使用递归的思想
 *
 *      状态：
 *          走到的当前房子
 *      选择：
 *          抢或者不抢
 *      状态转移方程：
 *          dp[start]=x表示给定nums，从start位置开始抢，能拿到的最高金额是x
 *          求：dp(0)
 *          dp() = max(dp(start+1),  //当前不抢
 *                  dp(start+2) + nums[start])  //当前抢
 *      base case
 *          start>=length ,dp()=0
 *
 *      要注意的情况：
 *          因为是环形，所以头和尾不能同时抢，那也就是三种情况：
 *              抢头不抢尾，抢尾不抢头，头尾都不抢
 *          但是最后一种情况肯定没有前两种情况拿到的钱多，可以不用计算。
 *
 *      动态规划方法，由底到上
 */
public class Solution {

    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return nums[0];
        }

        return Math.max(robdp(nums, 0, length - 2),  //抢头不抢尾
                robdp(nums, 1, nums.length - 1));  //抢尾不抢头
    }

    //计算start 到end闭区间拿到钱的最大值，不用单独考虑收尾的处理
    private int robdp(int[] nums, int start, int end) {
        int[] dp = new int[nums.length + 2];
        Arrays.fill(dp, 0);
        for (int i = end; i >= start; i--) {
            dp[i] = Math.max(dp[i + 1], dp[i + 2] + nums[i]);
        }

        return dp[start];
    }
}
