package com.leetcode.array.p000.p050.p055;

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
 *      这里，先贪心算法
 *          每次都选能跳到的最远位置（这中间的位置肯定是可以跳到的），然后计算最远能跳到哪里
 *
 *     总结：
 *          贪心算法和动态规划更好
 *
 *      同leetcode-45
 */
public class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }

        int furthest = 0;
        //最后一个位置不用计算
        for (int i = 0; i < nums.length - 1; i++) {
            //遇到nums[i]=0的情况,如果最远距离不超过i位置，则一定不能到达最后一个位置
            if (nums[i] == 0 && furthest <= i) {
                return false;
            }
            int temp = i + nums[i];
            furthest = Math.max(furthest, temp);
        }

        return furthest >= (nums.length - 1);
    }
}
