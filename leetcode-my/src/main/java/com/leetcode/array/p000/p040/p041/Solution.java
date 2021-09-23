package com.leetcode.array.p000.p040.p041;

/**
 * 41. 缺失的第一个正数
 *
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 *
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 *  
 * 示例 1：
 *
 * 输入：nums = [1,2,0]
 * 输出：3
 * 示例 2：
 *
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 * 示例 3：
 *
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 5 * 105
 * -231 <= nums[i] <= 231 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-missing-positive
 *
 */
public class Solution {
    public int firstMissingPositive(int[] nums) {
        //在原地排序数组，nums[i]小于数组长度length的，则交换，负数则不动。
        //超过数组长度的，则该位置设置为-1
        //最后遍历数组，从下标1开始，看顺序对不对，不对就返回那个索引即可
        for (int i = 0; i < nums.length; i++) {
            sort(nums, i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (i + 1 != nums[i]) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }

    private void swap(int[] nums, int left, int right) {
        //避免sort死循环
        if (nums[left] == nums[right]) {
            nums[right] = -1;
            //nums[right]=-1;  //也可以，主要是消除重复
        }
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    private void sort(int[] nums, int i) {
        if (i + 1 == nums[i]) {
            return;
        }
        if (nums[i] <= nums.length && nums[i] > 0) {
            swap(nums, i, nums[i] - 1);
            //注意：这里递归可能会用到O(N)的空间复杂度，不符合要求
            sort(nums, i);
        } else if (nums[i] <= 0) {
            nums[i] = -1;
        } else if (nums[i] > nums.length) {
            nums[i] = -1;
        }
    }

}
