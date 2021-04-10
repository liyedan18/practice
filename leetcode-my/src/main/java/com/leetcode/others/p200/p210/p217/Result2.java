package com.leetcode.others.p200.p210.p217;

import java.util.Arrays;

/**
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 *
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate
 */

public class Result2 {
    public boolean containsDuplicate(int[] nums) {
        return Arrays.stream(nums).distinct().toArray().length != nums.length;
    }

    public static void main(String[] args) {
        Result2 result1 = new Result2();
        int[] nums1 = {1,2,3,4};
        int[] nums2 = {1,2,3,1};
        int[] nums3 = {1,2,3,4,6,9,0,1};
        int[] nums4 = {1,1,1,1,2,3,4};
        System.out.println(result1.containsDuplicate(nums1));;
        System.out.println(result1.containsDuplicate(nums2));;
        System.out.println(result1.containsDuplicate(nums3));;
        System.out.println(result1.containsDuplicate(nums4));;
    }
}
