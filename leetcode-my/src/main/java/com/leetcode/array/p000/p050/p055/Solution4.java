package com.leetcode.array.p000.p050.p055;

import java.util.Arrays;

/**
 * 55. 跳跃游戏
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例2:
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game
 *
 * 思路：
 *      判断能否到达最后一个位置，也就是判断能否超过最后一个位置
 *      3种方法：
 *          DFS，将所有的答案都算出来，然后看能否满足
 *          动态规划
 *          贪心算法，用局部最优来一步一步优化全局最优
 *
 *      这里，动态规划
 *          定义：dp[i]表示[0...i]能否到达
 *              dp[i] = dp[j]&&(nums[j] + j >= i)   j=0...i-1
 *                  只要有一个能得出结果就可以退出了
 *
 *                  结果就是dp[n]
 */
public class Solution4 {

    public boolean canJump(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }

        boolean[] dp = new boolean[nums.length];
        Arrays.fill(dp, false);
        //base case
        dp[0] = true;

        for (int i = 1; i < nums.length; i++) {
            //遍历之前的所有nums[i]，计算是否能到达i位置dp[i]
            for (int j = i - 1; j >= 0; j--) {
                //找到一个即退出循环
                if (dp[j] && (nums[j] + j >= i)) {
                    dp[i] = true;
                    break;
                }
            }

            //当前i位置不能到达，则直接退出
            if (!dp[i]) {
                break;
            }
        }

        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        Solution4 s = new Solution4();
        System.out.println(s.canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(s.canJump(new int[]{2, 0, 0}));
    }
}
