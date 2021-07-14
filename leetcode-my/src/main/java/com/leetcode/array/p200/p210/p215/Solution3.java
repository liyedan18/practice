package com.leetcode.array.p200.p210.p215;

import java.util.PriorityQueue;

/**
 * 215. 数组中的第K个最大元素
 *
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 *
 * 思路：
 *      优先队列（大顶堆、小顶堆）
 *
 */
public class Solution3 {
    public int findKthLargest(int[] nums, int k) {
        //使用大顶堆
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(nums.length, (a, b) -> (b - a));
        for (int i = 0; i < nums.length; i++) {
            maxHeap.add(nums[i]);
        }

        for (int i = 1; i < k; i++) {
            maxHeap.remove();
        }

        return maxHeap.peek();
    }
}
