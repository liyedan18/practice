package com.leetcode.array.p200.p210.p215;

import java.util.Random;

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
 *      优化后的快速排序
 *      时间复杂度：O(NlogN)
 *      空间复杂度：O(1)
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        //快速排序
        quickSort(nums, 0, nums.length-1, k);
        return nums[nums.length - k];
    }

    private void quickSort(int[] nums, int left, int right, int k) {
        if (left >= right) {
            return;
        }

        //随机取基准值
        Random random = new Random();
        int index = random.nextInt(right - left + 1);
        swap(nums, left + index, right);

        int i = left;
        int j = right - 1;
        while (i <= j) {
            if (nums[i] <= nums[right]) {
                i++;
            } else {
                swap(nums, i, j);
                j--;
            }
        }

        swap(nums, i, right);
        if (i == nums.length - k) {
            return;
        }

        quickSort(nums, left, i - 1, k);
        quickSort(nums, i + 1, right, k);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
