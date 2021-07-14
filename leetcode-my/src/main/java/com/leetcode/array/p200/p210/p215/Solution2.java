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
 *      同时，在排序过程中判断是否是第k个最大元素
 *      时间复杂度：O(N)
 *      空间复杂度：O(1)
 *
 */
public class Solution2 {
    public int findKthLargest(int[] nums, int k) {

        int left = 0;
        int right = nums.length - 1;

        while (true) {
            //每次排序会确定i位置的一个元素
            int tempIndex = quickSort(nums, left, right);
            if (tempIndex == nums.length - k) {
                return nums[tempIndex];
            } else if (tempIndex < nums.length - k) {
                //正确排序的值的索引小于倒数第k个位置的索引，则k在右边
                left = tempIndex + 1;
            } else {
                //正确排序的值的索引大于倒数第k个位置的索引，则k在左边
                right = tempIndex - 1;
            }
        }
    }

    //每次排序会确定i位置的一个元素
    private int quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return left;
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
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
