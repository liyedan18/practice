package com.leetcode.array.p000.p040.p045;

import java.util.Arrays;

/**
 * 45. 跳跃游戏 II
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *     从下标为 0 跳到下标为 1 的位置，跳1步，然后跳3步到达数组的最后一个位置。
 * 说明:
 *
 * 假设你总是可以到达数组的最后一个位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game-ii
 *
 * 思路：
 *
 *      动态规划方法(类似55题的DFS方法)
 *      dp()定义
 *          dp(nums,start)表示从start开始，最少需要多少步才能到达最后一个位置
 *          状态：nums的索引
 *          选择：nums[start]可以跳几步
 *
 *          base case
 *              start>=dp.length-1, 结果是0，也就不需要跳
 *
 *          求dp(nums,0)
 *          加备忘录
 *
 *          时间复杂度：O(N*N) 超出时间限制
 *
 *
 *      同leetcode-55
 */
public class Solution {
    //备忘录
    private int[] note;

    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }

        note = new int[nums.length];
        //初始化,最多也就是nums.length步
        Arrays.fill(note, nums.length);

        return dp(nums, 0);
    }

    /**
     * 表示从start开始，最少需要多少步才能到达最后一个位置
     */
    private int dp(int[] nums, int start) {
        //base case
        if (start >= nums.length - 1) {
            return 0;
        }

        if (note[start] != nums.length) {
            return note[start];
        }

        //看nextStart中的那个dp最小，就选那个
        int minCount = nums.length;
        for (int i = 1; i <= nums[start]; i++) {
            int nextStart = start + i;
            //根据dp定义，得出nextStart最少需要多少步
            int nextStartCount = dp(nums, nextStart);
            minCount = Math.min(minCount, nextStartCount);
        }

        //当前结果 = nextStart算出的最小值+1
        note[start] = minCount + 1;
        return minCount + 1;
    }
}
