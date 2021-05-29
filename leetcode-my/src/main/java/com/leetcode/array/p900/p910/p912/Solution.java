package com.leetcode.array.p900.p910.p912;

import java.util.Random;

/**
 * 912. 排序数组
 *
 * 给你一个整数数组 nums，请你将该数组升序排列。
 *
 * 示例 1：
 *
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：nums = [5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 50000
 * -50000 <= nums[i] <= 50000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-an-array
 *
 * 思路：
 *      优化后的快速排序
 *
 */
public class Solution {
    public int[] sortArray(int[] nums) {
        //快速排序
        //分治算法，找到key元素，然后比key小的放到左边，比key大的放到右边
        quickSort(nums, 0, nums.length - 1);

        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (right <= left) {
            return;
        }

        //随机取基准值,避免最坏的情况
        Random rand = new Random();
        int index = rand.nextInt(right - left + 1);
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
        //退出循环后，i=j+1
        swap(nums, i, right);

        quickSort(nums, left, i - 1);
        quickSort(nums, i + 1, right);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
