package com.leetcode.array.nSum.p001;


/**
 * 1. 两数之和
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 链接：https://leetcode-cn.com/problems/two-sum
 *
 * 方法三：
 *      如果数组是有序的，可以利用双指针技巧（左右指针）
 *      如果数组是无序的，Solution3不可行
 *
 * 时间复杂度：O(N)
 */

public class Solution3 {

    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int[] res = new int[2];
        while (left < right) {
            if (nums[left] + nums[right] < target) {
                left++;
            } else if (nums[left] + nums[right] > target) {
                right--;
            } else {
                return new int[]{left, right};
            }
        }

        return res;
    }
}
