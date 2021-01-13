package com.leetcode.stack_queue.p700.p730.p739;

import java.util.Stack;

/**
 * 739. 每日温度
 *
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：
 * 要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/daily-temperatures
 *
 * 思路：
 *      其实也是求下一个更大元素的位置，利用单调栈框架。同496、503题
 *
 *      时间复杂度O(n)
 */
public class Solution {
    public int[] dailyTemperatures(int[] temps) {
        if (temps == null) {
            return null;
        }

        /**
         * 单调栈框架
         */
        int[] resIndex = new int[temps.length];
        //存储下一个更大结果的索引
        Stack<Integer> stack = new Stack<>();
        //从最右侧向左遍历
        for (int i = temps.length - 1; i >= 0; i--) {
            //去除比当前元素小的值
            while (!stack.isEmpty() && temps[stack.peek()] <= temps[i]) {
                stack.pop();
            }

            resIndex[i] = stack.isEmpty() ? 0 : stack.peek();

            stack.push(i);
        }

        int[] res = new int[temps.length];
        for (int i = 0; i <= temps.length - 1; i++) {
            if (resIndex[i] == 0) {
                res[i] = 0;
            } else {
                res[i] = resIndex[i] - i;
            }
        }

        return res;
    }
}
