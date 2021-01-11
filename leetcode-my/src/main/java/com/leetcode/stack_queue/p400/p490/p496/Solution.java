package com.leetcode.stack_queue.p400.p490.p496;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 496. 下一个更大元素 I
 *
 * 给定两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
 *
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
 *
 * 示例 1:
 *
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * 解释:
 *     对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
 *     对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
 *     对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
 * 示例 2:
 *
 * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出: [3,-1]
 * 解释:
 *     对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
 *     对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 *  
 *
 * 提示：
 *
 * nums1和nums2中所有元素是唯一的。
 * nums1和nums2 的数组大小都不超过1000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-greater-element-i
 *
 * 思路：
 *      利用单调栈框架
 *      先遍历一次nums2,然后将所有结果存储起来作为nums2Res[]
 *          或者，将结果存储到Map<nums2[i],nums2Res[i]>
 *      最后遍历nums1,从Map获取结果
 *
 *      时间复杂度O(n)
 */
public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[]{};
        }

        //存储Map<nums2[i],nums2Res[i]>
        Map<Integer, Integer> map = new HashMap<>();

        /**
         * 单调栈框架
         */
        //stack存储nums2的索引，也可以存储值
        Stack<Integer> stack = new Stack<>();

        //找右侧大值，从右开始向左遍历
        for (int i = nums2.length - 1; i >= 0; i--) {
            //保证stack中的数据要比当前数据大（stack是一个单调增栈）
            while (!stack.isEmpty() && nums2[stack.peek()] <= nums2[i]) {
                stack.pop();
            }

            // int index = stack.isEmpty() ? -1 : stack.peek();
            // map.put(nums2[i], nums2[index]);
            int index = -1;
            if (stack.isEmpty()) {
                index = -1;
                map.put(nums2[i], -1);
            } else {
                index = stack.peek();
                map.put(nums2[i], nums2[index]);
            }

            stack.push(i);
        }

        //遍历nums1,获取结果
        int[] res = new int[nums1.length];
        for (int i = 0; i <= nums1.length - 1; i++) {
            res[i] = map.get(nums1[i]);
        }

        return res;
    }

}
