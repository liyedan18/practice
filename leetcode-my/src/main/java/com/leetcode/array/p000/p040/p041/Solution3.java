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
 *  满足要求的最优解
 */
public class Solution3 {
    public int firstMissingPositive(int[] nums) {
        //还是使用原地哈希的方式，迭代进行排序
        //nums存储的应该是[1...n+1]的数,也就是元素y要存在y-1的位置上
        //遍历时，索引i位置的元素值x=nums[i],应该在（x-1）的位置
        //交换两个位置的元素，也就是交换nums[x-1]和nums[i],即nums[nums[i]-1]和nums[i] ******
        //为了闭环死循环，也就是nums[x-1]=nums[i],当不相等时才交换

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] != i) {
                return i;
            }
        }

        return nums.length + 1;
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
