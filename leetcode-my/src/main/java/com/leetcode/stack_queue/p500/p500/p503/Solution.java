package com.leetcode.stack_queue.p500.p500.p503;

import java.util.Stack;

/**
 * 503. 下一个更大元素 II
 *
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。
 * 数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，
 * 这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 *
 * 示例 1:
 *
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * 注意: 输入数组的长度不会超过 10000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-greater-element-ii
 *
 * 思路：
 *      求下一个更大元素，利用单调栈框架
 *      循环数组，可以考虑将原数组翻倍计算。
 *      或者取余。
 *
 *      翻倍遍历一次nums,然后将所有结果存储起来
 *
 *      时间复杂度O(n)
 */
public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null) {
            return null;
        }

        /**
         * 单调栈框架
         */
        int[] res = new int[nums.length];
        //存储数组的索引
        Stack<Integer> stackIndex = new Stack<>();
        //从最右向左遍历
        for (int i = 2 * nums.length - 1; i >= 0; i--) {
            int actualIndex = i % nums.length;
            //去除栈中比nums[i]小的元素
            while (!stackIndex.isEmpty() && nums[stackIndex.peek()] <= nums[actualIndex]) {
                stackIndex.pop();
            }

            res[actualIndex] = stackIndex.isEmpty() ? -1 : nums[stackIndex.peek()];

            stackIndex.push(actualIndex);
        }

        return res;
    }
}
