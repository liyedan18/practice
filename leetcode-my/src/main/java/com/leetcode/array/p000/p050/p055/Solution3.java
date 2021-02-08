package com.leetcode.array.p000.p050.p055;

import java.util.HashMap;
import java.util.Map;

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
 *      这里，DFS
 *          遍历出来所有结果
 *          优化DFS，用备忘录
 *
 *          会超出时间限制
 */
public class Solution3 {
    //用一个标志表示结果
    private boolean flag;

    private Map<Integer, Boolean> note;

    public boolean canJump(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }

        flag = false;
        note = new HashMap<>();
        dfs(nums, 0);
        return flag;
    }

    private void dfs(int[] nums, int start) {
        //只需要有一个满足条件，就可以返回
        if (start >= nums.length - 1) {
            flag = true;
            return;
        }
        if (note.containsKey(start)){
            return;
        }
        if (nums[start] == 0) {
            note.put(start, flag);
            return;
        }

        //从1开始，到nums[start]结束
        for (int i = 1; i <= nums[start]; i++) {
            int nextStart = start + i;
            if (note.containsKey(nextStart)) {
                continue;
            }
            dfs(nums, nextStart);
            note.put(nextStart, flag);
        }
    }
}
