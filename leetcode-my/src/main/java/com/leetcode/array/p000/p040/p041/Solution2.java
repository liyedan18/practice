package com.leetcode.array.p000.p040.p041;

import java.util.HashSet;
import java.util.Set;

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
public class Solution2 {
    public int firstMissingPositive(int[] nums) {
        //用集合保存所有数组内容，然后再从1开始比较那些正整数没有
        //空间复杂度不满足要求，但思路不错
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for (int i = 1; i <= nums.length + 1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }

        return nums.length + 1;
    }
}
